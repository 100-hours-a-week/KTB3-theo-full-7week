package com.example.KTB_5WEEK.user.service;


import com.example.KTB_5WEEK.app.aop.aspect.log.Loggable;
import com.example.KTB_5WEEK.app.response.BaseResponse;
import com.example.KTB_5WEEK.app.response.ResponseMessage;
import com.example.KTB_5WEEK.user.entity.User;
import com.example.KTB_5WEEK.user.repository.user.UserRepository;
import com.example.KTB_5WEEK.user.repository.user.email.EmailRepository;
import com.example.KTB_5WEEK.user.dto.request.*;
import com.example.KTB_5WEEK.user.dto.response.*;
import com.example.KTB_5WEEK.user.exception.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicUserService {
    private final UserRepository userRepository;
    private final EmailRepository emailRepository;

    // 생성자 DI
    public PublicUserService(UserRepository publicUserRepository, EmailRepository emailRepository) {
        this.userRepository = publicUserRepository;
        this.emailRepository = emailRepository;
    }

    /**
     * User Service Business Logic & Convert <BaseResponse> Method
     **/
    // 회원가입
    @Loggable
    public BaseResponse<RegistUserResponseDto> register(RegistUserRequestDto req) {
        String email = req.getEmail();
        String nickname = req.getNickname();

        if (!checkEmailAvailability(email)) throw new EmailAlreadyRegisteredException();
        if (!checkNicknameAvailability(nickname)) throw new NicknameAlreadyRegisteredException();


        User toSave = new User.Builder()
                .email(email)
                .password(req.getPassword())
                .nickname(req.getNickname())
                .profileImage(req.getProfileImage())
                .build();

        User saved = userRepository.regist(toSave).orElseThrow(() -> new UserCreateException());
        emailRepository.mapUserByEmail(saved).orElseThrow(() -> new FailUserEmailMappingException());
        return new BaseResponse(ResponseMessage.USER_REGISTER_SUCCESS, RegistUserResponseDto.toDto(saved));

    }

    // 회원정보 조회
    @Loggable
    public BaseResponse<FindUserResponseDto> findById(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
        return new BaseResponse(ResponseMessage.USERINFO_LOAD_SUCCESS, FindUserResponseDto.toDto(user));
    }

    // 회원정보 삭제
    @Loggable
    public BaseResponse deleteById(long id) {
        User toDelete = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        User deleted = userRepository.deleteById(id).orElseThrow(() -> new UserDeleteException());
        emailRepository.deleteUserByEmail(deleted.getEmail()).orElseThrow(() -> new UserEmailMappingDeleteException());

        return new BaseResponse(ResponseMessage.USER_DELETE_SUCCESS, new User());
    }

    // 닉네임 중복 검사
    @Loggable
    public BaseResponse<CheckNicknameAvailabilityResponseDto> doubleCheckNickname(CheckNicknameAvailabilityRequestDto req) {
        String nickname = req.getNickname();
        if (!checkNicknameAvailability(nickname)) {
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
        if (!checkEmailAvailability(email)) {
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

        if (!checkNicknameAvailability(nickname)) throw new NicknameAlreadyRegisteredException();

        User toUpdate = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
        toUpdate.updateNickname(nickname);

        User updated = userRepository.updateById(userId, toUpdate).orElseThrow(() -> new NicknameUpdateException());

        return new BaseResponse(ResponseMessage.NICKNAME_EDIT_SUCCESS, UpdateNicknameResponseDto.toDto(updated));
    }

    // 비밀번호 변경
    @Loggable
    public BaseResponse changePassword(long userId, PasswordChangeRequestDto req) {
        String password = req.getPassword();

        User toUpdate = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
        toUpdate.updatePassword(password);

        User updated = userRepository.updateById(userId, toUpdate).orElseThrow(() -> new UserUpdateException());

        return new BaseResponse(ResponseMessage.PASSWORD_CHANGE_SUCCESS, UpdatePasswordResponseDto.toDto(updated.getId()));
    }

    /**
     * User Service Common Function
     **/
    // 닉네임 중복 검사
    private boolean checkNicknameAvailability(String nickname) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getNickname().equals(nickname)) {
                return false;
            }
        }
        return true;
    }

    // 이메일 중복 검사
    private boolean checkEmailAvailability(String email) {
        return !emailRepository.findByEmail(email).isPresent();
    }
}
