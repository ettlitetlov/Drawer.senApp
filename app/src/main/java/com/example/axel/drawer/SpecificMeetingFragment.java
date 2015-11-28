package com.example.axel.drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class SpecificMeetingFragment extends Fragment {


    public SpecificMeetingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_specific_meeting, container, false);    //vad som ska visas?
        Button incheckad = (Button) view.findViewById(R.id.check_in);                //säg att knappen är incheckad-knappen
        incheckad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*//Hoppa tillbaka till group-sidan igen
            GroupFragment fragment = new GroupFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getActivity().getSupportFragmentManager().beginTransaction(); //getActivity() tillagt innan getSupportF…
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);       //så att man kan gå tillbaka till förra sidan
            fragmentTransaction.commit();*/

                // Visa ett meddelande om att gruppen är tillagd
                String message = "Incheckad!";
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }
        });

        return view;
    }

}