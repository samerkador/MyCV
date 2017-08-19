package com.example.mylap.mycv;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalFragment extends Fragment {

    View view;
    public PersonalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_personal, container, false);
        initUI();
        // Inflate the layout for this fragment
        return view ;

    }

    @SuppressWarnings("unchecked")
    private <T extends View> T $( @IdRes int id) {
        return (T)  view.findViewById(id);
    }


    private void initUI() {
        final ViewPager viewPager = $(R.id.vp_horizontal_ntb);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 4;
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
                        view = Objective();
                        break;
                    case 1:
                        view = Education();
                        break;
                    default:
                        view = Objective();
                        break;
                }
                container.addView(view);
                return view;
            }
        });


        final NavigationTabBar navigationTabBar =  $(R.id.ntb_horizontal);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        setModels(models);

        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(viewPager, 0);

    }


    private void setModels(ArrayList<NavigationTabBar.Model> models) {

        final String[] colors = getResources().getStringArray(R.array.default_preview);

        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_first),
                        Color.parseColor(colors[0]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_sixth))
                        .title("Objective")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_second),
                        Color.parseColor(colors[1]))
//                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("Education")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_third),
                        Color.parseColor(colors[2]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_seventh))
                        .title("Diploma")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_fifth),
                        Color.parseColor(colors[4]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("Medal")
                        .build()
        );

    }


    private View Objective()
    {

        final View view = LayoutInflater.from(
                getActivity()).inflate(R.layout.objective_tab, null, false);

        final TextView txtPage = (TextView) view.findViewById(R.id.txt_objective);

        txtPage.setTextSize(20);
        txtPage.setText(setObjectiveText());

        return view;
    }



    private View Education() {

        final View view = LayoutInflater.from(
                getActivity()).inflate(R.layout.education_tab, null, false);
         return view;

    }
    private String setObjectiveText() {
    return getString(R.string.objective);
    }



}
