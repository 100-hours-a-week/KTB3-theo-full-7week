package com.example.KTB_5WEEK.post.exception.comment;

import com.example.KTB_5WEEK.app.exception.common.BusinessException;
import com.example.KTB_5WEEK.app.exception.handler.ErrorCode;

public class InvalidCommentIdRangeException extends BusinessException {
    public InvalidCommentIdRangeException() {
        super(ErrorCode.INVALID_POST_ID);
    }
}
