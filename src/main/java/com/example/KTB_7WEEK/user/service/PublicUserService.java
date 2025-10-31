package com.example.KTB_7WEEK.user.service;


import com.example.KTB_7WEEK.app.aop.aspect.log.Loggable;
import com.example.KTB_7WEEK.app.response.BaseResponse;
import com.example.KTB_7WEEK.app.response.ResponseMessage;
import com.example.KTB_7WEEK.user.entity.User;
import com.example.KTB_7WEEK.user.repository.user.PublicUserRepository;
import com.example.KTB_7WEEK.user.dto.request.*;
import com.example.KTB_7WEEK.user.dto.response.*;
import com.example.KTB_7WEEK.user.exception.*;
import com.fasterxml.jackson.databind.util.ExceptionUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PublicUserService {
    private final PublicUserRepository publicUserRepository;

    // 생성자 DI
    public PublicUserService(PublicUserRepository publicUserRepository) {
        this.publicUserRepository = publicUserRepository;
    }

    /**
     * User Service Business Logic & Convert <BaseResponse> Method
     * <p>
     * TODO
     * 1. register 메소드 이메일, 닉네임 중복체크 하는 동안 다른 트랜잭션이 값 바꾸면 중간에 검사 실패할 수 있다.
     * 2. 비밀번호 암호화 BCrypt
     **/
    // 회원가입
    @Loggable
    public BaseResponse<RegistUserResponseDto> register(RegistUserRequestDto req) {
        String email = req.getEmail();
        String nickname = req.getNickname();

        if (publicUserRepository.existsByEmail(email)) throw new EmailAlreadyRegisteredException();
        if (publicUserRepository.existsByNickname(nickname)) throw new NicknameAlreadyRegisteredException();

        User toSave = new User.Builder()
                .email(email)
                .password(req.getPassword())
                .nickname(req.getNickname())
                .profileImage(req.getProfileImage())
                .build();

        User saved = publicUserRepository.save(toSave);
        return new BaseResponse(ResponseMessage.USER_REGISTER_SUCCESS, RegistUserResponseDto.toDto(saved));

    }

    // 회원정보 조회
    @Loggable
    public BaseResponse<FindUserResponseDto> findById(long userId) {
        User user = publicUserRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
        return new BaseResponse(ResponseMessage.USERINFO_LOAD_SUCCESS, FindUserResponseDto.toDto(user));
    }

    // 회원정보 삭제
    @Loggable
    public BaseResponse deleteById(long id) {
        User toDelete = publicUserRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        publicUserRepository.deleteById(id);

        return new BaseResponse(ResponseMessage.USER_DELETE_SUCCESS, new User());
    }

    // 닉네임 중복 검사
    @Loggable
    public BaseResponse<CheckNicknameAvailabilityResponseDto> doubleCheckNickname(CheckNicknameAvailabilityRequestDto req) {
        String nickname = req.getNickname();
        if (!publicUserRepository.existsByNickname(nickname)) {
            return new BaseResponse(ResponseMessage.NICKNAME_IS_NOT_AVAILABLE,
                    CheckNicknameAvailabilityResponseDto.toDto(nickname, false));
        }
        return new BaseResponse(ResponseMessage.NICKNAME_IS_AVAILABLE,
                CheckNicknameAvailabilityResponseDto.toDto(nickname, true));
    }

    // 이메일 중복 검사
    @Loggable
    public BaseResponse<CheckEmailAvailabilityResponseDto> doubleCheckEmail(CheckEmailAvailabilityRequestDto req) {
        String email = req.getEmail();
        if (!publicUserRepository.existsByEmail(email)) {
            return new BaseResponse(ResponseMessage.EMAIL_IS_NOT_AVAILABLE,
                    CheckEmailAvailabilityResponseDto.toDto(email, false));
        }
        return new BaseResponse(ResponseMessage.EMAIL_IS_AVAILABLE,
                CheckEmailAvailabilityResponseDto.toDto(email, true));
    }


    // 닉네임 수정
    @Loggable
    public BaseResponse<UpdateNicknameResponseDto> editNickname(long userId, NicknameEditRequestDto req) {
        String nickname = req.getNickname();

        if (publicUserRepository.existsByNickname(nickname)) throw new NicknameAlreadyRegisteredException();

        User toUpdate = publicUserRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
        toUpdate.updateNickname(nickname);
        toUpdate.updateNowTime();

        User updated = publicUserRepository.save(toUpdate);
        return new BaseResponse(ResponseMessage.NICKNAME_EDIT_SUCCESS, UpdateNicknameResponseDto.toDto(updated));
    }

    // 비밀번호 변경
    @Loggable
    public BaseResponse changePassword(long userId, PasswordChangeRequestDto req) {
        String password = req.getPassword();

        User toUpdate = publicUserRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
        toUpdate.updatePassword(password);
        toUpdate.updateNowTime();

        return new BaseResponse(ResponseMessage.PASSWORD_CHANGE_SUCCESS, UpdatePasswordResponseDto.toDto(toUpdate.getId()));
    }

}
