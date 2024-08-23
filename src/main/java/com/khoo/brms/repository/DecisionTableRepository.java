package com.khoo.brms.repository;

import com.khoo.brms.entity.DecisionTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecisionTableRepository extends JpaRepository<DecisionTable, Long> {
}
