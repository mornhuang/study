package com.huang.j2ee.ch02;

/**
 * Created By User : Morn
 * Created DateTime: 2015/3/11 11:27
 * Descriptions    :
 */
public class Person {
    private City city;
    private String setting;
    private String homePath;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public void showValue() {
        System.out.println("Name: " + city.getName());
        System.out.println("State: " + city.getState());
        System.out.println("Populate: " + city.getPopulation());
        System.out.println("Setting: " + setting);
        System.out.println("HomePath: " + homePath);
    }

    public String getHomePath() {
        return homePath;
    }

    public void setHomePath(String homePath) {
        this.homePath = homePath;
    }
}
