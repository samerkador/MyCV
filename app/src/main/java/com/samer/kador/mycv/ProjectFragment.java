package com.samer.kador.mycv;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alexvasilkov.foldablelayout.UnfoldableView;
import com.alexvasilkov.foldablelayout.shading.GlanceFoldShading;
import com.samer.kador.mycv.model.Painting;
import com.samer.kador.mycv.items.PaintingsAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectFragment extends Fragment {


    View view;
    private View listTouchInterceptor;
    private View detailsLayout;
    public UnfoldableView unfoldableView;


    public ProjectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_project, container, false);
        iniFloadableLayout();


        return view;
    }

    private void iniFloadableLayout() {
    //    ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = $(R.id.list_view);
        listView.setAdapter(new PaintingsAdapter(getActivity() , this));

        listTouchInterceptor = $(R.id.touch_interceptor_view);
        listTouchInterceptor.setClickable(false);

        detailsLayout = $(R.id.details_layout);
        detailsLayout.setVisibility(View.INVISIBLE);

        unfoldableView = $(R.id.unfoldable_view);

        Bitmap glance = BitmapFactory.decodeResource(getResources(), R.drawable.unfold_glance);
        unfoldableView.setFoldShading(new GlanceFoldShading(glance));


        unfoldableView.setOnFoldingListener(new UnfoldableView.SimpleFoldingListener() {
            @Override
            public void onUnfolding(UnfoldableView unfoldableView) {
                listTouchInterceptor.setClickable(true);
                detailsLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onUnfolded(UnfoldableView unfoldableView) {
                listTouchInterceptor.setClickable(false);
            }

            @Override
            public void onFoldingBack(UnfoldableView unfoldableView) {
                listTouchInterceptor.setClickable(true);
            }

            @Override
            public void onFoldedBack(UnfoldableView unfoldableView) {
                listTouchInterceptor.setClickable(false);
                detailsLayout.setVisibility(View.INVISIBLE);
            }
        });
    }
    @SuppressWarnings("unchecked")
    private <T extends View> T $( @IdRes int id) {
        return (T)  view.findViewById(id);
    }


    public void openDetails(View coverView, Painting painting) {

        DetailsFragment fragment = new DetailsFragment(painting);

        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction()
                .replace(R.id.details_layout, fragment);
        fragmentTransaction.commitAllowingStateLoss();


        unfoldableView.unfold(coverView, detailsLayout);


    }

}
