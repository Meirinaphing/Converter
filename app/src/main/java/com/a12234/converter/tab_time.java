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

public class tab_time extends Fragment implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private String spin;
    private String[] isispinner =
            {
                    "Second",
                    "Minute",
                    "Hours",
                    "Day",
                    "Week",
                    "Month",
                    "Year"
            };
    private ListView listView;
    private EditText n;

    private double s=1;
    private double m=1;
    private double h=1;
    private double day=1;
    private double week=1;
    private double month=1;
    private double year=1;

    private static String[] length1 = new String[]{
            "asd",
            "asd",
            "asd",
            "asd",
            "asd",
            "asd",
            "asd"
    };

    String[] length2 = {
            "sec",
            "min",
            "hour",
            "day",
            "week",
            "month",
            "year"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time, container, false);

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
                    if(spin=="Second"){
                        fsec();
                    }else if(spin == "Minute"){
                        fmin();
                    }else if(spin == "Hours"){
                        fhour();
                    }else if(spin == "Day"){
                        fday();
                    }else if(spin == "Week"){
                        fweek();
                    }else if(spin == "Month"){
                        fmonth();
                    }else if(spin == "Year"){
                        fyear();
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
                fsec();
            } else if (i == 1 && view == view) {
                fmin();
            } else if (i == 2 && view == view) {
                fhour();
            } else if (i == 3 && view == view) {
                fday();
            } else if (i == 4 && view == view) {
                fweek();
            } else if (i == 5 && view == view) {
                fmonth();
            } else if (i == 6 && view == view) {
                fyear();
            }
        }
    }

    private void fsec() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        s = angka;
        m = angka/60;
        h = angka/3600;
        day = angka/86400;
        week = angka/604800;
        month = angka/2592000;
        year = angka/31536000;

        length1[0]=valueOf(s);
        length1[1]=valueOf(m);
        length1[2]=valueOf(h);
        length1[3]=valueOf(day);
        length1[4]=valueOf(week);
        length1[5]=valueOf(month);
        length1[6]=valueOf(year);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void fmin() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        s = angka*60;
        m = angka;
        h = angka/60;
        day = angka/1440;
        week = angka/10080;
        month = angka/43800;
        year = angka/525600;

        length1[0]=valueOf(s);
        length1[1]=valueOf(m);
        length1[2]=valueOf(h);
        length1[3]=valueOf(day);
        length1[4]=valueOf(week);
        length1[5]=valueOf(month);
        length1[6]=valueOf(year);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void fhour() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        s = angka*3600;
        m = angka*60;
        h = angka;
        day = angka/24;
        week = angka/168;
        month = angka/720;
        year = angka/8760;

        length1[0]=valueOf(s);
        length1[1]=valueOf(m);
        length1[2]=valueOf(h);
        length1[3]=valueOf(day);
        length1[4]=valueOf(week);
        length1[5]=valueOf(month);
        length1[6]=valueOf(year);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void fday() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        s = angka*86400;
        m = angka*1440;
        h = angka*24;
        day = angka;
        week = angka/7;
        month = angka/30;
        year = angka/365;

        length1[0]=valueOf(s);
        length1[1]=valueOf(m);
        length1[2]=valueOf(h);
        length1[3]=valueOf(day);
        length1[4]=valueOf(week);
        length1[5]=valueOf(month);
        length1[6]=valueOf(year);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void fweek() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        s = angka*604800;
        m = angka*10080;
        h = angka*168;
        day = angka*7;
        week = angka;
        month = angka/4.34524;
        year = angka/52.1429;

        length1[0]=valueOf(s);
        length1[1]=valueOf(m);
        length1[2]=valueOf(h);
        length1[3]=valueOf(day);
        length1[4]=valueOf(week);
        length1[5]=valueOf(month);
        length1[6]=valueOf(year);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void fmonth() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        s = angka*2592000;
        m = angka*43800;
        h = angka*720;
        day = angka*30;
        week = angka*4.34524;
        month = angka;
        year = angka/12;

        length1[0]=valueOf(s);
        length1[1]=valueOf(m);
        length1[2]=valueOf(h);
        length1[3]=valueOf(day);
        length1[4]=valueOf(week);
        length1[5]=valueOf(month);
        length1[6]=valueOf(year);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void fyear() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        s = angka*31536000;
        m = angka*525600;
        h = angka*8760;
        day = angka*365;
        week = angka*52.1429;
        month = angka*12;
        year = angka;

        length1[0]=valueOf(s);
        length1[1]=valueOf(m);
        length1[2]=valueOf(h);
        length1[3]=valueOf(day);
        length1[4]=valueOf(week);
        length1[5]=valueOf(month);
        length1[6]=valueOf(year);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
