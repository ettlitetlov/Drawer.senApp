package com.example.axel.drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
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

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Lägg till grupp");  //ändra toolbar-titeln

        View view = inflater.inflate(R.layout.fragment_add_group, container, false);    //vad som ska visas
        //skapa grupp-knappen
        Button groupAdded = (Button) view.findViewById(R.id.Create);                //säg att knappen är Create-knappen
        groupAdded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Hoppa tillbaka till group-sidan igen
                getFragmentManager().popBackStack();

                // Visa ett meddelande om att gruppen är tillagd
                String message = "Grupp tillagd!";
                //Toast.makeText(getBaseContext(), "Grupp tillagd!", Toast.LENGTH_SHORT
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }
        });

        return view;
    }

}
