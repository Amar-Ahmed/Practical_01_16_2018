package com.example.android.loopactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.loopactivity.recyclerview.ModelAdapter;

import java.util.ArrayList;
import java.util.List;

import com.example.android.loopactivity.recyclerview.*;
/**
 * Created by C4Q on 1/16/18.
 */

public class RecyclerViewFragment extends Fragment {

    View rootView;
    TextView textView;
    RecyclerView recyclerView;

    public RecyclerViewFragment(){}

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = layoutInflater.inflate(R.layout.activity_fragment, container, false);
        textView = (TextView) rootView.findViewById(R.id.fragmen_textview);
        Bundle bundle = getActivity().getIntent().getExtras();
        String username = bundle.getString("email");
        textView.setText(username);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        List<Model> modelList = new ArrayList<>();
        for(int i =0;i<11;i++){
            modelList.add(new Model(i));
        }
        ModelAdapter modelAdapter = new ModelAdapter(modelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rootView.getContext().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setAdapter(modelAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);


        return rootView;
    }



}
