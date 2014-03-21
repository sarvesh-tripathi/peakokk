package com.peakokk.common.logging;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ java.lang.annotation.ElementType.METHOD,
        java.lang.annotation.ElementType.TYPE })
public @interface Loggable
{
    public LogLevel value() default LogLevel.DEBUG;

    public String[] maskedParameters() default {};
}
