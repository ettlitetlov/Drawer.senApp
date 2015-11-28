package com.example.axel.drawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

                // Visa ett meddelande om att mötet är tillagd
                String message = "Mötet tillagt!";
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }
        });

        //Det borde vara rätt med ImageButton istället för Button, men det märker vi när knappen
        //syns så att vi kan trycka på den
        ImageButton cancelAddMeeting = (ImageButton) view.findViewById(R.id.cancelMeeting);                //säg att knappen är cancel-knappen
        cancelAddMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // Skicka tillbaka användaren till där den var innan?
                MainFragment fragment = new MainFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction(); //getActivity() tillagt innan getSupportF…
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);       //så att man kan gå tillbaka till förra sidan
                fragmentTransaction.commit();

                // Visa ett meddelande om att mötet är tillagd
                String message = "Mötet tillagt!";
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }
        });

        return view;
    }

}
