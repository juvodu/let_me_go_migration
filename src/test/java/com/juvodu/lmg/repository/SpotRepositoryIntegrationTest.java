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
import com.javadocmd.simplelatlng.LatLng;
import com.juvodu.lmg.App;
import com.juvodu.lmg.model.Spot;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class SpotRepositoryIntegrationTest {
	
	private DynamoDBMapper dynamoDBMapper;
	
    @Autowired
    private AmazonDynamoDB amazonDynamoDB;
    
    @Autowired
    SpotRepository spotRepository;
    
    @Before
    public void setup() throws Exception {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        
        CreateTableRequest createTableRequest = dynamoDBMapper.generateCreateTableRequest(Spot.class);
        ProvisionedThroughput provisionedThroughput = new ProvisionedThroughput(1L, 1L);
        createTableRequest.setProvisionedThroughput(provisionedThroughput);
        TableUtils.createTableIfNotExists(amazonDynamoDB, createTableRequest);
                 
        spotRepository.deleteAll();
    }
    
    @Test
    public void whenRetrieveAllSpotAfterStoringThenResultNotEmpty() {
    	
        Spot spot = new Spot();
        spot.setPosition(new LatLng(1, 1));
        spotRepository.save(spot);
 
        List<Spot> result = (List<Spot>) spotRepository.findAll();
        assertTrue("Could not retrieve Spot", result.size() > 0);
    }
}
