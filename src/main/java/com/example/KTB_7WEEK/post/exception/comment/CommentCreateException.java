package com.example.KTB_7WEEK.post.exception.comment;

import com.example.KTB_7WEEK.app.exception.common.BusinessException;
import com.example.KTB_7WEEK.app.exception.handler.ErrorCode;

public class CommentCreateException extends BusinessException {

    public CommentCreateException() {
        super(ErrorCode.COMMENT_CREATE_ERROR);
    }

}
