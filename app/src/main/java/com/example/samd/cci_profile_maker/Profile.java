package com.example.samd.cci_profile_maker;

import java.io.Serializable;

/**
 * Created by samd on 10/25/2017.
 */

public class Profile implements Serializable
{
    String name;
    String email;
    String department;
    Integer mood;
    Integer avatar;


    public Profile(String name, String email, String department, Integer mood, Integer avatar) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.mood = mood;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", mood=" + mood +
                ", avatar=" + avatar +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getMood() {
        return mood;
    }

    public Integer getAvatar() {
        return avatar;
    }
}
