package com.example.android.loopactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by C4Q on 1/16/18.
 */

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerViewFragment recyclerViewFragment = new RecyclerViewFragment();
        FragmentManager fragmentMananger = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentMananger.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,recyclerViewFragment);
        fragmentTransaction.commit();

    }



}
