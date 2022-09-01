package com.example.hw3.customRunner;

import com.example.hw3.tests.AfterTest;
import com.example.hw3.tests.BeforeTest;
import com.example.hw3.tests.Test;
import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomRunner {

    @SneakyThrows
    public CustomRunner(Class<?> clazz) {
        launch(clazz);
    }

    @SneakyThrows
    private void launch(Class<?> classTest) {
        int success = 0;
        int failed = 0;
        int count = 0;
        Method[] methods = classTest.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                method.setAccessible(true);
                count++;
                Object obj = classTest.getDeclaredConstructor().newInstance();
                beforeInvoke(methods, obj);
                try {
                    method.invoke(obj);
                    System.out.printf("Test %s is succeeded %n", count);
                    success++;
                } catch (Throwable e) {
                    e.printStackTrace();
                    failed++;
                    System.out.printf("Test %s is failed %n", count);
                }
                afterInvoke(methods, obj);
            }
        }
        System.out.printf("Test %s / %s succeeded %n", count, success);
        System.out.printf("Test %s / %s failed", count, failed);

    }

    @SneakyThrows
    public void beforeInvoke(Method[] methods, Object obj) {
        List<Method> beforeMethods;
        beforeMethods = Arrays.stream(methods).filter(method -> method
                .isAnnotationPresent(BeforeTest.class))
                .peek(method -> method.setAccessible(true))
                .collect(Collectors.toList());
        for (Method beforeMethod : beforeMethods) {

            beforeMethod.invoke(obj);
        }
    }

    @SneakyThrows
    public void afterInvoke(Method[] methods, Object obj) {
        List<Method> afterMethods;
        afterMethods = Arrays.stream(methods).filter(method -> method
                .isAnnotationPresent(AfterTest.class))
                .peek(method -> method.setAccessible(true))
                .collect(Collectors.toList());
        for (Method afterMethod : afterMethods) {
            afterMethod.invoke(obj);
        }
    }
}
