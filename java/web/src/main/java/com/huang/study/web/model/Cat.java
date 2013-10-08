package com.huang.study.web.model;

import javax.persistence.Embeddable;

/**
 * Created By User : Morn
 * Created DateTime: 13-9-23 下午7:00
 * Descriptions    :
 */
@Embeddable
public class Cat {
    private String name;
    private String color;

    public Cat() {
    }

    public Cat(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}