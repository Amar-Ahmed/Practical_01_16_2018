package com.example.android.loopactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * Created by C4Q on 1/16/18.
 */

public class FragmentCollection extends Fragment {

    View rootView;
    TextView showNum;

    public FragmentCollection(){}

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState){
        rootView = layoutInflater.inflate(R.layout.fragments_collection, container, false);
        showNum = (TextView) rootView.findViewById(R.id.show_product);
        Bundle bundle = getArguments();
        int numToMultiply = bundle.getInt("int");
        int product = numToMultiply *10;
        showNum.setText(String.valueOf(product));

        return rootView;
    }

    public View getRootView() {
        return rootView;
    }
}
