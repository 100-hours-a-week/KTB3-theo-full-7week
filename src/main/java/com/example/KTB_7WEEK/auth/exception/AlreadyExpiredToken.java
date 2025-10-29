package com.example.KTB_7WEEK.auth.exception;


import com.example.KTB_7WEEK.app.exception.common.BusinessException;
import com.example.KTB_7WEEK.app.exception.handler.ErrorCode;

public class AlreadyExpiredToken extends BusinessException {
    private ErrorCode errorCode;

    public AlreadyExpiredToken() {
        super(ErrorCode.ALREADY_BLACKLIST_TOKEN);
    }
}
