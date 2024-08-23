package com.khoo.brms.service;

import com.khoo.brms.entity.*;
import com.khoo.brms.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DecisionService {

    private final ClauseRepository clauseRepository;
    private final DecisionTableRepository decisionTableRepository;
    private final EntryRepository entryRepository;
    private final ExpressionRepository expressionRepository;
    private final RuleRepository ruleRepository;
    private final UnaryTestRepository unaryTestRepository;


    public Clause saveClause(Clause clause){
        clause.getUnaryTests().forEach(unaryTest -> unaryTest.setClause(clause));
        return clauseRepository.save(clause);
    }

    private Entry saveEntry(Entry entry){
        Expression expression = entry.getExpression();
        UnaryTest unaryTest = entry.getUnaryTest();
        if(expression.getId()==null){
            Clause clause = new Clause();
            clause.setInput(entry.isInput());
            clause.setExpression(expression);
            unaryTest.setClause(clause);
            clause.getUnaryTests().add(unaryTest);
            clauseRepository.save(clause);
        } else if(unaryTest.getId()==null){
            Clause clause = clauseRepository.findByExpression_id(expression.getId()).orElseThrow();
            unaryTest.setClause(clause);
            unaryTestRepository.save(unaryTest);
        }
        return entryRepository.save(entry);
    }

    public Rule saveRule(Rule rule){
        rule = ruleRepository.save(rule);
        List<Entry> entries = rule.getEntries();
        for(Entry entry: entries){
            entry.setRule(rule);
            saveEntry(entry);
        }
        return rule;
    }

    public DecisionTable saveDecisionTable(DecisionTable decisionTable){
        return decisionTableRepository.save(decisionTable);
    }

    public Expression saveExpression(Expression expression){
        return expressionRepository.save(expression);
    }

    public UnaryTest saveUnaryTest(UnaryTest unaryTest){
        return unaryTestRepository.save(unaryTest);
    }

}
