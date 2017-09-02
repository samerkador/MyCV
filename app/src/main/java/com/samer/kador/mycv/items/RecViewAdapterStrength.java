package com.samer.kador.mycv.items;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samer.kador.mycv.R;

import java.util.ArrayList;

/**
 * Created by Smra_PC on 8/20/2017.
 */

public class RecViewAdapterStrength extends RecyclerView.Adapter<ViewHolderSkill> {


    ArrayList<String> data;
    Context context;

    public RecViewAdapterStrength(Context context ,ArrayList<String> data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public ViewHolderSkill onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.item_list_skill, parent, false);
        return new ViewHolderSkill(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderSkill holder, int position) {
        holder.txt.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
       return data.size();
    }
}
