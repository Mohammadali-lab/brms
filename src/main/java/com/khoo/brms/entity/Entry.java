package com.khoo.brms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isInput;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    @JsonIgnore
    private Rule rule;

    @ManyToOne
    @JoinColumn(name = "expression_id")
    private Expression expression;

    @ManyToOne
    @JoinColumn(name = "unary_test_id")
    UnaryTest unaryTest;
}
