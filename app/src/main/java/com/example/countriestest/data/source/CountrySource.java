package com.example.countriestest.data.source;

import android.widget.Toast;

import com.hbb20.CCPCountry;

import java.util.ArrayList;
import java.util.List;

public class CountrySource {

    private List<CCPCountry> countries = new ArrayList<>();
    private static CountrySource instance;

    public static CountrySource getInstance() {
        if (instance == null) {
            instance = new CountrySource();
        }
        return instance;
    }

    private CountrySource() {
        countries = CCPCountry.getLibraryMasterCountriesEnglish();
    }

    public List<CCPCountry> getCountries() {
        return countries;
    }

    public CCPCountry getCountry(String countryNameCode) {
        for(CCPCountry country : countries) {
            if (country != null) {
                if (country.getNameCode().equals(countryNameCode))
                    return country;
            }
        }
        return null;
    }
}
