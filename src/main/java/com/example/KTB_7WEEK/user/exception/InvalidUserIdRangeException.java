package com.example.KTB_7WEEK.user.exception;

import com.example.KTB_7WEEK.app.exception.common.BusinessException;
import com.example.KTB_7WEEK.app.exception.handler.ErrorCode;

public class InvalidUserIdRangeException extends BusinessException {
    public InvalidUserIdRangeException() {
        super(ErrorCode.INVALID_USER_ID);
    }
}
