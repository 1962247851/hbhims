package com.example.hbhims.exception;

import org.springframework.security.core.AuthenticationException;

public class CodeWrongException extends AuthenticationException {

    public CodeWrongException(String msg, Throwable t) {
        super(msg, t);
    }

    public CodeWrongException(String msg) {
        super(msg);
    }
}