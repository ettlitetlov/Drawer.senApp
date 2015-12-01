package com.example.axel.drawer;

/**
 * Created by Rebecca on 2015-11-28.
 */
public class Group {
    private long id;
    private String groupName;
    private String[] members;
    private String picture;
    private String description;

    public Group(){}

    public Group(String theGroupName, String[] theMembers, String thePicture, String theDescription){
        groupName = theGroupName;
        members = theMembers;
        picture = thePicture;
        description = theDescription;
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

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public String[] getMembers() {
        return members;
    }

}
