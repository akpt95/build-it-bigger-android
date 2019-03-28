package com.udacity.gradle.builditbigger.backend;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String jokeData;

    public String getJokeData() {
        return jokeData;
    }

    public void setJokeData(String jokeData){
        this.jokeData = jokeData;
    }

}