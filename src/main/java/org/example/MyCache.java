package org.example;

public @interface MyCache {
    long ttl() default 6000L;
}
