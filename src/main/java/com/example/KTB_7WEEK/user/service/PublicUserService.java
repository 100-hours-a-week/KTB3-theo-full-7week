package com.example.KTB_7WEEK.user.service;


import com.example.KTB_7WEEK.app.aop.aspect.log.Loggable;
import com.example.KTB_7WEEK.app.response.BaseResponse;
import com.example.KTB_7WEEK.app.response.ResponseMessage;
import com.example.KTB_7WEEK.user.entity.User;
import com.example.KTB_7WEEK.user.repository.user.PublicUserRepository;
import com.example.KTB_7WEEK.user.dto.request.*;
import com.example.KTB_7WEEK.user.dto.response.*;
import com.example.KTB_7WEEK.user.exception.*;
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
     **/
    // 회원가입
    @Loggable
    public BaseResponse<RegistUserResponseDto> register(RegistUserRequestDto req) {
        try {
            String email = req.getEmail();
            String nickname = req.getNickname();

            User toSave = new User.Builder()
                    .email(email)
                    .password(req.getPassword())
                    .nickname(req.getNickname())
                    .profileImage(req.getProfileImage())
                    .build();

            User saved = publicUserRepository.save(toSave);
            return new BaseResponse(ResponseMessage.USER_REGISTER_SUCCESS, RegistUserResponseDto.toDto(saved));
        } catch (Exception e) {
            System.out.println(e);

        }
//        if (!checkEmailAvailability(email)) throw new EmailAlreadyRegisteredException();
//        if (!checkNicknameAvailability(nickname)) throw new NicknameAlreadyRegisteredException();
        throw new UserCreateException();
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

    /**
     * User Service Common Function
     **/
    // 닉네임 중복 검사
    private boolean checkNicknameAvailability(String nickname) {
        return !publicUserRepository.findByNickname(nickname).isPresent();
    }

    // 이메일 중복 검사
    private boolean checkEmailAvailability(String email) {
        return !publicUserRepository.findByEmail(email).isPresent();
    }
}
