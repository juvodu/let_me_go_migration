package com.juvodu.lmg.lifecycle;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.juvodu.lmg.model.ChangeLog;
import com.juvodu.lmg.repository.ChangeLogRepository;
import com.juvodu.lmg.service.MigrationService;

@Component
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent>{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MigrationService migrationService;
	
	@Autowired
	private ChangeLogRepository changelogRepository;
	
	@Value("${com.juvodu.lmg.migration.changelog}")
	private int changelog;
	
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    	
        log.info("Context Refreshed Event received.");
        
        // get state of DB and use as start index
        //int dbChangelog = getDBChangelogVersion();
        int dbChangelog = 0;
        
        //TODO: skip for unit tests
        if(changelog > dbChangelog){
        	
        	log.info("Starting Migration.");
	        for(int i = dbChangelog + 1; i <= changelog; i++){
	        	migrationService.migrate(i);
	        }
	        
	        // update changelog version of DB
	        changelogRepository.save(new ChangeLog(changelog));
	        log.info("Migration Complete.");
        }
    }
    
    private int getDBChangelogVersion(){
    	
    	int dbChangelogVersion = 0;
        Iterator<ChangeLog> it = changelogRepository.findAll().iterator();
        while(it.hasNext()){
        	
        	ChangeLog changeLog = it.next();
        	if(changeLog.getVersion() > dbChangelogVersion){
        		dbChangelogVersion = changeLog.getVersion();
        	}
        }
        return dbChangelogVersion;
    }
}
