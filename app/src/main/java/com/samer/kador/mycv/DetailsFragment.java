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
import com.samer.kador.mycv.model.ProjectModel;
import com.samer.kador.mycv.utils.GlideHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    ProjectModel projectModel;


    public DetailsFragment() {

    }

//    public DetailsFragment(ProjectModel projectModel) {
//       this.projectModel = projectModel;
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        if (getArguments() != null)
        projectModel = (ProjectModel) getArguments().getSerializable("projectModel");


        View view =inflater.inflate(R.layout.fragment_project_details, container, false);

        final ImageView image = (ImageView) view.findViewById(R.id.details_image);
        final TextView title = (TextView) view.findViewById(R.id.details_title);
        final TextView lang = (TextView) view.findViewById(R.id.details_lang);
        final TextView text = (TextView) view.findViewById(R.id.details_text);


        GlideHelper.loadPaintingImage(image, projectModel);
        title.setText(projectModel.getTitle());


        SpannableBuilder builder = new SpannableBuilder(getActivity());
        builder
                .createStyle().setFont(Typeface.DEFAULT_BOLD).apply()
                .append("Implemented using: ")
                .clearStyle()
                .append(projectModel.getLang());
         lang.setText(builder.build());



        builder = new SpannableBuilder(getActivity());
        builder
                .createStyle().setFont(Typeface.DEFAULT_BOLD).apply()
                .clearStyle()
                .append(projectModel.getDescription());
        text.setText(builder.build());

        return view;
    }

}
