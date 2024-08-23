package com.khoo.brms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UnaryTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "some_value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "clause_id")
    @JsonIgnore
    private Clause clause;
}
