package com.juvodu.lmg.util;

import com.juvodu.lmg.model.Country;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Created by Juvodu on 05.06.17.
 */
public class CountryUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void givenGermanyWhenGetCountryForNameThenReturnDE() {

        Country country = CountryUtil.getCountryForName(CountryUtil.getLocales(), "Germany");
        assertEquals("DE", country.getCode());
    }
}