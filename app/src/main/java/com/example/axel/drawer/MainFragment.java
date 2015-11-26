package com.example.axel.drawer;


import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main, container, false);

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Button groupButton = (Button) view.findViewById(R.id.Groups);
        groupButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                GroupFragment fragment = new GroupFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        Button bookMeetingButton = (Button) view.findViewById(R.id.BookAMeeting);
        bookMeetingButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                BookAMeeting fragment = new BookAMeeting();         //ska man ändra namn på den här, så den också heter fragment i slutet?
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();;
            }
        });

        return view;
    }

}
