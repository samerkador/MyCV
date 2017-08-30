package com.example.mylap.mycv;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dxtt.coolmenu.CoolMenuFrameLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    CoolMenuFrameLayout coolMenuFrameLayout;

    List<Fragment> fragments = new ArrayList<>();

    List<String> titleList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coolMenuFrameLayout = $(R.id.rl_main);
        String[] titles = { "EXPERIENCE","PROJECTS","BASIC INFO"};
        titleList = Arrays.asList(titles);
        coolMenuFrameLayout.setTitles(titleList);


        fragments.add(new BlankFragment());
        fragments.add(new ProjectFragment());
        fragments.add(new PersonalFragment());

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        coolMenuFrameLayout.setAdapter(adapter);

    }

    @SuppressWarnings("unchecked")
    private <T extends View> T $(@IdRes int id) {
        return (T) findViewById(id);
    }


    public void PersonalOnClick(View view) {
        PersonalFragment personalFragment = (PersonalFragment) fragments.get(2);
        personalFragment.HandelOnClickListener(view);
    }


    @Override
    public void onBackPressed() {
        ProjectFragment projectFragment = (ProjectFragment) fragments.get(1);

        if (projectFragment.unfoldableView != null
                && (projectFragment.unfoldableView.isUnfolded() || projectFragment.unfoldableView.isUnfolding())) {
            projectFragment.unfoldableView.foldBack();
        } else {
            super.onBackPressed();
        }

    }
}
