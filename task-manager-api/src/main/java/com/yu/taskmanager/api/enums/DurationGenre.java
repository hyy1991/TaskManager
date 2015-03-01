package com.yu.taskmanager.api.enums;

/**
 * Created by yu on 15-2-11.
 */
public enum DurationGenre {

    DEFAULT(0, ""),
    ESTIMATE(1, ""),
    ACTUAL(2, "");

    private int genre;
    private String description;

    private DurationGenre(int genre, String description) {
        this.genre = genre;
        this.description = description;
    }

    public String toString() {
        return this.description;
    }

    public int valueOf() {
        return this.genre;
    }
}
