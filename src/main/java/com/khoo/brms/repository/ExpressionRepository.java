package com.khoo.brms.repository;

import com.khoo.brms.entity.Expression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpressionRepository extends JpaRepository<Expression, Long> {
}
