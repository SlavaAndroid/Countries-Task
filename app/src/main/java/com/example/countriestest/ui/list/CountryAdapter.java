package com.example.countriestest.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countriestest.R;
import com.example.countriestest.data.source.CountrySource;
import com.example.countriestest.databinding.ListItemCountryBinding;
import com.hbb20.CCPCountry;

import java.util.ArrayList;
import java.util.List;


public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryHolder> {

    private List<CCPCountry> countries = new ArrayList<>();
    public CountryClickListener listener;

    public void setCountries(List<CCPCountry> countries) {
        this.countries = countries;
        notifyDataSetChanged();
    }

    public void setListener(CountryClickListener listener) {
        this.listener =listener;
    }

    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemCountryBinding binding = ListItemCountryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CountryHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {

        holder.bind(countries.get(position));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class CountryHolder extends RecyclerView.ViewHolder {
        ListItemCountryBinding binding;

        public CountryHolder(ListItemCountryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(CCPCountry country) {
            binding.countryTitle.setText(country.getName());
            binding.countryFlag.setImageResource(country.getFlagID());
            itemView.setOnClickListener(view -> {
                if (listener != null) {
                    listener.onCountryClick(country);
                }
            });
        }
    }

    public interface CountryClickListener {
        void onCountryClick(CCPCountry country);
    }

}
