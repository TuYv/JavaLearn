package com.rick.springcloud.stream;

/**
 * @author Rick.Tu
 * @program JavaLearn
 * @description
 * @create 2023-06-25 15:12
 **/
public class StopException extends RuntimeException {
    public static final StopException INSTANCE = new StopException();

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
