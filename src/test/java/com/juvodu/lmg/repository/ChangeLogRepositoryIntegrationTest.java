package com.juvodu.lmg.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.juvodu.lmg.App;
import com.juvodu.lmg.model.ChangeLog;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class ChangeLogRepositoryIntegrationTest {
	
	private DynamoDBMapper dynamoDBMapper;
	
    @Autowired
    private AmazonDynamoDB amazonDynamoDB;
    
    @Autowired
    ChangeLogRepository changeLogRepository;
    
    @Before
    public void setup() throws Exception {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        
        CreateTableRequest createTableRequest = dynamoDBMapper.generateCreateTableRequest(ChangeLog.class);
        createTableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
        TableUtils.createTableIfNotExists(amazonDynamoDB, createTableRequest);
                 
        changeLogRepository.deleteAll();
    }
    
    @Test
    public void test(){
    	
    	ChangeLog changeLog = new ChangeLog(1);
    	changeLogRepository.save(changeLog);
    	
    	List<ChangeLog> changeLogs = (List<ChangeLog>)changeLogRepository.findAll();
    	assertTrue(changeLogs.size() >0);
    }
}
