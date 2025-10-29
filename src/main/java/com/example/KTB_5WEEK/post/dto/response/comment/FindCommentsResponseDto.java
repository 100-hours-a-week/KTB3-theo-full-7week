package com.example.KTB_5WEEK.post.dto.response.comment;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class FindCommentsResponseDto {
    private long postId;
    private int totalPages;
    private int totalCount;
    private int pageSize;
    private int pageIndex;
    private boolean hasNext;
    private List<FindCommentResponseDto> comments;

    public FindCommentsResponseDto() {
    }

    public long getPostId() {
        return postId;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public List<FindCommentResponseDto> getComments() {
        return comments;
    }

    public static FindCommentsResponseDto toDto(long postId, int totalPages, int totalCount,
                                                int pageSize, int pageIndex, boolean hasNext,
                                                List<FindCommentResponseDto> comments) {
        FindCommentsResponseDto dto = new FindCommentsResponseDto();
        dto.postId = postId;
        dto.totalPages = totalPages;
        dto.totalCount = totalCount;
        dto.pageIndex = pageIndex;
        dto.pageSize = pageSize;
        dto.hasNext = hasNext;
        dto.comments = comments;
        return dto;
    }
}

