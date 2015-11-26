package com.example.axel.drawer;

/**
 * Created by Rebecca on 2015-11-26.
 */
public class Meeting {

        private long id;
        private String groupName;
        private int hh;
        private int mm;
        private int date;
        private String place;
        private String description;

        public Meeting(){

        }

        public Meeting(String thename, int thehh, int themm, int thedate, String theplace, String thedescription){
            groupName = thename;
            hh = thehh;
            mm = themm;
            date = thedate;
            place = theplace;
            description = thedescription;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getGroupName() {
            return groupName;
        }

        public int gethh() {
            return hh;
        }

        public int getmm() {
        return mm;
    }

        public int getDate() {
        return date;
    }

        public String getPlace() {
            return place;
        }

        public String getDescription() {
            return description;
        }

        public void setMeeting(String group, int hh, int mm, int date, String place, String description) {
            this.groupName = groupName;
            this.hh = hh;
            this.mm = mm;
            this.date = date;
            this.place = place;
            this.description = description;
        }

        // Will be used by the ArrayAdapter in the ListView
        @Override
        public String toString() {
            return String.format("%s%d%d", groupName, hh, mm);
        }
}


