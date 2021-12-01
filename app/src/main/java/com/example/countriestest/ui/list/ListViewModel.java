package com.example.countriestest.ui.list;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.countriestest.data.repository.CountryRepository;
import com.example.countriestest.data.repository.CountryRepositoryImpl;
import com.hbb20.CCPCountry;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends ViewModel {

    private CountryRepository repository = new CountryRepositoryImpl();

    public MutableLiveData<List<CCPCountry>> countries = new MutableLiveData<>(new ArrayList<>());

    public void getData() {
        List<CCPCountry> list = repository.getCountries();
        countries.postValue(list);
    }

}
