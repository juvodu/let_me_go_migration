package com.juvodu.lmg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javadocmd.simplelatlng.LatLng;
import com.juvodu.lmg.model.Spot;
import com.juvodu.lmg.repository.SpotRepository;

@Service
public class SpotService {
	
	private List<Spot> spots;
	
	@Autowired
	SpotRepository spotRepository;
	
	public Spot getNextSpot(LatLng position){
		
		//lazy loading
		if(spots == null){
			this.spots = (List<Spot>) spotRepository.findAll();
		}
		
		//get spot with minimal distance
		
		return null;
	}
}
