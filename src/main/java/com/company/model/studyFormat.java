package com.company.model;

public enum studyFormat {
    ONLINE("online"),
    OFFLINE("offline");


    private String string;

    studyFormat(String string) {
        this.string = string;
    }
}
