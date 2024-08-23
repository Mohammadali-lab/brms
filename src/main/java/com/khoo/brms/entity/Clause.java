package com.khoo.brms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Clause {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isInput;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expression_id")
    private Expression expression;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clause")
    private List<UnaryTest> unaryTests = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "decision_table_id")
    private DecisionTable decisionTable;
}
