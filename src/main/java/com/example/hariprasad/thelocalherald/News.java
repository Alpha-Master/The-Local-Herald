package com.example.hariprasad.thelocalherald;

/**
 * Created by Hari Prasad on 22-11-2017.
 */

public class News {

    String heading;
    String description;
    String date;
    String location;

    public News(String h, String d, String dt, String l)
    {
        this.heading = h;
        this.description = d;
        this.date = dt;
        this.location = l;
    }
}
