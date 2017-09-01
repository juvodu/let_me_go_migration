package com.juvodu.lmg.model.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshaller;
import com.juvodu.lmg.model.Country;

/**
 * Created by Juvodu on 05.06.17.
 */
public class CountryMarshaller implements DynamoDBMarshaller<Country> {

    @Override
    public String marshall(Country getterReturnResult) {
        return null;
    }

    @Override
    public Country unmarshall(Class<Country> clazz, String obj) {
        return null;
    }
}
