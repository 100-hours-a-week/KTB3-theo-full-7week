package com.example.KTB_5WEEK.post.exception.comment;

import com.example.KTB_5WEEK.app.exception.common.BusinessException;
import com.example.KTB_5WEEK.app.exception.handler.ErrorCode;

public class CommentDeleteException extends BusinessException {

    public CommentDeleteException() {
        super(ErrorCode.COMMENT_DELETE_ERROR);
    }

}
