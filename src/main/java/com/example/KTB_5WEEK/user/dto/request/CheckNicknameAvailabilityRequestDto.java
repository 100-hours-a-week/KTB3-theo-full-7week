package com.example.KTB_5WEEK.user.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CheckNicknameAvailabilityRequestDto {
    @NotBlank(message = "닉네임은 필수 입력입니다.")
    @Size(min = 1, max = 10, message = "닉네임은 1자 이상 10자 이내입니다.")
    @Schema(description = "중복 검사 대상 닉네임", example = "nickname")
    private String nickname;

    public CheckNicknameAvailabilityRequestDto() {}

    public String getNickname() {
        return nickname;
    }

}
