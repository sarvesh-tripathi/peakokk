package com.peakokk.service.logging;

import com.peakokk.common.logging.LogLevel;

public interface ILoggingService
{

    /**
     * Log a statement
     * 
     * @param level the log level of the statement
     * @param clazz the class where the log statement was recorded
     * @param methodName the name of the method where the log statement was
     *            recorded
     * @param format the format of the log statement
     * @param returnValue any return value that should be logged
     */
    void log(LogLevel level, Class<?> clazz, String methodName, String format, Object returnValue);

    /**
     * Log a statement
     * 
     * @param level the log level of the statement
     * @param clazz the class where the log statement was recorded
     * @param methodName the name of the method where the log statement was
     *            recorded
     * @param format the format of the log statement
     * @param throwable any throwable that was thrown
     */
    void log(LogLevel level, Class<?> clazz, String methodName, String format, Throwable throwable);

    /**
     * Log a statement
     * 
     * @param level the log level of the statement
     * @param clazz the class where the log statement was recorded
     * @param methodName the name of the method where the log statement was
     *            recorded
     * @param format the format of the log statement
     * @param parameterNames any names of the parameters of the method where the
     *            log statement was recorded
     * @param parameters any parameters of the method where the log statement
     *            was recorded
     * @param throwable any throwable that was thrown
     * @param returnValue any return value that should be logged
     */
    void log(LogLevel level, Class<?> clazz, String methodName, String format, String[] parameterNames,
            Object[] parameters,
            Throwable throwable, Object returnValue);

    /**
     * Log a statement
     * 
     * @param level the log level of the statement
     * @param clazz the class where the log statement was recorded
     * @param methodName the name of the method where the log statement was
     *            recorded
     * @param format the format of the log statement
     * @param parameterNames any names of the parameters of the method where the
     *            log statement was recorded
     * @param parameters any parameters of the method where the log statement
     *            was recorded
     */
    void log(LogLevel level, Class<?> clazz, String methodName, String format, String[] parameterNames,
            Object[] parameters);
}
