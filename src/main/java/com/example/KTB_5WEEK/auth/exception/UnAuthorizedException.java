package com.example.KTB_5WEEK.auth.exception;

import com.example.KTB_5WEEK.app.exception.common.BusinessException;
import com.example.KTB_5WEEK.app.exception.handler.ErrorCode;

public class UnAuthorizedException extends BusinessException {
    private ErrorCode errorCode;

    public UnAuthorizedException() {
        super(ErrorCode.UNAUTHORIZED);
    }
}
