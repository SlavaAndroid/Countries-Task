package com.example.countriestest.data.repository;

import com.example.countriestest.data.source.CountrySource;
import com.hbb20.CCPCountry;

import java.util.List;

public class CountryRepositoryImpl implements CountryRepository {

    private CountrySource data = CountrySource.getInstance();

    @Override
    public List<CCPCountry> getCountries() {
        return data.getCountries();
    }

    @Override
    public CCPCountry getCountry(String nameCode) {
        return data.getCountry(nameCode);
    }
}
