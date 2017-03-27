package com.juvodu.lmg.model;

import com.juvodu.forecast.model.Forecast;

public class Match {
	
	private String id;
	
	private String name;

	private Forecast forecast;
	
	private Spot spot;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Forecast getForecast() {
		return forecast;
	}

	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}
}
