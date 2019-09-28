package com.nitjsr.urja1920.Models;

public class TeamPerson {

    String name,phone,insta;
    int imgurl;

    public TeamPerson(String name, int imgurl, String phone, String insta) {
        this.imgurl = imgurl;
        this.name = name;
        this.phone = phone;
        this.insta = insta;
    }

    public int getImgurl() {
        return imgurl;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getInsta() {
        return insta;
    }
}
