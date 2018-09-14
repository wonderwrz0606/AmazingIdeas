package com.samnjoyin.www.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FirstMethodLevelAnnotation {

    enum LEVEL {
        LOW, MEDIUM, HIGH
    }

    LEVEL level() default LEVEL.LOW;
    String message() default "A default customized annotation message";
    int id() default 0;
}
