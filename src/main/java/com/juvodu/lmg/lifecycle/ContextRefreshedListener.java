package com.juvodu.lmg.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.juvodu.lmg.service.MigrationService;

@Component
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent>{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MigrationService migrationService;
	
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("Context Refreshed Event received");
        
        int migrationChangelog = 0;
        switch(migrationChangelog){
        	case 0:
        		migrationService.importSpotsFromCsv();
        		break;
	        default: 
	        	log.warn("No Migration Script available for the current changelog.");
	        	break;	
        }
    }
}
