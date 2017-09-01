package com.juvodu.lmg.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Spot{

	private String name;

	private String shortDescription;

	private String thumbnail;

	private Position position;

	private Country country;

	private String description;

	private String image;

	private String continent;

	private String walk;

	private String waveQuality;

	private String experience;

	private String frequency;

	private String type;

	private String direction;

	private String bottom;

	private String power;

	private String normalDayLength;

	private String goodDayLength;

	private String goodSwellDirection;

	private String goodWindDirection;

	private String swellSize;

	private String bestTidePosition;

	private String bestTideMovement;

	private String weekCrowd;

	private String weekEndCrowd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getWalk() {
		return walk;
	}

	public void setWalk(String walk) {
		this.walk = walk;
	}

	public String getWaveQuality() {
		return waveQuality;
	}

	public void setWaveQuality(String waveQuality) {
		this.waveQuality = waveQuality;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getBottom() {
		return bottom;
	}

	public void setBottom(String bottom) {
		this.bottom = bottom;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getNormalDayLength() {
		return normalDayLength;
	}

	public void setNormalDayLength(String normalDayLength) {
		this.normalDayLength = normalDayLength;
	}

	public String getGoodDayLength() {
		return goodDayLength;
	}

	public void setGoodDayLength(String goodDayLength) {
		this.goodDayLength = goodDayLength;
	}

	public String getGoodSwellDirection() {
		return goodSwellDirection;
	}

	public void setGoodSwellDirection(String goodSwellDirection) {
		this.goodSwellDirection = goodSwellDirection;
	}

	public String getGoodWindDirection() {
		return goodWindDirection;
	}

	public void setGoodWindDirection(String goodWindDirection) {
		this.goodWindDirection = goodWindDirection;
	}

	public String getSwellSize() {
		return swellSize;
	}

	public void setSwellSize(String swellSize) {
		this.swellSize = swellSize;
	}

	public String getBestTidePosition() {
		return bestTidePosition;
	}

	public void setBestTidePosition(String bestTidePosition) {
		this.bestTidePosition = bestTidePosition;
	}

	public String getBestTideMovement() {
		return bestTideMovement;
	}

	public void setBestTideMovement(String bestTideMovement) {
		this.bestTideMovement = bestTideMovement;
	}

	public String getWeekCrowd() {
		return weekCrowd;
	}

	public void setWeekCrowd(String weekCrowd) {
		this.weekCrowd = weekCrowd;
	}

	public String getWeekEndCrowd() {
		return weekEndCrowd;
	}

	public void setWeekEndCrowd(String weekEndCrowd) {
		this.weekEndCrowd = weekEndCrowd;
	}

	public String toString() {
	 return new ToStringBuilder(this).
			 append("name", name).
			 append("description", description).
			 append("longitude", position.getLongitude()).
			 append("latitude", position.getLongitude()).
			 append("continent", continent).
			 append("country", country).
			 append("walk", walk).
			 append("waveQuality", waveQuality).
			 append("experience", experience).
			 append("frequency", frequency).
			 append("type", type).
			 append("direction", direction).
			 append("bottom", bottom).
			 append("power", power).
			 append("normalDayLength", normalDayLength).
			 append("goodDayLength", goodDayLength).
			 append("goodSwellDirection", goodSwellDirection).
			 append("goodWindDirection", goodWindDirection).
			 append("swellSize", swellSize).
			 append("bestTidePosition", bestTidePosition).
			 append("bestTideMovement", bestTideMovement).
			 append("weekCrowd", weekCrowd).
			 append("weekEndCrowd", weekEndCrowd).
			 toString();
   }
}
