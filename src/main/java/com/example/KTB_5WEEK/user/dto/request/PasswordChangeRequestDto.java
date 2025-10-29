package com.example.KTB_5WEEK.user.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PasswordChangeRequestDto {
    @NotBlank(message = "비밀번호는 필수 입력입니다.")
    @Size(min = 1, max = 10)
    @Schema(description = "변경 요청 비밀번호", example = "1q2w3e4r!Q!Q")
    private String password;

    public PasswordChangeRequestDto() {}

    public String getPassword() {
        return password;
    }
}
