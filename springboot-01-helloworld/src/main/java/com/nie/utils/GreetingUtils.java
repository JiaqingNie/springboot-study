package com.nie.utils;

import com.nie.pojo.Person;

public class GreetingUtils {

    public static String getGreeting(String name, String title){
        String greeting = "Hello, " + name + " " + title + "!";
        return greeting;
    }

    public static String getGreeting(Person person){
        String greeting = "Hello, "+ person + "!";
        return greeting;
    }
}
