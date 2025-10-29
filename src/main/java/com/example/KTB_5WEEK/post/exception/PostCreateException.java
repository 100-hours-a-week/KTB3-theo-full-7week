package com.example.KTB_5WEEK.post.exception;

import com.example.KTB_5WEEK.app.exception.common.BusinessException;
import com.example.KTB_5WEEK.app.exception.handler.ErrorCode;

public class PostCreateException extends BusinessException {

    public PostCreateException() {
        super(ErrorCode.POST_CREATE_ERROR);
    }
}
