package com.ibiz.api.utils;

import com.ibiz.api.utils.Enum.CellType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnAttribute {
    boolean Hide() default false;

    int Index() default 0;

    String Title() default "";

    boolean IsRowMerge() default false;

    String CellStyleMethodName() default "";

    int ColumnWidth() default 100;

    CellType CellType() default CellType.None;

    boolean IsColumnMerge() default false;
}
