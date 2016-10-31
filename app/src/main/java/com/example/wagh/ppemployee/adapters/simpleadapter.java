package com.example.wagh.ppemployee.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wagh on 31-10-2016.
 */

public class Simpleadapter extends RecyclerView.Adapter<Simpleadapter.ViewHolder> {


    Simpleadapter()
    {

    }


    @Override
    public Simpleadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(Simpleadapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        ViewHolder(View vt)
        {
            super(vt);

        }
    }



}


