package com.example.axel.drawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */

public class MainFragment extends Fragment {

    private ArrayList<Meeting> MeetingData = new ArrayList<Meeting>();
    private MeetingAdapter meetingAdapter;

    public MainFragment() {
        // Required empty public constructor
        Meeting meet1 = new Meeting("Regeringen", 12, 0, "01/12/2015", "Stadshuset", "Bestämma vem som åker ut denna veckan");
        Meeting meet2 = new Meeting("Koma Projekt", 13, 15, "03/12/2015", "Tp53", "Göra världens bästa app");
        Meeting meet3 = new Meeting("Schackklubben", 17, 00, "09/12/2015", "Colosseum", "Uppvärmingen inför VM" );

        MeetingData.add(meet1);
        MeetingData.add(meet2);
        MeetingData.add(meet3);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("SenApp"); //ändra toolbar-titeln
        meetingAdapter = new MeetingAdapter(MeetingData, getActivity());

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        //Grupp-knapp
        Button groupButton = (Button) view.findViewById(R.id.Groups);
        groupButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                GroupFragment fragment = new GroupFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);       //så att man kan gå tillbaka till förra sidan
                fragmentTransaction.commit();
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Grupper");  //ändra toolbar-titeln
            }
        });

        //Boka möte-knapp
        Button bookMeetingButton = (Button) view.findViewById(R.id.BookAMeeting);
        bookMeetingButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                BookAMeeting fragment = new BookAMeeting();  //ska man ändra namn på den här, så den också heter fragment i slutet?
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);       //så att man kan gå tillbaka till förra sidan
                fragmentTransaction.commit();
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Boka möte"); //ändra toolbar-titeln
            }
        });

        ListView list = (ListView)view.findViewById(R.id.listOfMeetings);
        list.setAdapter(meetingAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Skicka vidare användaren till nästa fragmenten (addGroup)
                SpecificMeetingFragment fragment = new SpecificMeetingFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction(); //getActivity() tillagt innan getSupportF…
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);       //så att man kan gå tillbaka till förra sidan
                fragmentTransaction.commit();
            }
        });

        return view;

    }
}
