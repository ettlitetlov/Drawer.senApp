package com.example.axel.drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookAMeeting extends Fragment {

    //Toolbar toolbar = null;                             //så att vi ska kunna ändra titeln

    public BookAMeeting() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //testar lite, här under är det tillagt
        View view = inflater.inflate(R.layout.fragment_book_ameeting, container, false);    //vad som ska visas
        Button addGroupMeeting = (Button) view.findViewById(R.id.createMeeting);                //säg att knappen är bokaMöte-knappen
        addGroupMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // Skicka vidare användaren till nästa fragmenten (MainFragment)
                MainFragment fragment = new MainFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction(); //getActivity() tillagt innan getSupportF…
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);       //så att man kan gå tillbaka till förra sidan
                fragmentTransaction.commit();
                //toolbar.setTitle("SenApp");                     //ändra titeln till "SenApp"

                // Visa ett meddelande om att mötet är tillagd
                String message = "Mötet tillagt!";
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);     //vi vill ha den i mitten, centrum liksom
                toast.show();                   //visa toast-meddelandet

            }
        });

        //Det borde vara rätt med ImageButton istället för Button, men det märker vi när knappen
        //syns så att vi kan trycka på den
        Button cancelAddMeeting = (Button) view.findViewById(R.id.cancelMeeting);   //säg att knappen är cancel-knappen
        cancelAddMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // Skicka tillbaka användaren till där den var innan?       <-- kolla upp detta
                //tillfälligt kommer användare tillbaka till startsidan
                MainFragment fragment = new MainFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction(); //getActivity() tillagt innan getSupportF…
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);       //så att man kan gå tillbaka till förra sidan
                fragmentTransaction.commit();

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
