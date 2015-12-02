package com.example.axel.drawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rebecca on 2015-11-28.
 */
public class GroupAdapter extends BaseAdapter{

    private ArrayList<Group> groups;
    private Context context;

    public GroupAdapter(ArrayList<Group> groups, Context context) {
        this.groups = groups;
        this.context = context;
    }

    @Override
    public int getCount() {
        return groups.size();
    }

    @Override
    public Object getItem(int position) {
        return groups.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        RelativeLayout layout = (RelativeLayout)layoutInflater.inflate(R.layout.item_group_list, parent, false);

        ImageView picture = (ImageView)layout.findViewById(R.id.image);
        picture.setImageResource(getImageId(context, groups.get(position).getPicture())); //.(groups.get(position).getDate());

        TextView groupName = (TextView)layout.findViewById(R.id.groupName);
        groupName.setText(groups.get(position).getGroupName());

        return layout;
    }

}
