package com.example.countriestest.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countriestest.R;
import com.example.countriestest.databinding.FragmentListBinding;
import com.example.countriestest.ui.details.CountryFragment;
import com.hbb20.CCPCountry;

public class ListFragment extends Fragment {

    private CountryAdapter adapter;
    private FragmentListBinding binding;
    private ListViewModel viewModel;

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container,
                false);
        binding = FragmentListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new CountryAdapter();
        adapter.setListener(country -> {
            openCountry(country);
        });
        binding.countriesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.countriesRecyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(ListViewModel.class);
        viewModel.countries.observe(getViewLifecycleOwner(), ccpCountries -> {
            adapter.setCountries(ccpCountries);
        });
        viewModel.getData();
    }

    private void openCountry(@NonNull CCPCountry country) {
        String nameCode = country.getNameCode();
        if(nameCode != null) {
            Fragment countryFragment = CountryFragment.newInstance(nameCode);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, countryFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

}
