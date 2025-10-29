package com.example.KTB_7WEEK.user.exception;

import com.example.KTB_7WEEK.app.exception.common.BusinessException;
import com.example.KTB_7WEEK.app.exception.handler.ErrorCode;

public class InvalidEmailException extends BusinessException {

    public InvalidEmailException() {
        super(ErrorCode.INVALID_EMAIL);
    }

}
