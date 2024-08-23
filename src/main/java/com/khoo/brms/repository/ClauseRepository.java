package com.khoo.brms.repository;

import com.khoo.brms.entity.Clause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClauseRepository extends JpaRepository<Clause, Long> {

    Optional<Clause> findByExpression_id(Long exId);
}
