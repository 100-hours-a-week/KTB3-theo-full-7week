package com.example.KTB_5WEEK.user.exception;

import com.example.KTB_5WEEK.app.exception.common.BusinessException;
import com.example.KTB_5WEEK.app.exception.handler.ErrorCode;

public class WhiteSpaceNotAllowedException extends BusinessException {
    public WhiteSpaceNotAllowedException() {
        super(ErrorCode.WHITESPACE_NOT_ALLOWED);
    }
}
