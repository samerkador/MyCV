package com.example.mylap.mycv;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mylap.mycv.items.RecViewAdapterStrength;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {


    public ListFragment() {
        // Required empty public constructor
    }


    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        int arrayIndex=getArguments().getInt("index");

        view = inflater.inflate(R.layout.fragment_list, container, false);

        loadList(arrayIndex);

        return view;
    }



    private View loadList( int list) {


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
