package com.example.axel.drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookAMeeting extends Fragment {

    public BookAMeeting() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_book_ameeting, container, false);    //vad som ska visas
        //boka möte-knappen
        Button addGroupMeeting = (Button) view.findViewById(R.id.createMeeting);                //säg att knappen är bokaMöte-knappen
        addGroupMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // Skicka tillbaka användaren till förra fragmenten
                getFragmentManager().popBackStack();

                // Visa ett meddelande om att mötet är tillagd
                String message = "Mötet tillagt!";
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);     //vi vill ha den i mitten, centrum liksom
                toast.show();                   //visa toast-meddelandet

            }
        });

        //avbryt-knappen
        Button cancelAddMeeting = (Button) view.findViewById(R.id.cancelMeeting);   //säg att knappen är cancel-knappen
        cancelAddMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                getFragmentManager().popBackStack();        //Hoppar tillbaka till sidan användaren var på innan

                // Visa ett meddelande om att man tröck (heh) på kryss-knappen
                String message = "Ojoj, det blev inget möte.";
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }
        });

        return view;
    }



}
