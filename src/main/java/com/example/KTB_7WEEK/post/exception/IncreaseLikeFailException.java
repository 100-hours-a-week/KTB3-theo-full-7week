package com.example.KTB_7WEEK.post.exception;

import com.example.KTB_7WEEK.app.exception.common.BusinessException;
import com.example.KTB_7WEEK.app.exception.handler.ErrorCode;

public class IncreaseLikeFailException extends BusinessException {
    public IncreaseLikeFailException() {
        super(ErrorCode.INCREASE_LIKE_FAIL);
    }
}
