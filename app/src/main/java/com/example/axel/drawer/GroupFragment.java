package com.example.axel.drawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GroupFragment extends Fragment {

    private ArrayList<Group> groupData = new ArrayList<Group>();
    private GroupAdapter groupAdapter;
    //Toolbar toolbar = null;                  //så att vi ska kunna ändra titeln

    public GroupFragment() {
        // Required empty public constructor
        String[] people1 = {"Stefan", "Jan", "Annie"};
        Group group1 = new Group("Regeringen", people1, "picture", "Bestämma saker" );
        String[] people2 = {"Elin", "Rebecca", "Josefine", "Yrsa", "Axel"};
        Group group2 = new Group("Koma Projekt", people2, "picture", "Bestämma saker" );

        groupData.add(group1);
        groupData.add(group2);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        groupAdapter = new GroupAdapter(groupData, getActivity());

        View view = inflater.inflate(R.layout.fragment_group, container, false);    //vad som ska visas?
        Button addGroupButton = (Button) view.findViewById(R.id.skapaGrupp);                //säg att knappen är skapaGrupp-knappen
        addGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // Skicka vidare användaren till nästa fragmenten (addGroup)
                AddGroupFragment fragment = new AddGroupFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction(); //getActivity() tillagt innan getSupportF…
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);       //så att man kan gå tillbaka till förra sidan
                fragmentTransaction.commit();
                //toolbar.setTitle("Lägg till grupp");            //ändra titeln


            }
        });

        ListView list = (ListView)view.findViewById(R.id.listOfGroups);
        list.setAdapter(groupAdapter);

        return view;
    }

}
