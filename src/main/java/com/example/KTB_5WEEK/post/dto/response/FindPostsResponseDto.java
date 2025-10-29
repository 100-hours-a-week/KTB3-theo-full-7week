package com.example.KTB_5WEEK.post.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class FindPostsResponseDto {
    private int totalPages;
    private int totalCount;
    private int postPerPage;
    private int currentPage;
    private boolean hasNext;
    private List<FindPostResponseDto> posts;

    public FindPostsResponseDto() {
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getPostPerPage() {
        return postPerPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public List<FindPostResponseDto> getPosts() {
        return posts;
    }

    public static FindPostsResponseDto toDto(int totalPages, int totalCount, int postPerPage,
                                             int currentPage, boolean hasNext,
                                             List<FindPostResponseDto> posts) {
        FindPostsResponseDto dto = new FindPostsResponseDto();
        dto.totalPages = totalPages;
        dto.totalCount = totalCount;
        dto.postPerPage = postPerPage;
        dto.currentPage = currentPage;
        dto.hasNext = hasNext;
        dto.posts = posts;

        return dto;
    }
}
