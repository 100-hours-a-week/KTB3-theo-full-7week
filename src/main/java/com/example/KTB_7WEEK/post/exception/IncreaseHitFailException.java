package com.example.KTB_7WEEK.post.exception;

import com.example.KTB_7WEEK.app.exception.common.BusinessException;
import com.example.KTB_7WEEK.app.exception.handler.ErrorCode;

public class IncreaseHitFailException extends BusinessException {
    public IncreaseHitFailException() {
        super(ErrorCode.INCREASE_HIT_FAIL);
    }
}
