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
 * Created by Rebecca on 2015-12-01.
 */
public class StatisticAdapter extends BaseAdapter {

    private ArrayList<Statistic> statistics;
    private Context context;

    public StatisticAdapter(ArrayList<Statistic> theStatistics, Context context) {
        this.statistics = theStatistics;
        this.context = context;
    }

    @Override
    public int getCount() {
        return statistics.size();
    }

    @Override
    public Object getItem(int position) {
        return statistics.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        RelativeLayout layout = (RelativeLayout)layoutInflater.inflate(R.layout.item_statistics_list, parent, false);

        TextView memberName = (TextView)layout.findViewById(R.id.list_member_name);
        memberName.setText(statistics.get(position).getName());
        TextView late = (TextView)layout.findViewById(R.id.list_minutes);
        late.setText(statistics.get(position).getLate_min() + " min");

        return layout;
    }
}
