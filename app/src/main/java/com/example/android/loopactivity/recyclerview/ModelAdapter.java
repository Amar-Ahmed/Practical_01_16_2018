package com.example.android.loopactivity.recyclerview;

/**
 * Created by C4Q on 1/16/18.
 */

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import com.example.android.loopactivity.R;

public class ModelAdapter extends RecyclerView.Adapter<ModelViewHolder> {

    List<Model> myList;

    public ModelAdapter(List<Model> myList){
        this.myList = myList;
    }
    @Override
    public ModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View modelView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new ModelViewHolder(modelView);
    }

    @Override
    public void onBindViewHolder(ModelViewHolder holder, int position) {
        Model model = myList.get(position);
        holder.onBind(model);

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
}
