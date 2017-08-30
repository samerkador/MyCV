package com.example.mylap.mycv;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
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
import android.widget.TextView;

import com.example.mylap.mycv.items.RecViewAdapterStrength;

import java.util.ArrayList;
import java.util.Arrays;

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
                    case 2:
                        view = personalDetails();
                        break;
                    case 3:
                        view = strengthList();
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
                        .title("Details")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_fifth),
                        Color.parseColor(colors[4]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_eighth))
                        .title("Strengths")
                        .build()
        );

    }


    private View Objective() {

        final View viewInflater = LayoutInflater.from(
                getActivity()).inflate(R.layout.objective_tab, null, false);

        final TextView txtPage = (TextView) viewInflater.findViewById(R.id.txt_objective);

        txtPage.setTextSize(20);
        txtPage.setText(setObjectiveText());

        return viewInflater;
    }

    private View Education() {

         return LayoutInflater.from(
                 getActivity()).inflate(R.layout.education_tab, null, false);

    }


    private View personalDetails() {

        return LayoutInflater.from(
                getActivity()).inflate(R.layout.personal_details_tab, null, false);

    }


    private View strengthList() {
        final View view = LayoutInflater.from(
                getActivity()).inflate(R.layout.skill_list_tab, null, false);


        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_strengths);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                        getActivity(), LinearLayoutManager.VERTICAL, false
                )
        );

        ArrayList<String> StrengthListData = new ArrayList( Arrays.asList( getResources().getStringArray(R.array.skills_list) ));
        recyclerView.setAdapter(new RecViewAdapterStrength(getActivity(), StrengthListData ));
        return  view;
    }


    private String setObjectiveText() {
    return getString(R.string.objective);
    }


    public void HandelOnClickListener(View view) {


        Intent intent = null;
        switch (view.getId())
        {
            case R.id.ll_personal_phone:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+201159550915"));
                break;
            case  R.id.ll_personal_Email:
                intent = new Intent(Intent.ACTION_SENDTO , Uri.parse("mailto:" + "samer.kador.94@gmail.com"));
                break;
            case R.id.ll_personal_Address:
               // intent = new Intent((Intent.ACTION_VIEW) , Uri.parse("geo:0,0?q=" + "Mohammed Abd El-Azeem Sallam, Al Manteqah Ath Thamenah, Nasr City, Cairo Governorate"));
                intent = new Intent((Intent.ACTION_VIEW) , Uri.parse("geo:0,0?q=" + "30.052396,31.343912(samer kador home)"));
                break;
        }

        assert intent != null;
        if (intent.resolveActivity( getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }

    }

}
