package com.juvodu.lmg.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.juvodu.lmg.model.Spot;

@EnableScan
public interface SpotRepository extends CrudRepository<Spot, String> {
	
	Spot findById(String id);
}