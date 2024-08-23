package com.khoo.brms.repository;

import com.khoo.brms.entity.UnaryTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnaryTestRepository extends JpaRepository<UnaryTest, Long> {
}
