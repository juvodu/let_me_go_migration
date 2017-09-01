package com.juvodu.lmg.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Locale;

import com.juvodu.lmg.model.Continent;
import com.juvodu.lmg.model.Country;
import com.juvodu.lmg.model.Position;
import com.juvodu.lmg.util.Constants;
import com.juvodu.lmg.util.CountryUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.javadocmd.simplelatlng.LatLng;
import com.juvodu.lmg.model.Spot;
import com.opencsv.CSVReader;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class MigrationService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final RestTemplate restTemplate = new RestTemplate();
	
	/**
	 * Import Spots from CSV to AWS
	 * @return
	 */
	public void importSpotsFromCsv(){
		
		int spotsAdded = 0;
        final String csvFileName = "Surfspots.csv";
        final List<Locale> locales = CountryUtil.getLocales();

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File csvFile = new File(classLoader.getResource(csvFileName).getFile());

        log.info("Importing Spots from CSV.");
        try(CSVReader reader = new CSVReader(new FileReader(csvFile), ';')) {
            String[] line;

            //skip header line
            reader.readNext();

            while ((line = reader.readNext()) != null) {

                Spot spot = new Spot();
                String latitudeStr = line[6];
                String longitudeStr = line[7];
                double latitude = 0;
                double longitude = 0;

                if(!StringUtils.isBlank(latitudeStr) && !StringUtils.isBlank(longitudeStr)){
                    try{
                        latitude = Double.valueOf(latitudeStr);
                        longitude = Double.valueOf(longitudeStr);
                    }catch(NumberFormatException e){}
                }

                String name = line[0].replace("_", " ");
                String continentName = line[1].replace("_", "");
                String countryName = line[2].replace("_", " ");
                Country country = CountryUtil.getCountryForName(locales, countryName);
                Continent continent = Continent.valueOf(continentName);
                if(country == null || continent == null){
                    continue;
                }

                spot.setName(name);
                spot.setContinent(continent.getCode());
                spot.setCountry(country);
                spot.setPosition(new Position(latitude, longitude));
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

                spotsAdded++;

                MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
                headers.add("x-api-key", Constants.API_KEY);
                headers.add("Content-Type", "application/json");
                HttpEntity<Spot> request = new HttpEntity<>(spot, headers);
                restTemplate.postForLocation(Constants.API_ENDPOINT, request);
                log.debug(spot.toString());
            }
            log.info("Migrated " + spotsAdded + " Spots from CSV to Database.");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
