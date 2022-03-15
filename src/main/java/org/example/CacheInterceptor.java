package org.example;

import net.bytebuddy.implementation.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class CacheInterceptor {

    @RuntimeType
    public static Object intercept(@Origin Method m, @SuperCall Callable<?> c) throws Exception {
        long start = System.nanoTime();
        try {
            return c.call();
        } finally {
            long end = System.nanoTime();
            System.out.println("Call to " + m + " took " + (end - start) +" ns");
        }
    }
}
