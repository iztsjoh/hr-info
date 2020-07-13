package com.ibiz.api.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CellStyleClassAttribute {
    Class<?>[] ClassType() default {};

    String CellStyleMethodName() default "";
}