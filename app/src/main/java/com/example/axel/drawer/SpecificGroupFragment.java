package com.example.axel.drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SpecificGroupFragment extends Fragment {

    private ArrayList<Statistic> statisticData = new ArrayList<Statistic>();
    private StatisticAdapter statisticAdapter;
    private ArrayList<Meeting> meetingData = new ArrayList<Meeting>();
    private MeetingAdapterInSpecificGroup meetingAdapter;


    public SpecificGroupFragment() {
        // Required empty public constructor
        String[] members = {"Stefan", "Jan", "Annie"};
        int[] late = {45, 27, 7};
        Statistic stat1 = new Statistic("Stefan", 45);
        Statistic stat2 = new Statistic("Jan", 27);
        Statistic stat3 = new Statistic("Annie", 7);
        Statistic stat4 = new Statistic("Gustav", 4);
        Statistic stat5 = new Statistic("Åsa", 2);

        statisticData.add(stat1);
        statisticData.add(stat2);
        statisticData.add(stat3);
        statisticData.add(stat4);
        statisticData.add(stat5);


        Meeting meet1 = new Meeting("Regeringen", 12, 0, "01/12/2015", "Stadshuset", "Bestämma vem som åker ut denna veckan");
        meetingData.add(meet1);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        statisticAdapter = new StatisticAdapter(statisticData, getActivity());
        meetingAdapter = new MeetingAdapterInSpecificGroup(meetingData, getActivity());

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Regeringen");   //Specifikt för regeringen
        View view = inflater.inflate(R.layout.fragment_specific_group, container, false);    //vad som ska visas
        Button addGroupButton = (Button) view.findViewById(R.id.newMeeting);                //säg att knappen är nyttMöte-knappen
        addGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Skicka vidare användaren till nästa fragmenten (BookAMeeting)
                BookAMeeting fragment = new BookAMeeting();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction(); //getActivity() tillagt innan getSupportF…
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);       //så att man kan gå tillbaka till förra sidan
                fragmentTransaction.commit();
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Boka möte");    //ändra titeln

            }
        });


        TextView groupName = (TextView)view.findViewById(R.id.groupName);
        groupName.setText("Regeringen");
        TextView no_members = (TextView)view.findViewById(R.id.groupMembers);
        no_members.setText(statisticData.size() + " medlemmar");

        ListView listStat = (ListView)view.findViewById(R.id.listStats);
        listStat.setAdapter(statisticAdapter);
        justifyListViewHeightBasedOnChildren(listStat);

        ListView listMeeting = (ListView)view.findViewById(R.id.listMeeting);
        listMeeting.setAdapter(meetingAdapter);
        justifyListViewHeightBasedOnChildren(listMeeting);

        listMeeting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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


    public void justifyListViewHeightBasedOnChildren (ListView listView) {

        ListAdapter adapter = listView.getAdapter();

        if (adapter == null) {
            return;
        }
        ViewGroup vg = listView;
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, vg);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(par);
        listView.requestLayout();
    }

}
