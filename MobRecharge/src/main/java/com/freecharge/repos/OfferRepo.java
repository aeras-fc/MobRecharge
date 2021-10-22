package com.freecharge.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freecharge.entities.Offer;

@Repository
public interface OfferRepo extends JpaRepository<Offer, Integer> {

}
