package com.mcsoft.exception;

/**
 * 数据处理器异常
 * Created by Mc on 2017/12/25.
 */
public class HandleException extends Exception {
    public HandleException(String message) {
        super(message);
    }

    public HandleException(String message, Throwable cause) {
        super(message, cause);
    }

    public HandleException(Throwable cause) {
        super(cause);
    }
}
