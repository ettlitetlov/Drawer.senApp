package com.example.axel.drawer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class GroupFragment extends Fragment {


    public GroupFragment() {
        // Required empty public constructor
    }

    @Override
    /*public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_group, container, false);
    } */

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //testar lite, här under är det tillagt
        View view = inflater.inflate(R.layout.fragment_group, container, false);    //vad som ska visas?
        Button addGroupButton = (Button) view.findViewById(R.id.skapaGrupp);                //säg att knappen är skapaGrupp-knappen
        addGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // Skicka vidare användaren till nästa fragmenten (addGroup)
                AddGroupFragment fragment = new AddGroupFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getActivity().getSupportFragmentManager().beginTransaction(); //getActivity() tillagt innan getSupportF…
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();

            }
        });

        return view;
    }


}
