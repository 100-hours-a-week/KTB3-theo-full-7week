package com.example.KTB_5WEEK.user.exception;

import com.example.KTB_5WEEK.app.exception.common.BusinessException;
import com.example.KTB_5WEEK.app.exception.handler.ErrorCode;

public class UserEmailMappingDeleteException extends BusinessException {
    public UserEmailMappingDeleteException() {
        super(ErrorCode.FAIL_USER_EMAIL_MAPPING_DELETE);
    }
}
