import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.example.CacheInterceptor;
import org.example.MyCache;
import org.example.Student;
import org.example.User;

import java.lang.instrument.Instrumentation;

public class Main {
    public static void premain(String arg, Instrumentation inst) {
        new AgentBuilder.Default()
                .type(ElementMatchers.any())
                .transform((builder, typeDescription, classLoader, javaModule) -> builder
                        .method(ElementMatchers.isAnnotatedWith(MyCache.class)).intercept(MethodDelegation.to(CacheInterceptor.class))
                )
                .installOn(inst);
    }

    public static void main(String[] args) {
        //org.example.User user = clazz.getDeclaredConstructor().newInstance();
        premain(null, ByteBuddyAgent.install());
        User user = new User();
        System.out.println(user.say());
        System.out.println(user.say("aaa"));
        System.out.println(new Student().study());
    }


}