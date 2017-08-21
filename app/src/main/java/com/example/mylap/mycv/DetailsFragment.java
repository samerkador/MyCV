package com.example.mylap.mycv;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylap.mycv.items.Painting;
import com.example.mylap.mycv.utils.GlideHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    Painting painting;
    public DetailsFragment(Painting painting) {
       this.painting = painting;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view =inflater.inflate(R.layout.fragment_details, container, false);

        final ImageView image = (ImageView) view.findViewById(R.id.details_image);
        final TextView title = (TextView) view.findViewById(R.id.details_title);


        GlideHelper.loadPaintingImage(image, painting);
        title.setText(painting.getTitle());


        return view;
    }

}
