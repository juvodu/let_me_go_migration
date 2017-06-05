package com.juvodu.lmg.model.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.juvodu.lmg.model.Continent;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Juvodu on 05.06.17.
 */
public class ContinentTypeConverter implements DynamoDBTypeConverter<String, Continent> {

    @Override
    public String convert(Continent continent) {

        String continentStr = null;
        try {
            if (continent != null) {
                continentStr = continent.getCode();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return continentStr;
    }

    @Override
    public Continent unconvert(String continentStr) {

        Continent continent = null;
        try{
            if(StringUtils.isNotBlank(continentStr)){
                continent = Continent.valueOf(continentStr);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return continent;
    }
}
