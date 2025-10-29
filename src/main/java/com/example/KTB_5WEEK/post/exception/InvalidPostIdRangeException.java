package com.example.KTB_5WEEK.post.exception;

import com.example.KTB_5WEEK.app.exception.common.BusinessException;
import com.example.KTB_5WEEK.app.exception.handler.ErrorCode;


public class InvalidPostIdRangeException extends BusinessException {
    public InvalidPostIdRangeException() {
        super(ErrorCode.INVALID_POST_ID);
    }
}
