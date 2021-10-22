package com.freecharge.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freecharge.entities.Plan;

@Repository
public interface PlanRepo extends JpaRepository<Plan, Integer> {

}
