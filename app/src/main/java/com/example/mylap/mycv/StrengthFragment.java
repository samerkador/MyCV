package com.example.mylap.mycv;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

//import com.example.mylap.mycv.items.ListViewAdapterStrength;
import com.example.mylap.mycv.model.Strength;
import com.example.mylap.mycv.utils.UtilsStrength;
//import com.yalantis.flipviewpager.utils.FlipSettings;


/**
 * A simple {@link Fragment} subclass.
 */
public class StrengthFragment extends Fragment {


    public StrengthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_strength, container, false);

//        final ListView friends = (ListView) view.findViewById(R.id.list_view_strengths);
//
//        FlipSettings settings = new FlipSettings.Builder().defaultPage(1).build();
//
//        friends.setAdapter(new ListViewAdapterStrength( getActivity(), UtilsStrength.strengths, settings));
//
//        friends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Strength f = (Strength) friends.getAdapter().getItem(position);
//
//              //  Toast.makeText(StrengthActivity.this, f.getNickname(), Toast.LENGTH_SHORT).show();
//            }
//        });

        return view;
    }

}
