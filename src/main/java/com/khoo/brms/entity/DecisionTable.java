package com.khoo.brms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class DecisionTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "decisionTable")
    List<Rule> rules = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "decisionTable")
    List<Clause> clauses = new ArrayList<>();
}
