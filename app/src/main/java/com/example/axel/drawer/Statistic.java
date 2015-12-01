package com.example.axel.drawer;

/**
 * Created by Rebecca on 2015-12-01.
 */
public class Statistic {
    private long id;
    private String name;
    private int late_min;

    public Statistic() {
    }

    public Statistic(String theName, int theLateMin){
        name = theName;
        late_min = theLateMin;
    }

    public long getId() {
        return id;
    }

    public String getName(){ return name;}

    public int getLate_min(){ return late_min;}
}
