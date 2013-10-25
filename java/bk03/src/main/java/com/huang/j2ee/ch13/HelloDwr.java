package com.huang.j2ee.ch13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date : 2013-10-25 16:12
 */
public class HelloDwr {
    public String hello(String name) {
        return name + ", Hello! you arg beginning to learn dwr. Enjoy yourself";
    }

    public String sendObj(Person p) {
        return p.getName() + ", you have learned how to use JavaBean Param";
    }

    public Person getBean(String name) {
        return new Person(name);
    }

    public Cat getObject(String name) {
        return new Cat("Service side " + name);
    }

    public List<Person> getPersonList() {
        List<Person> result = new ArrayList<Person>();
        result.add(new Person("aaa"));
        result.add(new Person("bbb"));
        result.add(new Person("ccc"));
        return result;
    }

    public Person[] getPersonArray() {
        Person[] result = new Person[3];
        result[0] = new Person("a");
        result[1] = new Person("b");
        result[2] = new Person("c");
        return result;
    }

    public Map<String, Person> getPersonMap() {
        Map<String, Person> result = new HashMap<String, Person>();
        result.put("first", new Person("aa"));
        result.put("second", new Person("bb"));
        result.put("three", new Person("cc"));
        return result;
    }

    public String sendList(List<Person> pl) {
        String result = "";
        for (Person p: pl) {
            result += p.getName() + "<br />";
        }
        return result;
    }

    public String sendListNoGeneric(List pl) {
        String result = "";
        for (Object p: pl) {
            result += ((Person)p).getName() + "<br />";
        }
        return result;
    }

    public String sendMap(Map<String, Person> pl) {
        String result = "";
        for (String key: pl.keySet()) {
            result += "Key: " + key + "Value: " + pl.get(key).getName();
        }
        return result;
    }
}
