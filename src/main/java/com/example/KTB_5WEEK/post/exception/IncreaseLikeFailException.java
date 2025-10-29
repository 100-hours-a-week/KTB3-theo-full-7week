package com.example.KTB_5WEEK.post.exception;

import com.example.KTB_5WEEK.app.exception.common.BusinessException;
import com.example.KTB_5WEEK.app.exception.handler.ErrorCode;

public class IncreaseLikeFailException extends BusinessException {
    public IncreaseLikeFailException() {
        super(ErrorCode.INCREASE_LIKE_FAIL);
    }
}
