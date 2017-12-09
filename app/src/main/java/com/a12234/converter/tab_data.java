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

import java.math.BigDecimal;

import static java.lang.String.valueOf;

/**
 * Created by Meirina on 02/12/2017.
 */

public class tab_data extends Fragment implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private String spin;
    private String[] isispinner =
            {
                    "Bit (b)",
                    "Kilobit (Kb)",
                    "Megabit (Mb)",
                    "Gigabit (Gb)",
                    "Terabit (Tb)",
                    "Petabit (Pb)",
                    "Byte (B)",
                    "Kilobyte (KB)",
                    "Megabyte (MB)",
                    "Gigabyte (GB)",
                    "Terabyte (TB)",
                    "Petabyte (PB)"
            };
    private ListView listView;
    private EditText n;

    private double b=1;
    private double kb=1;
    private double mb=1;
    private double gb=1;
    private double tb=1;
    private double pb=1;
    private double B=1;
    private double kB=1;
    private double mB=1;
    private double gB=1;
    private double tB=1;
    private double pB=1;

    private static String[] length1 = new String[]{
            "asd",
            "asd",
            "asd",
            "asd",
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
            "bit",
            "Kb",
            "Mb",
            "Gb",
            "Tb",
            "Pb",
            "Byte",
            "KB",
            "MB",
            "GB",
            "TB",
            "PB"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);

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
                    if(spin=="Bit (b)"){
                        fb();
                    }else if(spin == "Kilobit (Kb)"){
                        fkb();
                    }else if(spin == "Megabit (Mb)"){
                        fmb();
                    }else if(spin == "Gigabit (Gb)"){
                        fgb();
                    }else if(spin == "Terabit (Tb)"){
                        ftb();
                    }else if(spin == "Petabit (Pb)"){
                        fpb();
                    }else if(spin=="Byte (B)"){
                        fB();
                    }else if(spin == "Kilobyte (KB)"){
                        fkB();
                    }else if(spin == "Megabyte (MB)"){
                        fmB();
                    }else if(spin == "Gigabyte (GB)"){
                        fgB();
                    }else if(spin == "Terabyte (TB)"){
                        ftB();
                    }else if(spin == "Petabyte (PB)"){
                        fpB();
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
                fb();
            } else if (i == 1 && view == view) {
                fkb();
            } else if (i == 2 && view == view) {
                fmb();
            } else if (i == 3 && view == view) {
                fgb();
            } else if (i == 4 && view == view) {
                ftb();
            } else if (i == 5 && view == view) {
                fpb();
            }else if (i == 6 && view == view) {
                fB();
            } else if (i == 7 && view == view) {
                fkB();
            } else if (i == 8 && view == view) {
                fmB();
            } else if (i == 9 && view == view) {
                fgB();
            } else if (i == 10 && view == view) {
                ftB();
            } else if (i == 11 && view == view) {
                fpB();
            }
        }
    }

    private void fb() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        b = angka;
        kb = angka/1000;
        mb = angka/1000000;
        gb = angka/1000000000;
        tb = angka / Double.valueOf(String.valueOf(new BigDecimal("1000000000000"))).doubleValue();
        pb = angka/ Double.valueOf(String.valueOf(new BigDecimal("1000000000000000"))).doubleValue();
        B = angka/8;
        kB = angka/8192;
        mB = angka/8388608;
        gB = angka/Double.valueOf(String.valueOf(new BigDecimal("8589934592"))).doubleValue();
        tB = angka/Double.valueOf(String.valueOf(new BigDecimal("8796093022208"))).doubleValue();
        pB = angka/Double.valueOf(String.valueOf(new BigDecimal("9007199254740992"))).doubleValue();

        length1[0]=valueOf(b);
        length1[1]=valueOf(kb);
        length1[2]=valueOf(mb);
        length1[3]=valueOf(gb);
        length1[4]=valueOf(tb);
        length1[5]=valueOf(pb);
        length1[6]=valueOf(B);
        length1[7]=valueOf(kB);
        length1[8]=valueOf(mB);
        length1[9]=valueOf(gB);
        length1[10]=valueOf(tB);
        length1[11]=valueOf(pB);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void fkb() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        b = angka*1000;
        kb = angka;
        mb = angka/1000;
        gb = angka/1000000;
        tb = angka/1000000000;
        pb = angka/ Double.valueOf(String.valueOf(new BigDecimal("1000000000000"))).doubleValue();
        B = angka*125;
        kB = angka/8;
        mB = angka/8192;
        gB = angka/8388608;
        tB = angka/Double.valueOf(String.valueOf(new BigDecimal("8589934592"))).doubleValue();
        pB = angka/Double.valueOf(String.valueOf(new BigDecimal("8796093022208"))).doubleValue();

        length1[0]=valueOf(b);
        length1[1]=valueOf(kb);
        length1[2]=valueOf(mb);
        length1[3]=valueOf(gb);
        length1[4]=valueOf(tb);
        length1[5]=valueOf(pb);
        length1[6]=valueOf(B);
        length1[7]=valueOf(kB);
        length1[8]=valueOf(mB);
        length1[9]=valueOf(gB);
        length1[10]=valueOf(tB);
        length1[11]=valueOf(pB);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void fmb() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        b = angka*1000000;
        kb = angka*1000;
        mb = angka;
        gb = angka/1000;
        tb = angka/1000000;
        pb = angka/1000000000;
        B = angka*125000;
        kB = angka*125;
        mB = angka/8;
        gB = angka/8192;
        tB = angka/8388608;
        pB = angka/Double.valueOf(String.valueOf(new BigDecimal("8589934592"))).doubleValue();

        length1[0]=valueOf(b);
        length1[1]=valueOf(kb);
        length1[2]=valueOf(mb);
        length1[3]=valueOf(gb);
        length1[4]=valueOf(tb);
        length1[5]=valueOf(pb);
        length1[6]=valueOf(B);
        length1[7]=valueOf(kB);
        length1[8]=valueOf(mB);
        length1[9]=valueOf(gB);
        length1[10]=valueOf(tB);
        length1[11]=valueOf(pB);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void fgb() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        b = angka*1000000000;
        kb = angka*1000000;
        mb = angka*1000;
        gb = angka;
        tb = angka/1000;
        pb = angka/1000000;
        B = angka*125000000;
        kB = angka*125000;
        mB = angka*125;
        gB = angka/8;
        tB = angka/8192;
        pB = angka/8388608;

        length1[0]=valueOf(b);
        length1[1]=valueOf(kb);
        length1[2]=valueOf(mb);
        length1[3]=valueOf(gb);
        length1[4]=valueOf(tb);
        length1[5]=valueOf(pb);
        length1[6]=valueOf(B);
        length1[7]=valueOf(kB);
        length1[8]=valueOf(mB);
        length1[9]=valueOf(gB);
        length1[10]=valueOf(tB);
        length1[11]=valueOf(pB);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void ftb() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        b = angka*Double.valueOf(String.valueOf(new BigDecimal("1000000000000"))).doubleValue();
        kb = angka*1000000000;
        mb = angka*1000000;
        gb = angka*1000;
        tb = angka;
        pb = angka/1000;
        B = angka*Double.valueOf(String.valueOf(new BigDecimal("125000000000"))).doubleValue();
        kB = angka*125000000;
        mB = angka*125000;
        gB = angka*125;
        tB = angka/8;
        pB = angka/8192;

        length1[0]=valueOf(b);
        length1[1]=valueOf(kb);
        length1[2]=valueOf(mb);
        length1[3]=valueOf(gb);
        length1[4]=valueOf(tb);
        length1[5]=valueOf(pb);
        length1[6]=valueOf(B);
        length1[7]=valueOf(kB);
        length1[8]=valueOf(mB);
        length1[9]=valueOf(gB);
        length1[10]=valueOf(tB);
        length1[11]=valueOf(pB);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void fpb() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        b = angka*Double.valueOf(String.valueOf(new BigDecimal("1000000000000000"))).doubleValue();
        kb = angka*Double.valueOf(String.valueOf(new BigDecimal("1000000000000"))).doubleValue();
        mb = angka*1000000000;
        gb = angka*1000000;
        tb = angka*1000;
        pb = angka;
        B = angka*Double.valueOf(String.valueOf(new BigDecimal("125000000000000"))).doubleValue();
        kB = angka*Double.valueOf(String.valueOf(new BigDecimal("125000000000"))).doubleValue();
        mB = angka*125000000;
        gB = angka*125000;
        tB = angka*125;
        pB = angka/8;

        length1[0]=valueOf(b);
        length1[1]=valueOf(kb);
        length1[2]=valueOf(mb);
        length1[3]=valueOf(gb);
        length1[4]=valueOf(tb);
        length1[5]=valueOf(pb);
        length1[6]=valueOf(B);
        length1[7]=valueOf(kB);
        length1[8]=valueOf(mB);
        length1[9]=valueOf(gB);
        length1[10]=valueOf(tB);
        length1[11]=valueOf(pB);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void fB() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        b = angka*8;
        kb = angka/125;
        mb = angka/125000;
        gb = angka/125000000;
        tb = angka/Double.valueOf(String.valueOf(new BigDecimal("125000000000"))).doubleValue();
        pb = angka/Double.valueOf(String.valueOf(new BigDecimal("125000000000000"))).doubleValue();
        B = angka;
        kB = angka/1024;
        mB = angka/1048576;
        gB = angka/1073741824;
        tB = angka/Double.valueOf(String.valueOf(new BigDecimal("1099511627776"))).doubleValue();
        pB = angka/Double.valueOf(String.valueOf(new BigDecimal("1125899906842624"))).doubleValue();

        length1[0]=valueOf(b);
        length1[1]=valueOf(kb);
        length1[2]=valueOf(mb);
        length1[3]=valueOf(gb);
        length1[4]=valueOf(tb);
        length1[5]=valueOf(pb);
        length1[6]=valueOf(B);
        length1[7]=valueOf(kB);
        length1[8]=valueOf(mB);
        length1[9]=valueOf(gB);
        length1[10]=valueOf(tB);
        length1[11]=valueOf(pB);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void fkB() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        b = angka*8192;
        kb = angka*8;
        mb = angka/125;
        gb = angka/125000;
        tb = angka/125000000;
        pb = angka/Double.valueOf(String.valueOf(new BigDecimal("125000000000"))).doubleValue();
        B = angka*1024;
        kB = angka;
        mB = angka/1024;
        gB = angka/1048576;
        tB = angka/1073741824;
        pB = angka/Double.valueOf(String.valueOf(new BigDecimal("1099511627776"))).doubleValue();

        length1[0]=valueOf(b);
        length1[1]=valueOf(kb);
        length1[2]=valueOf(mb);
        length1[3]=valueOf(gb);
        length1[4]=valueOf(tb);
        length1[5]=valueOf(pb);
        length1[6]=valueOf(B);
        length1[7]=valueOf(kB);
        length1[8]=valueOf(mB);
        length1[9]=valueOf(gB);
        length1[10]=valueOf(tB);
        length1[11]=valueOf(pB);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void fmB() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        b = angka*8388608;
        kb = angka*8192;
        mb = angka*8;
        gb = angka/125;
        tb = angka/125000;
        pb = angka/125000000;
        B = angka*1048576;
        kB = angka*1024;
        mB = angka;
        gB = angka/1024;
        tB = angka/1048576;
        pB = angka/1073741824;

        length1[0]=valueOf(b);
        length1[1]=valueOf(kb);
        length1[2]=valueOf(mb);
        length1[3]=valueOf(gb);
        length1[4]=valueOf(tb);
        length1[5]=valueOf(pb);
        length1[6]=valueOf(B);
        length1[7]=valueOf(kB);
        length1[8]=valueOf(mB);
        length1[9]=valueOf(gB);
        length1[10]=valueOf(tB);
        length1[11]=valueOf(pB);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void fgB() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        b = angka*Double.valueOf(String.valueOf(new BigDecimal("8589934592"))).doubleValue();
        kb = angka*8388608;
        mb = angka*8192;
        gb = angka*8;
        tb = angka/125;
        pb = angka/125000;
        B = angka*1073741824;
        kB = angka*1048576;
        mB = angka*1024;
        gB = angka;
        tB = angka/1024;
        pB = angka/1048576;

        length1[0]=valueOf(b);
        length1[1]=valueOf(kb);
        length1[2]=valueOf(mb);
        length1[3]=valueOf(gb);
        length1[4]=valueOf(tb);
        length1[5]=valueOf(pb);
        length1[6]=valueOf(B);
        length1[7]=valueOf(kB);
        length1[8]=valueOf(mB);
        length1[9]=valueOf(gB);
        length1[10]=valueOf(tB);
        length1[11]=valueOf(pB);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void ftB() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        b = angka*Double.valueOf(String.valueOf(new BigDecimal("8796093022208"))).doubleValue();
        kb = angka*Double.valueOf(String.valueOf(new BigDecimal("8589934592"))).doubleValue();
        mb = angka*8388608;
        gb = angka*8192;
        tb = angka*8;
        pb = angka/125;
        B = angka*Double.valueOf(String.valueOf(new BigDecimal("1099511627776"))).doubleValue();
        kB = angka*1073741824;
        mB = angka*1048576;
        gB = angka*1024;
        tB = angka;
        pB = angka/1024;

        length1[0]=valueOf(b);
        length1[1]=valueOf(kb);
        length1[2]=valueOf(mb);
        length1[3]=valueOf(gb);
        length1[4]=valueOf(tb);
        length1[5]=valueOf(pb);
        length1[6]=valueOf(B);
        length1[7]=valueOf(kB);
        length1[8]=valueOf(mB);
        length1[9]=valueOf(gB);
        length1[10]=valueOf(tB);
        length1[11]=valueOf(pB);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    private void fpB() {
        double angka = Double.valueOf(n.getText().toString()).doubleValue();
        b = angka*Double.valueOf(String.valueOf(new BigDecimal("9007199254740992"))).doubleValue();
        kb = angka*Double.valueOf(String.valueOf(new BigDecimal("8796093022208"))).doubleValue();
        mb = angka*Double.valueOf(String.valueOf(new BigDecimal("8589934592"))).doubleValue();
        gb = angka*8388608;
        tb = angka*8192;
        pb = angka*8;
        B = angka*Double.valueOf(String.valueOf(new BigDecimal("1125899906842624"))).doubleValue();
        kB = angka*Double.valueOf(String.valueOf(new BigDecimal("1099511627776"))).doubleValue();
        mB = angka*1073741824;
        gB = angka*1048576;
        tB = angka*1024;
        pB = angka;

        length1[0]=valueOf(b);
        length1[1]=valueOf(kb);
        length1[2]=valueOf(mb);
        length1[3]=valueOf(gb);
        length1[4]=valueOf(tb);
        length1[5]=valueOf(pb);
        length1[6]=valueOf(B);
        length1[7]=valueOf(kB);
        length1[8]=valueOf(mB);
        length1[9]=valueOf(gB);
        length1[10]=valueOf(tB);
        length1[11]=valueOf(pB);
        listView.setAdapter(new ListViewLengthAdapter(getActivity(), length1, length2));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
