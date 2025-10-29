package com.example.KTB_5WEEK.user.exception;

import com.example.KTB_5WEEK.app.exception.common.BusinessException;
import com.example.KTB_5WEEK.app.exception.handler.ErrorCode;

public class NicknameAlreadyRegisteredException extends BusinessException {
    public NicknameAlreadyRegisteredException() {
        super(ErrorCode.NICKNAME_ALREADY_REGISTERED);
    }

}
