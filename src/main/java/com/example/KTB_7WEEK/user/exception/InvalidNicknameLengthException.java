package com.example.KTB_7WEEK.user.exception;

import com.example.KTB_7WEEK.app.exception.common.BusinessException;
import com.example.KTB_7WEEK.app.exception.handler.ErrorCode;

public class InvalidNicknameLengthException extends BusinessException {

    public InvalidNicknameLengthException() {
        super(ErrorCode.INVALID_NICKNAME_LENGTH);
    }

}
