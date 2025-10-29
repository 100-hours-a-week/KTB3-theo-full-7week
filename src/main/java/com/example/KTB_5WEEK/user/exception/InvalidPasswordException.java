package com.example.KTB_5WEEK.user.exception;

import com.example.KTB_5WEEK.app.exception.common.BusinessException;
import com.example.KTB_5WEEK.app.exception.handler.ErrorCode;

public class InvalidPasswordException extends BusinessException {
    public InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }

}
