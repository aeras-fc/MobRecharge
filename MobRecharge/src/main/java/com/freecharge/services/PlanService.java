package com.freecharge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freecharge.entities.Plan;
import com.freecharge.repos.PlanRepo;

@Service
public class PlanService {

	@Autowired
	PlanRepo planRepo;

	public boolean isPresent(Integer id) {
		return planRepo.existsById(id);
	}

	public List<Plan> getAll() {
		return planRepo.findAll();
	}

}
