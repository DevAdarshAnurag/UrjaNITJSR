package com.nitjsr.urja1920.Models;

import java.io.Serializable;

public final class Photo implements Serializable
{

    private static final long serialVersionUID = 1L;

    public final String name;

    public final int image;

    public Photo(String name, int image)
    {
        this.name = name;
        this.image = image;
    }

}
