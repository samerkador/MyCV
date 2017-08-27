package com.example.mylap.mycv.items;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mylap.mycv.R;

import java.util.ArrayList;

/**
 * Created by Smra_PC on 8/20/2017.
 */

public class RecViewAdapterStrength extends RecyclerView.Adapter<ViewHolderSkill> {


    ArrayList<String> dataStrength;
    Context context;

    public RecViewAdapterStrength(Context context ,ArrayList<String> dataStrength) {
        this.context = context;
        this.dataStrength = dataStrength;
    }


    @Override
    public ViewHolderSkill onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_list_skill, parent, false);
        return new ViewHolderSkill(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderSkill holder, int position) {
        holder.txt.setText(dataStrength.get(position));
    }

    @Override
    public int getItemCount() {
       return dataStrength.size();
    }
}
