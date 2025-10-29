package com.example.KTB_5WEEK.app.exception.handler;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    // USER
    INVALID_PASSWORD(400, HttpStatus.BAD_REQUEST, "비밀번호 형식 불일치(8자 이상 20자 이하 / 대문자, 소문자, 숫자, 특수문자 각각 1개씩 포함해야 합니다."),
    INVALID_EMAIL(400, HttpStatus.BAD_REQUEST, "이메일 형식 불일치(영 대소문자, 숫자만 가능합니다) ex) test@test.com"),
    INVALID_NICKNAME_LENGTH(400, HttpStatus.BAD_REQUEST, "닉네임은 10글자 이내 입니다."),
    WHITESPACE_NOT_ALLOWED(400, HttpStatus.BAD_REQUEST, "공백, 띄워쓰기를 없애주세요"),
    INVALID_USER_ID(400, HttpStatus.BAD_REQUEST, "UserId은 1이상 입니다."),
    USER_NOT_FOUND(404, HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."),
    EMAIL_ALREADY_REGISTERED(409, HttpStatus.CONFLICT, "이미 등록된 이메일 입니다."),
    NICKNAME_ALREADY_REGISTERED(409, HttpStatus.CONFLICT, "이미 등록된 닉네임 입니다."),
    USER_UPDATE_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "유저 업데이트 실패"),
    USER_CREATE_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "유저 생성 실패"),
    USER_DELETE_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "유저 삭제 실패"),
    NICKNAME_UPDATE_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "유저 닉네임 수정 실패"),
    FAIL_USER_EMAIL_MAPPING(500,HttpStatus.INTERNAL_SERVER_ERROR, "유저&이메일 매핑 실패"),
    FAIL_USER_EMAIL_MAPPING_DELETE(500, HttpStatus.INTERNAL_SERVER_ERROR, "유저&이메일 매핑 정보 삭제 실패"),


    // POST
    INVALID_POST_ID(400, HttpStatus.BAD_REQUEST, "PostId은 1이상 입니다."),
    POST_TITLE_LENGTH_OVER(400, HttpStatus.BAD_REQUEST, "게시글 제목 최대 26자 입니다."),
    POST_NOT_FOUND(404, HttpStatus.NOT_FOUND, "게시글을 찾을 수 없습니다."),
    POST_CREATE_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "게시글 생성 실패"),
    POST_UPDATE_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "게시글 수정 실패"),
    POST_DELETE_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "게시글 삭제 실패"),
    INCREASE_HIT_FAIL(500, HttpStatus.INTERNAL_SERVER_ERROR, "조회수 증가 실패"),
    INCREASE_LIKE_FAIL(500, HttpStatus.INTERNAL_SERVER_ERROR, "좋아요 수 증가 실패"),

    // COMMENT
    NO_COMMENT_NOT_ALLOWED(400, HttpStatus.BAD_REQUEST, "댓글은 1자 이상 입니다."),
    INVALID_COMMENT_ID(400, HttpStatus.BAD_REQUEST, "CommentId은 1이상 입니다."),
    COMMENT_NOT_FOUND(404, HttpStatus.NOT_FOUND, "댓글을 찾을 수 없습니다."),
    COMMENT_CREATE_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "댓글 생성 실패"),
    COMMENT_UPDATE_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "댓글 수정 실패"),
    COMMENT_DELETE_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "댓글 삭제 실패"),

    // Auth
    INVALID_TOKEN(400, HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰입니다."),
    ALREADY_BLACKLIST_TOKEN(401, HttpStatus.UNAUTHORIZED,"이미 무효화된 토큰입니다.(재로그인 필요)"),
    UNAUTHORIZED(401, HttpStatus.UNAUTHORIZED,"로그인 인증이 필요합니다."),
    FAIL_TOKEN_EXPIRE(500, HttpStatus.INTERNAL_SERVER_ERROR, "토큰 무효화 실패");


    private final int code;
    private final HttpStatus status;
    private final String message;

    ErrorCode(int code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
