package com.example.axel.drawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddGroupFragment extends Fragment {


    public AddGroupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_group, container, false);

        //Det här borde funka, den det gör det visst inte.
        /*View view = inflater.inflate(R.layout.fragment_group, container, false);    //vad som ska visas?
        Button groupAdded = (Button) view.findViewById(R.id.Create);                //säg att knappen är Create-knappen
        groupAdded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                // Visa ett meddelande om att gruppen är tillagd
                String message = "Grupp tillagd!";
                //Toast.makeText(getBaseContext(), "Grupp tillagd!", Toast.LENGTH_SHORT
                Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();

            }
        });

        return view; */
    }

}
