package com.suzhoushui.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckToken {
    final static int user_tpye = 1;
    final static int admin_tpye = 2;//fatrue 用户类型

    boolean required() default true;    //要不要进行检查 默认是检查

    int type() default user_tpye;
}
