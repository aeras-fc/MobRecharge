package com.freecharge.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.freecharge.entities.Plan;

public interface PlanRepo extends JpaRepository<Plan,Integer>{

}

