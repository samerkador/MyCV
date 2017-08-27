package com.example.mylap.mycv.items;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylap.mycv.R;
import com.example.mylap.mycv.items.ViewHolderStrength;
import com.example.mylap.mycv.model.Strength;
import com.yalantis.flipviewpager.adapter.BaseFlipAdapter;
import com.yalantis.flipviewpager.utils.FlipSettings;

import java.util.List;

/**
 * Created by Smra_PC on 8/27/2017.
 */

public class ListViewAdapterStrength extends BaseFlipAdapter<Strength> {

    private final int PAGES = 3;
    Context context;

    public ListViewAdapterStrength(Context context, List<Strength> items, FlipSettings settings) {
        super(context, items, settings);
      this.context = context;
    }

    @Override
    public View getPage(int position, View convertView, ViewGroup parent, Strength item1, Strength item2) {
        final ViewHolderStrength holder;

        if (convertView == null) {
            holder = new ViewHolderStrength();
            convertView = LayoutInflater.from(context).inflate(R.layout.merge_strength, parent, false);
            holder.leftAvatar = (ImageView) convertView.findViewById(R.id.image_first);
            holder.rightAvatar = (ImageView) convertView.findViewById(R.id.image_second);
            holder.infoPage = LayoutInflater.from(context).inflate(R.layout.info_strength, parent, false);
            holder.nickName = (TextView) holder.infoPage.findViewById(R.id.nickname);
            holder.details = (TextView) holder.infoPage.findViewById(R.id.details_strength);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolderStrength) convertView.getTag();
        }

        switch (position) {
            // Merged page with 2 friends
            case 1:
                holder.leftAvatar.setImageResource(item1.getAvatar());
                if (item2 != null)
                    holder.rightAvatar.setImageResource( item2.getAvatar());
                break;
            default:
                fillHolder(holder, position == 0 ? item1 :  item2);
                holder.infoPage.setTag(holder);
                return holder.infoPage;
        }
        return convertView;
    }

    @Override
    public int getPagesCount() {
        return PAGES;
    }



    private void fillHolder(ViewHolderStrength holder, Strength strength) {
        if (strength == null)
            return;


        holder.infoPage.setBackgroundColor(  context.getResources().getColor(strength.getBackground()));
        holder.nickName.setText(strength.getNickname());
        holder.details.setText(strength.getDetails());
    }

}
