package com.example.KTB_7WEEK.post.exception.comment;

import com.example.KTB_7WEEK.app.exception.common.BusinessException;
import com.example.KTB_7WEEK.app.exception.handler.ErrorCode;

public class CommentUpdateException extends BusinessException {

    public CommentUpdateException() {
        super(ErrorCode.COMMENT_UPDATE_ERROR);
    }

}
