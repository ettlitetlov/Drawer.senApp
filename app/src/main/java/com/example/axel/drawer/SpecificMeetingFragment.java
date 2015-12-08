package com.example.axel.drawer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SpecificMeetingFragment extends Fragment {


    public SpecificMeetingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Möte");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.toolbar_light_orange));

        View view = inflater.inflate(R.layout.fragment_specific_meeting, container, false);    //vad som ska visas?
        final Button incheckad = (Button) view.findViewById(R.id.check_in);                //säg att knappen är incheckad-knappen
        final TextView kanintekomma = (TextView) view.findViewById(R.id.unavailable_clickable);         //klickbar text

        incheckad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Visa ett meddelande om incheckning
                incheckad.setEnabled(false);
                kanintekomma.setEnabled(false);
                incheckad.setBackgroundColor(Color.LTGRAY);       //ändrar färg på knappen när den blivit tryckt på
                String message = "Incheckad!";
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }
        });

        //Klickbar "kan inte komma"-text
        kanintekomma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // Visa ett meddelande om att man tryckt på texten
                incheckad.setBackgroundColor(Color.LTGRAY);       //ändra färg på incheckningsknappen när texten blivit tryckt på
                incheckad.setEnabled(false);
                kanintekomma.setEnabled(false);
                //String message = "Nu får du bjuda på kaffe nästa gång!";
                String message = "Glöm inte att det kanske finns någon som hellre vill ha saft! #bjudpåfika";
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }
        });


        TextView groupName = (TextView)view.findViewById(R.id.meeting_title);
        groupName.setText("Möte med Regeringen");
        TextView place = (TextView)view.findViewById(R.id.place_meeting);
        place.setText("Stadshuset");
        TextView time = (TextView)view.findViewById(R.id.time_meeting);
        time.setText("12:00");
        TextView description = (TextView)view.findViewById(R.id.description_meeting);
        description.setText("Bestämma saker som kan vara avgörande när man är en fisk i underlandet som inte kan simma baklänges");

        return view;
    }

}