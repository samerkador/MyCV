package com.samer.kador.mycv.items;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexvasilkov.android.commons.adapters.ItemsAdapter;
import com.alexvasilkov.android.commons.ui.Views;

import com.samer.kador.mycv.ProjectFragment;
import com.samer.kador.mycv.R;
import com.samer.kador.mycv.model.ProjectModel;
import com.samer.kador.mycv.utils.GlideHelper;

import java.util.Arrays;

public class ProjectsAdapter extends ItemsAdapter<ProjectModel, ProjectsAdapter.ViewHolder>
        implements View.OnClickListener {
 private Fragment fragment;


    public ProjectsAdapter(Context context , Fragment fragment) {
        this.fragment = fragment;
        setItemsList(Arrays.asList(ProjectModel.getAllProjects(context.getResources())));
    }

    @Override
    protected ViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        final ViewHolder holder = new ViewHolder(parent);
        holder.image.setOnClickListener(this);
        return holder;
    }

    @Override
    protected void onBindHolder(ViewHolder holder, int position) {
        final ProjectModel item = getItem(position);

        holder.image.setTag(R.id.list_item_image, item);
        GlideHelper.loadPaintingImage(holder.image, item);
        holder.title.setText(item.getTitle());
    }

    @Override
    public void onClick(View view) {

        final ProjectModel item = (ProjectModel) view.getTag(R.id.list_item_image);
        ((ProjectFragment)fragment).openDetails(view, item);

    }

    static class ViewHolder extends ItemsAdapter.ViewHolder {
        final ImageView image;
        final TextView title;

        ViewHolder(ViewGroup parent) {
            super(Views.inflate(parent, R.layout.item_list_floadable_list));
            image = Views.find(itemView, R.id.list_item_image);
            title = Views.find(itemView, R.id.list_item_title);
        }
    }

}
