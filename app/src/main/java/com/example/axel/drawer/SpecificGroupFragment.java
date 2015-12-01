package com.example.axel.drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SpecificGroupFragment extends Fragment {

    private ArrayList<Statistic> statisticData = new ArrayList<Statistic>();
    private StatisticAdapter statisticAdapter;
    private ArrayList<Meeting> meetingData = new ArrayList<Meeting>();
    private MeetingAdapter meetingAdapter;

    public SpecificGroupFragment() {
        // Required empty public constructor
        String[] members = {"Stefan", "Jan", "Annie"};
        int[] late = {45, 27, 7};
        Statistic stat1 = new Statistic("Stefan", 45);
        Statistic stat2 = new Statistic("Jan", 27);
        Statistic stat3 = new Statistic("Annie", 7);

        statisticData.add(stat1);
        statisticData.add(stat2);
        statisticData.add(stat3);

        Meeting meet1 = new Meeting("Regeringen", 12, 0, 151201, "Stadshuset", "Bestämma vem som åker ut denna veckan");
        meetingData.add(meet1);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        statisticAdapter = new StatisticAdapter(statisticData, getActivity());
        meetingAdapter = new MeetingAdapter(meetingData, getActivity());


        View view = inflater.inflate(R.layout.fragment_specific_group, container, false);    //vad som ska visas
        Button addGroupButton = (Button) view.findViewById(R.id.newMeeting);                //säg att knappen är nyttMöte-knappen
        addGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // Skicka vidare användaren till nästa fragmenten (BookAMeeting)
                BookAMeeting fragment = new BookAMeeting();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction(); //getActivity() tillagt innan getSupportF…
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);       //så att man kan gå tillbaka till förra sidan
                fragmentTransaction.commit();

            }
        });

        ListView listStat = (ListView)view.findViewById(R.id.listStats);
        listStat.setAdapter(statisticAdapter);
        ListView listMeeting = (ListView)view.findViewById(R.id.listMeeting);
        listMeeting.setAdapter(meetingAdapter);

        return view;
        //return inflater.inflate(R.layout.fragment_specific_group, container, false);
    }

}
