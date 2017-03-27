package com.juvodu.lmg.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.juvodu.lmg.model.Spot;
import com.juvodu.lmg.repository.SpotRepository;

@RestController
@RequestMapping("/spot")
public class SpotController {
	
	@Autowired
	SpotRepository spotRepository;
	 
    @RequestMapping("/all")
    public List<Spot> getAllSpots() {
    	
    	Iterator<Spot>i = spotRepository.findAll().iterator();
    	
    	List<Spot> spots = new ArrayList<>();
    	while (i.hasNext()){
    		spots.add(i.next());
    	}
    	
    	return spots;
    }
    
    @RequestMapping("/{id}")
    public Spot getSpot(@PathVariable String id) {    	
    	
    	return spotRepository.findById(id);
    }
    
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addSpot(@RequestBody Spot spot){
		
    	Spot newSpot = spotRepository.save(spot);  
    	
    	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newSpot.getId()).toUri();

		return ResponseEntity.created(location).build();
    }
}
