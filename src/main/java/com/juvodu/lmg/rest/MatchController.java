package com.juvodu.lmg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juvodu.lmg.model.Match;
import com.juvodu.lmg.service.MatchService;

@RestController
@RequestMapping("/match")
public class MatchController {
	
    @Autowired
    MatchService matchService;
    
    @RequestMapping("/all")
    public List<Match> getMatches() {
    	
        return matchService.getMatches();
    }
}
