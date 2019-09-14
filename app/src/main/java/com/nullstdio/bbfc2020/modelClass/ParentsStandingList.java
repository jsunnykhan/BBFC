package com.nullstdio.bbfc2020.modelClass;

import java.util.List;

public class ParentsStandingList {


    private String groupName;
    private List<ChildStandingList> groupChild;

    public ParentsStandingList(String groupName, List<ChildStandingList> groupChild) {
        this.groupName = groupName;
        this.groupChild = groupChild;
    }

    public ParentsStandingList() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<ChildStandingList> getGroupChild() {
        return groupChild;
    }

    public void setGroupChild(List<ChildStandingList> groupChild) {
        this.groupChild = groupChild;
    }
}
