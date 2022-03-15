package org.example;

public class User {
    public String name = "hxy";

    @MyCache
    public String say() {
        // System.out.println("this is say method: " + this.getClass().getName());
        return "hello";
    }

    public String say(String word) {
        // System.out.println("this is say(word) method: " + this.getClass().getName());
        return "hello" + word;
    }
}
