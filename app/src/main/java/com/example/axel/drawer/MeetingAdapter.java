package com.example.axel.drawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rebecca on 2015-11-26.
 */
public class MeetingAdapter extends BaseAdapter{

    private ArrayList<Meeting> meetings;
    private Context context;

    public MeetingAdapter(ArrayList<Meeting> meetings, Context context) {
        this.meetings = meetings;
        this.context = context;
    }

    @Override
    public int getCount() {
        return meetings.size();
    }

    @Override
    public Object getItem(int position) {
        return meetings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        RelativeLayout layout = (RelativeLayout)layoutInflater.inflate(R.layout.item_meeting_list, parent, false);

        TextView date = (TextView)layout.findViewById(R.id.list_date);
        date.setText(meetings.get(position).getDate());
        TextView group = (TextView)layout.findViewById(R.id.list_groupname);
        group.setText(meetings.get(position).getGroupName());
        TextView time = (TextView)layout.findViewById(R.id.list_time);
        time.setText(meetings.get(position).gethh() + ":" + meetings.get(position).getmm());


        return layout;
    }
}
