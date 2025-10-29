package com.example.KTB_7WEEK.post.exception;

import com.example.KTB_7WEEK.app.exception.common.BusinessException;
import com.example.KTB_7WEEK.app.exception.handler.ErrorCode;

public class PostDeleteException extends BusinessException {

    public PostDeleteException() {
        super(ErrorCode.POST_DELETE_ERROR);
    }

}
