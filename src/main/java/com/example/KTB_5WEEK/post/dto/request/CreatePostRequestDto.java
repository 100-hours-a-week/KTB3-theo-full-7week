package com.example.KTB_5WEEK.post.dto.request;

import com.example.KTB_5WEEK.post.entity.PostCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CreatePostRequestDto {
    @NotBlank(message = "작성자 PK는 필수 입력입니다.")
    @Positive(message = "작성자 PK는 양수입니다.")
    @Schema(description = "게시글 작성 유저 PK", example = "1")
    private long authorId;

    @NotBlank(message = "게시글 제목은 필수 입력입니다.")
    @Size(min = 1, max = 26, message = "게시글 제목은 26자 이내입니다.")
    @Schema(description = "게시글 제목", example = "제목")
    private String title;

    @NotBlank(message = "게시글 본문은 필수 입력입니다.")
    @Schema(description = "게시글 본문", example = "게시글 본문 내용")
    private String article;

    @Schema(description = "게시글 본문 내 삽입할 이미지 URL", example = "https://www.test.com")
    private String articleImage;

    @Schema(description = "게시글의 카테고리(소통방, 고민상담, 정보공유)", example = "COMMUNITY, COUNSELING, INFO_SHARE")
    private PostCategory category;

    public CreatePostRequestDto() {};

    public long getAuthorId() {
        return authorId;
    }

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

    @Override
    public String toString() {
        return "authorId : " + authorId
                + " / title : " + title
                + " / article : " + article
                + " / articleImage : " + articleImage
                + " / category : " + category;
    }
}
