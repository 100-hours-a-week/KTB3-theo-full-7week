package com.example.KTB_5WEEK.auth.service;

import com.example.KTB_5WEEK.app.aop.aspect.log.Loggable;
import com.example.KTB_5WEEK.app.response.BaseResponse;
import com.example.KTB_5WEEK.app.response.ResponseMessage;
import com.example.KTB_5WEEK.auth.dto.request.LoginRequestDto;
import com.example.KTB_5WEEK.auth.dto.response.LoginResponseDto;
import com.example.KTB_5WEEK.user.entity.User;
import com.example.KTB_5WEEK.user.exception.UserNotFoundException;
import com.example.KTB_5WEEK.user.repository.user.UserRepository;
import com.example.KTB_5WEEK.user.repository.user.email.EmailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    private final EmailRepository emailRepository;

    public AuthService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Loggable
    public BaseResponse<LoginResponseDto> login(LoginRequestDto req) {
        String email = req.getEmail();
        String password = req.getPassword();
        boolean isLoginSuccess = false;

        User user = emailRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException());

        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            isLoginSuccess = true;
        }
        return new BaseResponse(ResponseMessage.LOGIN_SUCCESS, LoginResponseDto.toDto(user.getId(), isLoginSuccess));
    }

    @Loggable
    public BaseResponse logout() {
        return new BaseResponse(ResponseMessage.LOGOUT_SUCCESS, new User());
    }

}
