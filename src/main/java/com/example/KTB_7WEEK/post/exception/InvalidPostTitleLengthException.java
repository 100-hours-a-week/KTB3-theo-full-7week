package com.example.KTB_7WEEK.post.exception;

import com.example.KTB_7WEEK.app.exception.common.BusinessException;
import com.example.KTB_7WEEK.app.exception.handler.ErrorCode;

public class InvalidPostTitleLengthException extends BusinessException {
    public InvalidPostTitleLengthException() {
        super(ErrorCode.POST_TITLE_LENGTH_OVER);
    }
}
