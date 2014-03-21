package com.peakokk.service.aop;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.peakokk.common.logging.LogLevel;
import com.peakokk.common.logging.Loggable;
import com.peakokk.service.logging.ILoggingService;

@Aspect
@Component
public class LoggingAspect extends BaseAspect
{
    public static String BEFORE_STRING = "Enter: {}";

    public static String AFTER_THROWING = "Exception thrown {}, exception message {}";

    public static String AFTER_RETURNING = "Exit: {}";

    @Autowired
    ILoggingService loggingService;

    @AfterReturning(value = "(publicMethod() && beanAnnotatedWithLoggable()) || @annotation(com.peakokk.common.logging.Loggable)", returning = "returnValue", argNames = "joinPoint, returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue)
    {
        try
        {
            Loggable loggable = getLoggable(joinPoint);
            Class<?> clazz = joinPoint.getTarget().getClass();
            String name = joinPoint.getSignature().getName();

            loggingService.log(loggable.value(), clazz, name, AFTER_RETURNING, returnValue);
        }
        catch (Exception e)
        {
            loggingService.log(LogLevel.ERROR, this.getClass(), "afterReturning", AFTER_THROWING, e);
        }
    }

    @AfterThrowing(value = "(publicMethod() && beanAnnotatedWithLoggable()) || @annotation(com.peakokk.common.logging.Loggable)", throwing = "throwable", argNames = "joinPoint, throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable)
    {
        try
        {
            Class<?> clazz = joinPoint.getTarget().getClass();
            String name = joinPoint.getSignature().getName();

            loggingService.log(LogLevel.ERROR, clazz, name, AFTER_THROWING, throwable);
        }
        catch (Exception e)
        {
            loggingService.log(LogLevel.ERROR, this.getClass(), "afterThrowing", AFTER_THROWING, e);
        }
    }

    @Pointcut("within(@com.peakokk.common.logging.Loggable *)")
    public void beanAnnotatedWithLoggable()
    {
    }

    @Before(value = "(publicMethod() && beanAnnotatedWithLoggable()) || @annotation(com.peakokk.common.logging.Loggable)", argNames = "joinPoint")
    public void before(JoinPoint joinPoint)
    {
        try
        {
            Class<?> clazz = joinPoint.getTarget().getClass();
            Loggable loggable = getLoggable(joinPoint);
            String name = joinPoint.getSignature().getName();

            Object[] parameters = Arrays.copyOf(joinPoint.getArgs(), joinPoint.getArgs().length);
            List<String> parameterNames = getParameterNames(joinPoint);
            String[] maskedParameters = loggable.maskedParameters();
            if (maskedParameters != null && maskedParameters.length > 0)
            {
                for (String maskedParameter : maskedParameters)
                {

                    int indexOfMaskedParameter = parameterNames.indexOf(maskedParameter);
                    if (indexOfMaskedParameter != -1)
                    {
                        Object parameter = parameters[indexOfMaskedParameter];
                        parameters[indexOfMaskedParameter] = parameter.toString().replaceAll("\\.", "*");
                    }
                }
            }

            loggingService.log(loggable.value(), clazz, name, BEFORE_STRING, getParameterNamesArray(joinPoint),
                    parameters);
        }
        catch (Exception e)
        {
            loggingService.log(LogLevel.ERROR, this.getClass(), "before", AFTER_THROWING, e);
        }
    }

    @Pointcut("execution(public * *(..))")
    public void publicMethod()
    {
    }

    private Loggable getLoggable(JoinPoint joinPoint)
    {
        Loggable loggable = null;
        Class<?> clazz = joinPoint.getTarget().getClass();
        try
        {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            loggable = (Loggable) method.getAnnotation(Loggable.class);
        }
        catch (SecurityException e)
        {
            e.printStackTrace();
        }

        if ((loggable == null) && (clazz.isAnnotationPresent(Loggable.class)))
        {
            loggable = (Loggable) joinPoint.getTarget().getClass().getAnnotation(Loggable.class);
        }

        return loggable;
    }

}
