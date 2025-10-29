package com.example.KTB_5WEEK.post.exception.comment;

import com.example.KTB_5WEEK.app.exception.common.BusinessException;
import com.example.KTB_5WEEK.app.exception.handler.ErrorCode;

public class InvalidCommentLengthException extends BusinessException {
    public InvalidCommentLengthException() {
        super(ErrorCode.NO_COMMENT_NOT_ALLOWED);
    }
}
