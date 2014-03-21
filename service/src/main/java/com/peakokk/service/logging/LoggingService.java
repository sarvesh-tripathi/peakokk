package com.peakokk.service.logging;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.peakokk.common.logging.LogLevel;

@Component
public class LoggingService implements ILoggingService
{
    private final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    @Override
    public void log(LogLevel level, Class<?> clazz, String methodName, String format, Object returnValue)
    {
        log(level, clazz, methodName, format, null, null, null, returnValue);
    }

    @Override
    public void log(LogLevel level, Class<?> clazz, String methodName, String format, Throwable throwable)
    {
        log(level, clazz, methodName, format, null, null, throwable, null);
    }

    @Override
    public void log(LogLevel level, Class<?> clazz, String methodName, String format, String[] parameterNames,
            Object[] parameters, Throwable throwable, Object returnValue)
    {
        switch (level)
        {
        case TRACE:
            if (logger.isTraceEnabled())
            {
                logger.trace(format, getObjects(clazz, methodName, parameterNames, parameters, throwable, returnValue));
            }
            break;
        case DEBUG:
            if (logger.isDebugEnabled())
            {
                logger.debug(format, getObjects(clazz, methodName, parameterNames, parameters, throwable, returnValue));
            }
            break;
        case ERROR:
            if (logger.isErrorEnabled())
            {
                if (throwable != null)
                {
                    logger.error(format, getObjects(clazz, methodName, parameterNames, parameters, throwable,
                            returnValue), throwable);
                }
                else
                {
                    logger.error(format, getObjects(clazz, methodName, parameterNames, parameters, throwable,
                            returnValue));
                }
            }
            break;
        case INFO:
            if (logger.isInfoEnabled())
            {
                logger.info(format, getObjects(clazz, methodName, parameterNames, parameters, throwable, returnValue));
            }
            break;
        case WARN:
            if (logger.isWarnEnabled())
            {
                logger.warn(format, getObjects(clazz, methodName, parameterNames, parameters, throwable, returnValue));
            }
        }
    }

    @Override
    public void log(LogLevel level, Class<?> clazz, String methodName, String format, String[] parameterNames,
            Object[] parameters)
    {
        log(level, clazz, methodName, format, parameterNames, parameters, null, null);
    }

    private Object[] getObjects(Class<?> clazz, String methodName, String[] parameterNames, Object[] parameters,
            Throwable throwable, Object returnValue)
    {
        List<Object> object = new ArrayList<Object>();
        object.add(clazz.getSimpleName() + "::" + methodName + "()");
        if ((parameterNames != null) && (parameterNames.length > 0))
        {
            object.add(parameterNames);
            object.add(parameters);
        }
        if (throwable != null)
        {
            object.add(throwable.getMessage());
        }
        if (returnValue != null)
        {
            object.add(returnValue);
        }
        return object.toArray(new Object[0]);
    }
}
