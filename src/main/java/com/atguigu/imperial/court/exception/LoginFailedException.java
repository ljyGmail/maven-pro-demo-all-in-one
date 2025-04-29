package com.atguigu.imperial.court.exception;

/**
 * ClassName: LoginFailedException
 * Package: com.atguigu.imperial.court.exception
 * Description:
 *
 * @Author ljy
 * @Create 2025-04-29 오전 10:12
 * @Version 1.0
 */
public class LoginFailedException extends RuntimeException {

    public LoginFailedException() {
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }

    public LoginFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
