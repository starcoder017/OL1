package com.example.nikhil.openlink1;

/**
 * Created by nikhil on 17/4/17.
 */

import com.google.firebase.database.IgnoreExtraProperties;


public class User {

    public  String link;
    public  Long id;
    public String email;

    public User()
    {

    }

    public User(String link,Long id,String email)
    {
        this.link = link;
        this.id = id;
        this.email = email;

    }

}

