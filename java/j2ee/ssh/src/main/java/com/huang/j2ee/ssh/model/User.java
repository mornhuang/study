package com.huang.j2ee.ssh.model;

/**
 * Created By User : Morn
 * Created DateTime: 13-9-21 下午10:49
 * Descriptions    :
 */
public class User {
    private String name;
    private String pass;

    public User() {
    }

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
