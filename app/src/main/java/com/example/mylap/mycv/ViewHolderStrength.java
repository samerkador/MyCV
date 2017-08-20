package com.example.mylap.mycv;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Smra_PC on 8/20/2017.
 */

public class ViewHolderStrength extends RecyclerView.ViewHolder {

    public TextView txt;

    public ViewHolderStrength(View itemView) {
        super(itemView);
        txt = (TextView) itemView.findViewById(R.id.txt_vp_item_list);


        GradientDrawable bgShape = (GradientDrawable)txt.getBackground();
        bgShape.setColor(itemView.getContext().getResources().getColor(R.color.colorMidPink));

    }

}
