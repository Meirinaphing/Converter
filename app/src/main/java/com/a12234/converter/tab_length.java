package com.a12234.converter;

import android.content.Intent;
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
import android.widget.Toast;

import static java.lang.Double.parseDouble;
import static java.lang.String.valueOf;

/**
 * Created by Meirina on 02/12/2017.
 */

public class tab_length extends Fragment implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private String spin;
    private String[] isispinner =
            {
                    "Kilometer (KM)",
                    "Hectometer (HM)",
                    "Dekameter (DaM)",
                    "Meter (M)",
                    "Decimeter (DM)",
                    "Centimeter (CM)",
                    "Milimeter (MM)",
                    "Inch"
            };
    private ListView listView;
    private EditText n;

    private double km=1;
    private double hm=1;
    private double dam=1;
    private double m=1;
    private double dm=1;
    private double cm=1;
    private double mm=1;
    private double inch=1;

    private static String[] length1 = new String[]{
            "asd",
            "asd",
            "asd",
            "asd",
            "asd",
            "asd",
            "asd",
            "asd"
    };

    String[] length2 = {
            "KM",
            "HM",
            "DaM",
            "M",
            "DM",
            "CM",
            "MM",
            "Inch"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_length, container, false);

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
                    if(spin=="Kilometer (KM)"){
//                        if(n.getText().toString() == ""){
//
//                        }else{
                        km();
//                        }
                    }else if(spin == "Hectometer (HM)"){
                        hm();
                    }else if(spin == "Dekameter (DaM)"){
                        dam();
                    }else if(spin == "Meter (M)"){
                        m();
                    }else if(spin == "Decimeter (DM)"){
                        dm();
                    }else if(spin == "Cenimeter (CM)"){
                        cm();
                    }else if(spin == "Milimeter (MM)"){
                        mm();
                    }else if(spin == "Inch"){
                        inch();
                    }

                }
            }
        });

//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                if(position==0){
//                    //km
//                }
//                if(position==1){
//                    //hm
//                }
//                if(position==2){
//                    //dam
//                }
//                if(position==3){
//                    //m
//                }
//                if(position==4){
//                    //dm
//                }
//                if(position==5){
//                    //cm
//                }
//                if(position==6){
//                    //mm
//                }
//                if(position==7){
//                    //inch
//                }
//            }
//        });

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(n.getText().toString().isEmpty()){

        }else {
            if (i == 0 && view == view) {
                km();
            } else if (i == 1 && view == view) {
                hm();
            } else if (i == 2 && view == view) {
                dam();
            } else if (i == 3 && view == view) {
                m();
            } else if (i == 4 && view == view) {
                dm();
            } else if (i == 5 && view == view) {
                cm();
            } else if (i == 6 && view == view) {
                mm();
            } else if (i == 7 && view == view) {
                inch();
            }
        }
    }

    private void km() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        km = angka;
        hm = angka*10;
        dam = angka*100;
        m = angka*1000;
        dm = angka*10000;
        cm = angka*100000;
        mm = angka*1000000;
        inch = angka*39370.1;

        length1[0]=valueOf(km);
        length1[1]=valueOf(hm);
        length1[2]=valueOf(dam);
        length1[3]=valueOf(m);
        length1[4]=valueOf(dm);
        length1[5]=valueOf(cm);
        length1[6]=valueOf(mm);
        length1[7]=valueOf(inch);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void hm() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        km = angka/10;
        hm = angka;
        dam = angka*10;
        m = angka*100;
        dm = angka*1000;
        cm = angka*10000;
        mm = angka*100000;
        inch = angka*3937.01;

        length1[0]=valueOf(km);
        length1[1]=valueOf(hm);
        length1[2]=valueOf(dam);
        length1[3]=valueOf(m);
        length1[4]=valueOf(dm);
        length1[5]=valueOf(cm);
        length1[6]=valueOf(mm);
        length1[7]=valueOf(inch);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void dam() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        km = angka/100;
        hm = angka/10;
        dam = angka;
        m = angka*10;
        dm = angka*100;
        cm = angka*1000;
        mm = angka*10000;
        inch = angka*393.701;

        length1[0]=valueOf(km);
        length1[1]=valueOf(hm);
        length1[2]=valueOf(dam);
        length1[3]=valueOf(m);
        length1[4]=valueOf(dm);
        length1[5]=valueOf(cm);
        length1[6]=valueOf(mm);
        length1[7]=valueOf(inch);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void m() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        km = angka/1000;
        hm = angka/100;
        dam = angka/10;
        m = angka;
        dm = angka*10;
        cm = angka*100;
        mm = angka*1000;
        inch = angka*39.3701;

        length1[0]=valueOf(km);
        length1[1]=valueOf(hm);
        length1[2]=valueOf(dam);
        length1[3]=valueOf(m);
        length1[4]=valueOf(dm);
        length1[5]=valueOf(cm);
        length1[6]=valueOf(mm);
        length1[7]=valueOf(inch);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void dm() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        km = angka/10000;
        hm = angka/1000;
        dam = angka/100;
        m = angka/10;
        dm = angka;
        cm = angka*10;
        mm = angka*100;
        inch = angka*3.93701;

        length1[0]=valueOf(km);
        length1[1]=valueOf(hm);
        length1[2]=valueOf(dam);
        length1[3]=valueOf(m);
        length1[4]=valueOf(dm);
        length1[5]=valueOf(cm);
        length1[6]=valueOf(mm);
        length1[7]=valueOf(inch);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void cm() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        km = angka/100000;
        hm = angka/10000;
        dam = angka/1000;
        m = angka/100;
        dm = angka/10;
        cm = angka;
        mm = angka*10;
        inch = angka*0.393701;

        length1[0]=valueOf(km);
        length1[1]=valueOf(hm);
        length1[2]=valueOf(dam);
        length1[3]=valueOf(m);
        length1[4]=valueOf(dm);
        length1[5]=valueOf(cm);
        length1[6]=valueOf(mm);
        length1[7]=valueOf(inch);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void mm() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        km = angka/1000000;
        hm = angka/100000;
        dam = angka/10000;
        m = angka/1000;
        dm = angka/100;
        cm = angka/10;
        mm = angka;
        inch = angka*0.0393701;

        length1[0]=valueOf(km);
        length1[1]=valueOf(hm);
        length1[2]=valueOf(dam);
        length1[3]=valueOf(m);
        length1[4]=valueOf(dm);
        length1[5]=valueOf(cm);
        length1[6]=valueOf(mm);
        length1[7]=valueOf(inch);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void inch() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        km = angka/0.0000254;
        hm = angka/0.000254;
        dam = angka/0.00254;
        m = angka*0.0254;
        dm = angka/0.254;
        cm = angka*2.54;
        mm = angka*25.4;
        inch = angka;

        length1[0]=valueOf(km);
        length1[1]=valueOf(hm);
        length1[2]=valueOf(dam);
        length1[3]=valueOf(m);
        length1[4]=valueOf(dm);
        length1[5]=valueOf(cm);
        length1[6]=valueOf(mm);
        length1[7]=valueOf(inch);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
