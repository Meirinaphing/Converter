package com.a12234.converter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import static java.lang.String.valueOf;

/**
 * Created by Meirina on 02/12/2017.
 */

public class tab_temperature extends Fragment implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private String spin;
    private String[] isispinner =
            {
                    "Celsius (C)",
                    "Reaumur (R)",
                    "Fahrenheit (F)",
                    "Kelvin (K)"
            };
    private ListView listView;
    private EditText n;

    private double c=1;
    private double r=1;
    private double f=1;
    private double k=1;

    private static String[] length1 = new String[]{
            "asd",
            "asd",
            "asd",
            "asd"
    };

    String[] length2 = {
            "C",
            "R",
            "F",
            "K"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temperature, container, false);

        n = (EditText)view.findViewById(R.id.n);

        spinner = (Spinner)view.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,isispinner);
        spinner.setAdapter(arrayadapter);

        ListViewLengthAdapter adapter = new ListViewLengthAdapter(getActivity(), length1, length2);
        listView = (ListView) view.findViewById(R.id.list);
        listView.setAdapter(adapter);

        n.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                spin = spinner.getSelectedItem().toString();
                if(n.getText().toString().isEmpty()){

                }else{
                    if(spin=="Celsius (C)"){
                        fc();
                    }else if(spin == "Reaumur (R)"){
                        fr();
                    }else if(spin == "Fahrenheit (F)"){
                        ff();
                    }else if(spin == "Kelvin (K)"){
                        fk();
                    }
                }
            }
        });

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(n.getText().toString().isEmpty()){

        }else {
            if (i == 0 && view == view) {
                fc();
            } else if (i == 1 && view == view) {
                fr();
            } else if (i == 2 && view == view) {
                ff();
            } else if (i == 3 && view == view) {
                fk();
            }
        }
    }

    private void fr() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        c = 5/4*angka;
        r = angka;
        f = 9/4*angka+32;
        k = (angka/0.8)+273;

        length1[0]=valueOf(c);
        length1[1]=valueOf(r);
        length1[2]=valueOf(f);
        length1[3]=valueOf(k);

        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void fc() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        c = angka;
        r = 4/5*angka;
        f = 9/5*angka+32;
        k = angka+273;

        length1[0]=valueOf(c);
        length1[1]=valueOf(r);
        length1[2]=valueOf(f);
        length1[3]=valueOf(k);

        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void ff() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        c = 5/9*(angka-32);
        r = 4/9*(angka-32);
        f = angka;
        k = (angka+459)/1.8;

        length1[0]=valueOf(c);
        length1[1]=valueOf(r);
        length1[2]=valueOf(f);
        length1[3]=valueOf(k);

        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void fk() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        c = angka-273;
        r = (angka-273)*0.8;
        f = (angka*1.8)-459;
        k = angka;

        length1[0]=valueOf(c);
        length1[1]=valueOf(r);
        length1[2]=valueOf(f);
        length1[3]=valueOf(k);

        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
