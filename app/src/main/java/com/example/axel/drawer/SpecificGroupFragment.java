package com.example.axel.drawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class SpecificGroupFragment extends Fragment {

    //Toolbar toolbar = null;             //så att vi ska kunna ändra titeln

    public SpecificGroupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
                //toolbar.setTitle("Boka möte");                  //ändra titeln

            }
        });

        return view;

    }

}
