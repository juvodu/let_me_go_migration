package com.juvodu.lmg.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.javadocmd.simplelatlng.LatLng;

public class LatLngTypeConverter implements DynamoDBTypeConverter<String, LatLng> {

	@Override
	public String convert(LatLng position) {
		
		String positionStr = null;
		try {
            if (position != null) {
            	positionStr = String.format("%s ; %s", position.getLatitude(), position.getLongitude());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return positionStr;
	}

	@Override
	public LatLng unconvert(String s) {
		
		double latitude = 0;
		double longitude = 0;
        try {
            if (s != null && s.length() != 0) {
                String[] data = s.split(";");
                latitude = Double.valueOf(data[0].trim());
                longitude = Double.valueOf(data[1].trim());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new LatLng(latitude, longitude);
	}
}
