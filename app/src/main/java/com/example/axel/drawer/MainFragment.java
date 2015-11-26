package com.example.axel.drawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */

public class MainFragment extends Fragment{

    private ArrayList<Meeting> MeetingData = new ArrayList<Meeting>();
    private ArrayAdapter<Meeting> MeetingAdapter;

    public MainFragment() {
        // Required empty public constructor
        Meeting meet1 = new Meeting("Regeringen", 12, 0, 151201, "Stadshuset", "Bestämma vem som åker ut denna veckan");
        Meeting meet2 = new Meeting("Koma Projekt", 13, 15, 151126, "Tp53", "Göra världens bästa app");
        Meeting meet3 = new Meeting("Schackklubben", 17, 00, 151201, "Colosseum", "Uppvärmingen inför VM" );

        MeetingData.add(meet1);
        MeetingData.add(meet2);
        MeetingData.add(meet3);

        //MeetingAdapter = new ArrayAdapter<Meeting>(getActivity(),android.R.layout.simple_list_item_1, MeetingData);
        //setAdapter(MeetingAdapter);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

}
