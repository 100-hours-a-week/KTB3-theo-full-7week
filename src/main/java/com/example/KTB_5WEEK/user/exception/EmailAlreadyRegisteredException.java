package com.example.KTB_5WEEK.user.exception;

import com.example.KTB_5WEEK.app.exception.common.BusinessException;
import com.example.KTB_5WEEK.app.exception.handler.ErrorCode;

public class EmailAlreadyRegisteredException extends BusinessException {
    public EmailAlreadyRegisteredException() {
        super(ErrorCode.EMAIL_ALREADY_REGISTERED);
    }

}
