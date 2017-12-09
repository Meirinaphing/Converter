package com.a12234.converter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListViewLengthAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] length1;
    private final String[] length2;

    public ListViewLengthAdapter(Activity context, String[] length1, String[] length2) {
        super(context, R.layout.activity_list_view_length_adapter, length1);

        this.context=context;
        this.length1=length1;
        this.length2=length2;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_list_view_length_adapter, null,true);

        TextView txt1 = (TextView)rowView.findViewById(R.id.txt);
        TextView txt2 = (TextView)rowView.findViewById(R.id.txt2);

        txt1.setText(length1[position]);
        txt2.setText(length2[position]);
        return rowView;

    };

}
