package com.company.model;

public enum studyFormat {
    ONLINE("ONLINE"),
    OFLINE("OFLINE");

    private final  String format;

    studyFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
