package com.peakokk.service.aop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public abstract class BaseAspect
{

    protected Object getParameter(JoinPoint joinPoint, String regex) throws InstantiationException,
            IllegalAccessException
    {
        int argumentIndex = getParameterIndex(joinPoint, regex);
        if (argumentIndex != -1)
        {
            return joinPoint.getArgs()[argumentIndex];
        }
        return null;
    }

    protected int getParameterIndex(JoinPoint joinPoint, String regex) throws InstantiationException,
            IllegalAccessException
    {
        if (joinPoint.getSignature() instanceof MethodSignature)
        {
            List<String> argumentNames = getParameterNames(joinPoint);
            for (int i = 0; i < argumentNames.size(); ++i)
            {
                if ((argumentNames.get(i)).toLowerCase().matches(regex.toLowerCase()))
                {
                    return i;
                }
            }
        }
        return -1;
    }

    protected List<String> getParameterNames(JoinPoint joinPoint)
    {
        List<String> parameterNames = new ArrayList<String>();
        String[] argumentNamesArray = getParameterNamesArray(joinPoint);
        if (argumentNamesArray != null)
            parameterNames.addAll(Arrays.asList(argumentNamesArray));
        return parameterNames;
    }

    protected String[] getParameterNamesArray(JoinPoint joinPoint)
    {
        if (!(joinPoint.getSignature() instanceof MethodSignature))
        {
            return null;
        }

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNamesArray = methodSignature.getParameterNames();
        return parameterNamesArray;
    }

    protected Class<?>[] getParameterClasses(JoinPoint joinPoint)
    {
        Object[] args = joinPoint.getArgs();
        List<Class<?>> classes = new ArrayList<Class<?>>();
        if (args == null)
        {
            return (Class[]) classes.toArray(new Class[0]);
        }

        for (Object object : args)
        {
            if (object == null)
            {
                continue;
            }
            classes.add(object.getClass());
        }
        return (Class[]) classes.toArray(new Class[0]);
    }
}
