package com.example.KTB_7WEEK.user.exception;

import com.example.KTB_7WEEK.app.exception.common.BusinessException;
import com.example.KTB_7WEEK.app.exception.handler.ErrorCode;

public class UserCreateException extends BusinessException {
    public UserCreateException() {
        super(ErrorCode.USER_CREATE_ERROR);
    }
}
