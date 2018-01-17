package com.example.android.loopactivity.recyclerview;

/**
 * Created by C4Q on 1/16/18.
 */
import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.loopactivity.R;
import com.example.android.loopactivity.ListActivity;
import com.example.android.loopactivity.FragmentCollection;

public class ModelViewHolder extends RecyclerView.ViewHolder {
    TextView showNum;

    public ModelViewHolder(View itemView) {
        super(itemView);

        showNum = itemView.findViewById(R.id.show_number);

    }

    public void onBind(final Model model){
        showNum.setText(String.valueOf(model.getNumber()));
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentCollection mF = new FragmentCollection();
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FragmentManager manager = activity.getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putInt("int",model.getNumber());
                mF.setArguments(bundle);
                transaction.replace(R.id.fragment_container,mF).addToBackStack("multiply"+model.getNumber());
                transaction.commit();

            }
        });
    }

}
