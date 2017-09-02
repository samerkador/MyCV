package com.samer.kador.mycv;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexvasilkov.android.commons.texts.SpannableBuilder;
import com.samer.kador.mycv.model.Painting;
import com.samer.kador.mycv.utils.GlideHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    Painting painting;


    public DetailsFragment() {

    }

    public DetailsFragment(Painting painting) {
       this.painting = painting;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view =inflater.inflate(R.layout.fragment_project_details, container, false);

        final ImageView image = (ImageView) view.findViewById(R.id.details_image);
        final TextView title = (TextView) view.findViewById(R.id.details_title);
        final TextView lang = (TextView) view.findViewById(R.id.details_lang);
        final TextView text = (TextView) view.findViewById(R.id.details_text);


        GlideHelper.loadPaintingImage(image, painting);
        title.setText(painting.getTitle());


        SpannableBuilder builder = new SpannableBuilder(getActivity());
        builder
                .createStyle().setFont(Typeface.DEFAULT_BOLD).apply()
                .append("Implemented using: ")
                .clearStyle()
                .append(painting.getLang());
         lang.setText(builder.build());



        builder = new SpannableBuilder(getActivity());
        builder
                .createStyle().setFont(Typeface.DEFAULT_BOLD).apply()
                .clearStyle()
                .append(painting.getDescription());
        text.setText(builder.build());

        return view;
    }

}
