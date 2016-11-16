package rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rest.model.Match;

@RestController
public class MatchController {
	

    @RequestMapping("/match")
    public Match getMatch(@RequestParam(value="id", defaultValue="1") String id) {
    	Match match = new Match();
    	match.setId(id);
    	match.setText("Nice Ride Alert!");
        return match;
    }
}
