package com.example.countriestest.ui.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.countriestest.R;
import com.example.countriestest.databinding.FragmentItemBinding;
import com.example.countriestest.databinding.FragmentListBinding;
import com.example.countriestest.ui.list.CountryAdapter;
import com.example.countriestest.ui.list.ListViewModel;
import com.hbb20.CCPCountry;

import java.util.UUID;

public class CountryFragment extends Fragment {

    private static final String ARG_COUNTRY_NAME_CODE = "country_name_code";

    private FragmentItemBinding binding;
    private CountryViewModel viewModel;
    private String code;

    public static CountryFragment newInstance(String countryNameCode) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_COUNTRY_NAME_CODE, countryNameCode);
        CountryFragment fragment = new CountryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) code = getArguments().getString(ARG_COUNTRY_NAME_CODE, "");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentItemBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(CountryViewModel.class);

        viewModel.country.observe(getViewLifecycleOwner(), ccpCountry -> {
            if (viewModel != null) {
                binding.countryNameCode.setText(ccpCountry.getNameCode());
                binding.countryFlag.setImageResource(ccpCountry.getFlagID());
                binding.countryName.setText(ccpCountry.getName());
                binding.phoneCode.setText("+" + ccpCountry.getPhoneCode());
            }
        });
        if (code != null)
            viewModel.getData(code);
        else
            Toast.makeText(getActivity(), "Country code error", Toast.LENGTH_SHORT).show();
    }


}
