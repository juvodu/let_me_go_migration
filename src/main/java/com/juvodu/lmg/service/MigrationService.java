package com.juvodu.lmg.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juvodu.lmg.model.Spot;
import com.juvodu.lmg.repository.SpotRepository;
import com.opencsv.CSVReader;

@Service
public class MigrationService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SpotRepository spotRepository;
	
	/**
	 * Import Spots from CSV to Database
	 * @return
	 */
	public int importSpotsFromCsv(){
		
		int spotsAdded = 0;
		 String csvFileName = "Surfspots.csv";
	        //Get file from resources folder
	    	ClassLoader classLoader = getClass().getClassLoader();
	    	File csvFile = new File(classLoader.getResource(csvFileName).getFile());
	    	
	    	log.info("Importing Spots from CSV.");
	        try(CSVReader reader = new CSVReader(new FileReader(csvFile), ';')) {
	            String[] line;
	            
	            while ((line = reader.readNext()) != null) {
	            	
	            	Spot spot = new Spot();
	            	spot.setName(line[0]);
	            	spot.setContinent(line[1]);
	            	spot.setCountry(line[2]);
	            	spot.setCountry(line[2]);
	            	spot.setLatitude(line[6]);
	            	spot.setLongitude(line[7]);
	            	
	            	String walk = line[9].replace("&amp;lt;", "<").replace("&gt;", ">");
	            	spot.setWalk(walk);
	            	spot.setWaveQuality(line[13]);
	            	spot.setExperience(line[14]);
	            	spot.setFrequency(line[15]);
	            	spot.setType(line[16]);
	            	spot.setDirection(line[17]);
	            	spot.setBottom(line[18]);
	            	spot.setPower(line[19]);
	            	spot.setNormalDayLength(line[20]);
	            	spot.setGoodDayLength(line[21]);
	            	spot.setGoodSwellDirection(line[22]);
	            	spot.setGoodWindDirection(line[23]);
	            	spot.setSwellSize(line[24]);
	            	spot.setBestTidePosition(line[25]);
	            	spot.setBestTideMovement(line[26]);
	            	spot.setWeekCrowd(line[27]);
	            	spot.setWeekEndCrowd(line[28]);
	            	
	            	spot = spotRepository.save(spot);
	            	spotsAdded++;
	            	log.debug(spot.toString());
	            }
	            log.info("Migrated " + spotsAdded + " Spots from CSV to Database.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return spotsAdded;
	}
}
