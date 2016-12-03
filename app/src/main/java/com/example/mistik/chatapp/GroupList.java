package com.example.mistik.chatapp;

import java.util.Date;

/**
 * Created by mistik on 3.12.2016.
 */

public class GroupList {
    private String groupName;
    private Long coordinateX;
    private Long coordinateY;

    public GroupList(String groupName, Long coordinateX, Long coordinateY) {
        this.groupName = groupName;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public GroupList() {
    }

    public Long getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(Long coordinateX) {
        this.coordinateX = coordinateX;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(Long coordinateY) {
        this.coordinateY = coordinateY;
    }
}
