package com.khoo.brms.controller;

import com.khoo.brms.entity.Clause;
import com.khoo.brms.entity.Entry;
import com.khoo.brms.entity.Rule;
import com.khoo.brms.service.DecisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/decision-element")
@RequiredArgsConstructor
public class DecisionController {

    private final DecisionService decisionService;
    @PostMapping("/clause")
    public Clause insertClause(@RequestBody Clause clause){
        return decisionService.saveClause(clause);
    }

    @PostMapping("/rule")
    public Rule insertRule(@RequestBody Rule rule){ return decisionService.saveRule(rule);}
}
