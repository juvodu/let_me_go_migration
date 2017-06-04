package com.juvodu.lmg.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.juvodu.lmg.model.ChangeLog;

@EnableScan
public interface ChangeLogRepository extends CrudRepository<ChangeLog, String>{
		
}
