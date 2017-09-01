package com.juvodu.lmg.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.juvodu.lmg.service.MigrationService;

@Component
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent>{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MigrationService migrationService;
	
	@Value("${com.juvodu.lmg.migration.changelog}")
	private int changelog;
	
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

		log.info("Starting spots import.");

		migrationService.importSpotsFromCsv();

		log.info("Import Complete.");
    }
}
