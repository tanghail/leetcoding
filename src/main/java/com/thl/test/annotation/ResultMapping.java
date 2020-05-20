package com.thl.test.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD,ElementType.CONSTRUCTOR,ElementType.FIELD ,ElementType.TYPE})
public @interface ResultMapping {
    String value() default "test";

    boolean madeInChina() default true;

    String name() default "qirui qq";

}
