package com.juvodu.lmg.model.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.juvodu.lmg.model.Country;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

/**
 * Created by Juvodu on 05.06.17.
 */
public class CountryTypeConverter implements DynamoDBTypeConverter<String, Country> {

    @Override
    public String convert(Country country) {

        String countryStr = null;
        try {
            if (country != null) {
                countryStr = country.getCode();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return countryStr;
    }

    @Override
    public Country unconvert(String countryString) {

        Country country = null;
        try{
            if(StringUtils.isNotBlank(countryString)) {
                Locale locale = new Locale("", countryString);
                country = new Country(locale.getCountry(), locale.getDisplayName());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return country;
    }
}
