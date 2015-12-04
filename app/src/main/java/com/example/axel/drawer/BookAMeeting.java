package com.example.axel.drawer;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookAMeeting extends Fragment implements TimePickerDialog.OnTimeSetListener {

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((AppCompatActivity) getActivity()).getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.toolbar_light_orange));

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
                //Skicka tillbaka användaren till förra fragmenten
                getFragmentManager().popBackStack();

                // Visa ett meddelande om att man tröck (heh) på kryss-knappen
                String message = "Ojoj, det blev inget möte.";
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }
        });

        return view;
    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user
        TextView tv1=(TextView) getActivity().findViewById(R.id.add_time);
        tv1.setText(+view.getCurrentHour() + ":" + view.getCurrentMinute());
    }

}
