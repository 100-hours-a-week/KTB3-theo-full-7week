package com.example.KTB_5WEEK.user.exception;

import com.example.KTB_5WEEK.app.exception.common.BusinessException;
import com.example.KTB_5WEEK.app.exception.handler.ErrorCode;

public class UserUpdateException extends BusinessException {

    public UserUpdateException() {
        super(ErrorCode.USER_UPDATE_ERROR);
    }
}
