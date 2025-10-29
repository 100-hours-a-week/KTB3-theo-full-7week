package com.example.KTB_7WEEK.user.exception;

import com.example.KTB_7WEEK.app.exception.common.BusinessException;
import com.example.KTB_7WEEK.app.exception.handler.ErrorCode;

public class NicknameAlreadyRegisteredException extends BusinessException {
    public NicknameAlreadyRegisteredException() {
        super(ErrorCode.NICKNAME_ALREADY_REGISTERED);
    }

}
