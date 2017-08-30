package com.example.mylap.mycv;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eftimoff.viewpagertransformers.FlipVerticalTransformer;
import com.example.mylap.mycv.items.RecViewAdapterStrength;

import java.util.ArrayList;
import java.util.Arrays;

import devlight.io.library.ntb.NavigationTabBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }


    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_blank, container, false);
        initUI();

        return view;
    }


    @SuppressWarnings("unchecked")
    private <T extends View> T $( @IdRes int id) {
        return (T)  view.findViewById(id);
    }


    private void initUI() {
        final ViewPager viewPager = $(R.id.vp_vertical);
        viewPager.setPageTransformer(true,new FlipVerticalTransformer()  );

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public boolean isViewFromObject(final View view, final Object object) {
                return view.equals(object);
            }

            @Override
            public void destroyItem(final View container, final int position, final Object object) {
                ((ViewPager) container).removeView((View) object);
            }

            @Override
            public Object instantiateItem(final ViewGroup container, final int position) {

                View view = null;
                switch (position){
                    case 0:
                        view = loadList(0);
                        break;
                    case 1:
                        view = loadList(1);
                        break;
                    case 2:
                        view = loadList(2);
                        break;
                    default:
                        view = loadList(0);
                        break;
                }
                container.addView(view);
                return view;
            }


        });


        final NavigationTabBar navigationTabBar =  $(R.id.ntb_vertical);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        setModels(models);

        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(viewPager, 0);

    }

    private void setModels(ArrayList<NavigationTabBar.Model> models) {

        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_second),
                        Color.WHITE)
//                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("Strengths")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_third),
                        Color.WHITE)
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_seventh))
                        .title("Experience")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_fifth),
                        Color.WHITE)
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("Awards")
                        .build()
        );

    }


    private View loadList( int list) {
        final View view = LayoutInflater.from(
                getActivity()).inflate(R.layout.skill_list_tab, null, false);


        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_strengths);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                        getActivity(), LinearLayoutManager.VERTICAL, false)
        );


        ArrayList<String> ListData = null;
        switch (list){
            case 0:
                ListData = new ArrayList( Arrays.asList( getResources().getStringArray(R.array.strength_list) ));
                break;
            case 2:
                ListData = new ArrayList( Arrays.asList( getResources().getStringArray(R.array.awards_list) ));
                break;
            case 1:
                ListData = new ArrayList( Arrays.asList( getResources().getStringArray(R.array.experience_list) ));
                break;
        }
        recyclerView.setAdapter(new RecViewAdapterStrength(getActivity(), ListData ));
        return  view;
    }


}
