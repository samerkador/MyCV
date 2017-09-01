package com.example.mylap.mycv;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.eftimoff.viewpagertransformers.FlipVerticalTransformer;

//import com.gigamole.navigationtabbar.ntb.NavigationTabBar;

import com.example.navigationtabbar.ntb.NavigationTabBar;

import java.util.ArrayList;
import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 */
public class ExperienceFragment extends Fragment implements  NavigationTabBar.OnTabBarSelectedIndexListener{


    public ExperienceFragment() {
        // Required empty public constructor
    }


    View view;
    int currentFragmentIndex = 0;

    List<Fragment> fragments = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_experience, container, false);
        initUI();

        return view;
    }


    @SuppressWarnings("unchecked")
    private <T extends View> T $( @IdRes int id) {
        return (T)  view.findViewById(id);
    }


    private void initUI() {


        final NavigationTabBar navigationTabBar =  $(R.id.ntb_vertical);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        setModels(models);

        navigationTabBar.setModels(models);
        //navigationTabBar.setViewPager(viewPager, 0);
        navigationTabBar.setModelIndex(0);


        loadFirstFragment();

        navigationTabBar.setOnTabBarSelectedIndexListener(this);



    }


    private void setModels(ArrayList<NavigationTabBar.Model> models) {


        final String[] colors = getResources().getStringArray(R.array.default_preview);


        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.icon_strength),
                        Color.parseColor(colors[0]))
                        .selectedIcon(getResources().getDrawable(R.drawable.icon_strength_selected))
                        .badgeTitle("Strengths")
                        .title("Strengths")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.icon_briefcase_experience),
                        Color.parseColor(colors[1]))
                        .selectedIcon(getResources().getDrawable(R.drawable.icon_businessman_experience))
                        .badgeTitle("Experience")
                        .title("Experience")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_fifth),
                        Color.parseColor(colors[2]))
                        .selectedIcon(getResources().getDrawable(R.drawable.ic_second))
                        .badgeTitle("Awards")
                        .title("Awards")
                        .build()
        );

    }



    private void loadFirstFragment() {


        fragments.add(new ListFragment());
        fragments.add(new ListFragment());
        fragments.add(new ListFragment());

        Bundle bundle=new Bundle();
        bundle.putInt("index", 0);

        fragments.get(0).setArguments(bundle);


        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction()
                .addToBackStack( String.valueOf(0))
                .add(R.id.fragment_list_frame, fragments.get(0));

        fragmentTransaction.commitAllowingStateLoss();


    }


    @Override
    public void onStartTabSelected(NavigationTabBar.Model model, int index) {

    }

    @Override
    public void onEndTabSelected(NavigationTabBar.Model model, int index) {

        if (index != currentFragmentIndex) {

            Bundle bundle = new Bundle();
            bundle.putInt("index", index);

            fragments.get(index).setArguments(bundle);


            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();

            if (index > currentFragmentIndex)
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_up, R.anim.exit_to_down , R.anim.enter_from_down, R.anim.exit_to_up);
            else
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_down, R.anim.exit_to_up , R.anim.enter_from_up, R.anim.exit_to_down );


            fragmentTransaction.replace(R.id.fragment_list_frame, fragments.get(index));

            fragmentTransaction.commitAllowingStateLoss();
            currentFragmentIndex = index;
        }


    }


}
