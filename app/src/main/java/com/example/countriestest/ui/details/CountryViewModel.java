package com.example.countriestest.ui.details;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.countriestest.data.repository.CountryRepository;
import com.example.countriestest.data.repository.CountryRepositoryImpl;
import com.hbb20.CCPCountry;

import java.util.ArrayList;
import java.util.List;

public class CountryViewModel extends ViewModel {
    private CountryRepository repository = new CountryRepositoryImpl();

    public MutableLiveData<CCPCountry> country = new MutableLiveData<>();

    public void getData(String nameCode) {
        CCPCountry currentCountry = repository.getCountry(nameCode);
        country.postValue(currentCountry);
    }
}
