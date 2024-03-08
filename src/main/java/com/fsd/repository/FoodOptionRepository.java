package com.fsd.repository;

import com.fsd.entity.FoodOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOptionRepository extends JpaRepository<FoodOption, Long> {
}
