package com.huang.j2ee.ch02;

/**
 * Created By User : Morn
 * Created DateTime: 2015/3/14 13:50
 * Descriptions    :
 */
public class Magician implements MindReader {
    private String thoughts;

    @Override
    public void interceptThought(String thoughts) {
        System.out.println("Intercepting volunteer's thoughts");
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
