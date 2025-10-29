package com.example.KTB_5WEEK.user.exception;

import com.example.KTB_5WEEK.app.exception.common.BusinessException;
import com.example.KTB_5WEEK.app.exception.handler.ErrorCode;

public class InvalidUserIdRangeException extends BusinessException {
    public InvalidUserIdRangeException() {
        super(ErrorCode.INVALID_USER_ID);
    }
}
