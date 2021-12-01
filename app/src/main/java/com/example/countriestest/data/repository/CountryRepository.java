package com.example.countriestest.data.repository;

import com.hbb20.CCPCountry;

import java.util.List;

public interface CountryRepository {

    List<CCPCountry> getCountries();

    CCPCountry getCountry(String nameCode);
}
