package com.samer.kador.mycv.items;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.samer.kador.mycv.R;

/**
 * Created by Smra_PC on 8/20/2017.
 */

public class ViewHolderSkill extends RecyclerView.ViewHolder {

    public TextView txt;

    public ViewHolderSkill(View itemView) {
        super(itemView);
        txt = (TextView) itemView.findViewById(R.id.txt_vp_item_list);


        GradientDrawable bgShape = (GradientDrawable)txt.getBackground();
        bgShape.setColor(itemView.getContext().getResources().getColor(R.color.colorMidPink));

    }

}
