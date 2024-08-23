package com.khoo.brms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long priority;

    @OneToMany(mappedBy = "rule")
    List<Entry> entries = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "decision_table_id")
    private DecisionTable decisionTable;
}
