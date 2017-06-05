package com.juvodu.lmg.model;

/**
 * Created by Juvodu on 05.06.17.
 *
 * Representing continents containing name and 2 letter ISO code
 */
public enum Continent {

    AF("Africa", "AF"),
    NA("North America", "NA"),
    OC("Oceania", "OC"),
    AN("Antarctica", "AN"),
    AS("Asia", "AS"),
    EU("Europe", "EU"),
    SA("South America", "SA");

    private final String name;
    private final String code;

    Continent(String name, String code){
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
