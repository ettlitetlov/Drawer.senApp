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
public class GroupFragment extends Fragment {

    private ArrayList<Group> groupData = new ArrayList<Group>();
    private GroupAdapter groupAdapter;

    public GroupFragment() {
        // Required empty public constructor
        String[] people1 = {"Stefan", "Jan", "Annie"};
        Group group1 = new Group("Regeringen", people1, "slips", "Bestämma saker" );
        String[] people2 = {"Elin", "Rebecca", "Josefine", "Yrsa", "Axel"};
        Group group2 = new Group("Koma Projekt", people2, "clock", "Bestämma saker" );

        groupData.add(group1);
        groupData.add(group2);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        groupAdapter = new GroupAdapter(groupData, getActivity());

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Grupper");
        View view = inflater.inflate(R.layout.fragment_group, container, false);    //vad som ska visas?
        //skapa grupp-knapp
        Button addGroupButton = (Button) view.findViewById(R.id.skapaGrupp);                //säg att knappen är skapaGrupp-knappen
        addGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Skicka vidare användaren till nästa fragmenten (addGroup)
                AddGroupFragment fragment = new AddGroupFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);       //så att man kan gå tillbaka till förra sidan
                fragmentTransaction.commit();

            }
        });

        ListView list = (ListView)view.findViewById(R.id.listOfGroups);
        list.setAdapter(groupAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Skicka vidare användaren till nästa fragmenten (addGroup)
                SpecificGroupFragment fragment = new SpecificGroupFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);       //så att man kan gå tillbaka till förra sidan
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
