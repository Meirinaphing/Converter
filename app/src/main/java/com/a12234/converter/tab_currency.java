package com.a12234.converter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Meirina on 02/12/2017.
 */

public class tab_currency extends Fragment {

    public static final String ACCESS_KEY = "90eca55473364c2b78f3d701e9310f19";
    public static final String BASE_URL = "https://apilayer.net/api/";
    public static final String ENDPOINT = "convert";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_currency, container, false);
        return view;
    }
}
