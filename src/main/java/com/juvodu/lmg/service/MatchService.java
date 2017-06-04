package com.juvodu.lmg.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juvodu.forecast.controller.WWOMClient;
import com.juvodu.forecast.exception.WWOMClientException;
import com.juvodu.forecast.model.Forecast;
import com.juvodu.lmg.model.Match;
import com.juvodu.lmg.model.Spot;
import com.juvodu.lmg.repository.SpotRepository;

@Service
public class MatchService {
	
	@Autowired
	SpotRepository spotRepository;
	
	public List<Match> getMatches(){
		
		WWOMClient client = new WWOMClient();
    	Iterator<Spot> i = spotRepository.findAll().iterator();
    	List<Match> matches = new ArrayList<>();
    	while (i.hasNext()){
    		Spot spot = i.next();
    		Match match = new Match();
    		match.setName(spot.getName());
    		match.setSpot(spot);
    		
    		try {
    			//TODO: fix this...api threshold reached to fast
        		Forecast forecast = client.getForecast(spot.getPosition().getLatitude() + "," + spot.getPosition().getLongitude());
    	    	match.setForecast(forecast);
    	    	matches.add(match);
    		} catch (WWOMClientException e) {
    			e.printStackTrace();
    		}
    	}
    	
    	return matches;
	}
}
