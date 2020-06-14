package com.ample16.backend.entity;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AuthScope {
    String value() default "";
}
