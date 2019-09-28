package com.nitjsr.urja1920.Models;

public class Devperson {

    String name,whats,insta,linkd;
    int img;

    public Devperson(String name, String whats, String insta, String linkd, int img) {
        this.name = name;
        this.whats = whats;
        this.insta = insta;
        this.linkd = linkd;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getWhats() {
        return whats;
    }

    public String getInsta() {
        return insta;
    }

    public String getLinkd() {
        return linkd;
    }

    public int getImg() {
        return img;
    }
}
