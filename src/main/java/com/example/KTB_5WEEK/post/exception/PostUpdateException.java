package com.example.KTB_5WEEK.post.exception;

import com.example.KTB_5WEEK.app.exception.common.BusinessException;
import com.example.KTB_5WEEK.app.exception.handler.ErrorCode;

public class PostUpdateException extends BusinessException {

    public PostUpdateException() {
        super(ErrorCode.POST_UPDATE_ERROR);
    }

}
