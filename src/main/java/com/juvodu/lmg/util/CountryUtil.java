package com.juvodu.lmg.util;

import com.juvodu.lmg.model.Country;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Juvodu on 05.06.17.
 */
public class CountryUtil {

    /**
     * Get list of locales containing name and iso code
     *
     * @return
     */
    public static List<Locale> getLocales(){

        String[] isoCountries = Locale.getISOCountries();
        Stream<String> stream = Arrays.stream(isoCountries);
        return stream.map(isoCountry -> new Locale("", isoCountry)).collect(Collectors.toList());
    }

    /**
     * Get 2 letter ISO country codes instead of names for better data quality
     *
     * @param countryName
     * @return
     */
    public static Country getCountryForName(List<Locale> locales, String countryName){

        Country country = null;
        Optional<Locale> localeOptional = locales.stream().filter(l -> l.getDisplayCountry().equalsIgnoreCase(countryName)).findFirst();
        if(localeOptional.isPresent()){
            Locale locale = localeOptional.get();
            country = new Country(locale.getCountry(), locale.getDisplayName());
        }

        return country;
    }
}
