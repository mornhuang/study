package com.huang.j2ee.ch02;

/**
 * Created By User : Morn
 * Created DateTime: 2015/3/14 13:54
 * Descriptions    :
 */
public class Volunteer implements Thinker {
    private String thoughts;

    @Override
    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getThoughts() {
        return thoughts;
    }
}
