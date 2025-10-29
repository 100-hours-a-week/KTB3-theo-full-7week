package com.example.KTB_5WEEK.post.dto.request;

import com.example.KTB_5WEEK.post.entity.PostCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateMyPostRequestDto {

    @NotBlank(message = "제목은 필수 입력입니다.")
    @Size(min = 1, max = 26, message = "게시글은 1자 이상 26자 이내입니다.")
    // 여기까지
    @Schema(description = "수정 요청할 게시글 제목", example = "수정된 제목")
    private String title;


    @Schema(description = "수정 요청할 게시글 본문", example = "수정된 게시글 본문")
    private String article;
    @Schema(description = "기존 게시글 본문 이미지 교체", example = "https://www.NewImage.com")
    private String articleImage;
    @Schema(description = "수정할 게시글 카테고리(소통방, 고민상담, 정보공유)", example = "COMMUNITY, COUNSELING, INFO_SHARE")
    private PostCategory category;

    public UpdateMyPostRequestDto() {};

    public String getTitle() {
        return title;
    }

    public String getArticle() {
        return article;
    }

    public String getArticleImage() {
        return articleImage;
    }

    public PostCategory getCategory() {
        return category;
    }


}
