package com.example.KTB_7WEEK.post.service;

import com.example.KTB_7WEEK.app.aop.aspect.log.Loggable;
import com.example.KTB_7WEEK.post.dto.request.UpdateMyPostRequestDto;
import com.example.KTB_7WEEK.post.dto.request.comment.CreateCommentRequestDto;
import com.example.KTB_7WEEK.post.dto.request.comment.UpdateCommentRequestDto;
import com.example.KTB_7WEEK.app.response.BaseResponse;
import com.example.KTB_7WEEK.app.response.ResponseMessage;
import com.example.KTB_7WEEK.post.dto.response.*;
import com.example.KTB_7WEEK.post.dto.response.comment.CreateCommentResponseDto;
import com.example.KTB_7WEEK.post.dto.response.comment.FindCommentResponseDto;
import com.example.KTB_7WEEK.post.dto.response.comment.FindCommentsResponseDto;
import com.example.KTB_7WEEK.post.dto.response.comment.UpdateCommentResponseDto;
import com.example.KTB_7WEEK.post.entity.Comment;
import com.example.KTB_7WEEK.post.exception.*;
import com.example.KTB_7WEEK.post.exception.comment.CommentDeleteException;
import com.example.KTB_7WEEK.post.exception.comment.CommentNotFoundException;
import com.example.KTB_7WEEK.post.exception.comment.CommentUpdateException;
import com.example.KTB_7WEEK.post.repository.PostRepository;
import com.example.KTB_7WEEK.post.dto.request.CreatePostRequestDto;
import com.example.KTB_7WEEK.post.exception.comment.CommentCreateException;
import com.example.KTB_7WEEK.post.entity.Post;
import com.example.KTB_7WEEK.app.util.paginationPolicy.CommentPaginationPolicy;
import com.example.KTB_7WEEK.app.util.paginationPolicy.PostPaginationPolicy;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicPostService {
    private final PostRepository postRepository;

    public PublicPostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * Post Service Business Logic & Convert <BaseResponse> Method
     **/
    // 게시글 생성
    @Loggable
    public BaseResponse<CreateCommentResponseDto> createPost(CreatePostRequestDto req) {
        Post toSave = new Post.Builder()
                .authorId(req.getAuthorId())
                .title(req.getTitle())
                .article(req.getArticle())
                .articleImage(req.getArticleImage())
                .category(req.getCategory())
                .build();
        Post saved = postRepository.createPost(toSave).orElseThrow(() -> new PostCreateException());
        return new BaseResponse(ResponseMessage.POST_REGISTER_SUCCESS, CreatePostResponseDto.toDto(saved.getId()));
    }

    // 게시글 목록 조회
    @Loggable
    public BaseResponse<FindPostsResponseDto> findPosts(int page) {
        List<Post> posts = postRepository.findAllPost();
        int totalPages = posts.size() / PostPaginationPolicy.DEFAULT.limit();
        totalPages = posts.size() % PostPaginationPolicy.DEFAULT.limit() > 0 ?
                totalPages + 1 : totalPages;

        int totalCount = posts.size();
        int postPerPage = PostPaginationPolicy.DEFAULT.limit();
        int currentPage = page;
        boolean hasNext = totalPages > currentPage;

        List<FindPostResponseDto> postDtoList = posts.stream()
                .filter(PostPaginationPolicy.DEFAULT.predicate())
                .sorted(PostPaginationPolicy.DEFAULT.comparator())
                .skip(PostPaginationPolicy.DEFAULT.offset(page))
                .limit(PostPaginationPolicy.DEFAULT.limit())
                .map((post) -> FindPostResponseDto.toDto(post))
                .collect(Collectors.toCollection(ArrayList::new));

        return new BaseResponse(ResponseMessage.POSTS_LOAD_SUCCESS,
                FindPostsResponseDto.toDto(totalPages, totalCount, postPerPage, currentPage, hasNext, postDtoList));
    }

    // 게시글 조회
    @Loggable
    public BaseResponse<FindPostResponseDto> findPostById(long id) {
        Post post = postRepository.findPostById(id).orElseThrow(() -> new PostNotFoundException());
        return new BaseResponse(ResponseMessage.POST_INFO_LOAD_SUCCESS, FindPostResponseDto.toDto(post));
    }

    // My Post 수정
    @Loggable
    public BaseResponse<UpdateMyPostResponseDto> updateMyPost(long myPostId, UpdateMyPostRequestDto req) {

        Post originPost = postRepository.findPostById(myPostId).orElseThrow(() -> new PostNotFoundException());

        originPost.updateTitle(req.getTitle());
        originPost.updateArticle(req.getArticle());
        originPost.updateArticleImage(req.getArticleImage());
        originPost.updateCategory(req.getCategory());

        Post updatedPost = postRepository.updatePostById(myPostId, originPost).orElseThrow(() -> new PostUpdateException());

        return new BaseResponse(ResponseMessage.MY_POST_UPDATE_SUCCESS,
                UpdateMyPostResponseDto.toDto(updatedPost));
    }

    // 게시글 삭제 By Id
    @Loggable
    public BaseResponse deletePostById(long id) {
        postRepository.findPostById(id).orElseThrow(() -> new PostNotFoundException());

        postRepository.deletePostById(id).orElseThrow(() -> new PostDeleteException());

        return new BaseResponse(ResponseMessage.POST_DELETE_SUCCESS, new Post());
    }

    // 게시글 조회 수 증가
    @Loggable
    public BaseResponse<IncreaseHitResponseDto> increaseHit(long id) {
        Post toUpdate = postRepository.findPostById(id).orElseThrow(() -> new PostNotFoundException());
        toUpdate.increaseHit();

        Post updated = postRepository.updatePostById(id, toUpdate).orElseThrow(() -> new IncreaseHitFailException());
        return new BaseResponse(ResponseMessage.INCREASE_HIT_SUCCESS,
                IncreaseHitResponseDto.toDto(updated));
    }

    // 게시글 좋아요 수 증가
    @Loggable
    public BaseResponse<IncreaseLikeResponseDto> increaseLike(long id) {
        Post toUpdate = postRepository.findPostById(id).orElseThrow(() -> new PostNotFoundException());
        toUpdate.increaseLike();

        Post updated = postRepository.updatePostById(id, toUpdate).orElseThrow(() -> new IncreaseLikeFailException());
        return new BaseResponse(ResponseMessage.INCREASE_LIKE_SUCCESS,
                IncreaseLikeResponseDto.toDto(updated));
    }

    // 댓글 등록
    @Loggable
    public BaseResponse<CreateCommentResponseDto> createComment(long postId, CreateCommentRequestDto req) {
        postRepository.findPostById(postId).orElseThrow(() -> new PostNotFoundException());

        Comment toSave = new Comment.Builder()
                .authorId(req.getUserId())
                .postId(postId)
                .content(req.getContent())
                .build();
        Comment saved = postRepository.createComment(toSave).orElseThrow(() -> new CommentCreateException());

        return new BaseResponse(ResponseMessage.COMMENT_CREATE_SUCCESS,
                CreateCommentResponseDto.toDto(saved));
    }

    // 댓글 조회 By Post Id
    @Loggable
    public BaseResponse<FindCommentsResponseDto> findCommentByPostId(long postId, int page) {
        postRepository.findPostById(postId).orElseThrow(() -> new PostNotFoundException());

        List<Comment> comments = postRepository.findCommentsByPostId(postId);
        int totalPages = comments.size() / CommentPaginationPolicy.DEFAULT.limit();
        totalPages = (comments.size() % CommentPaginationPolicy.DEFAULT.limit()) > 0
                ? totalPages + 1 : totalPages;
        int totalCount = comments.size();
        int commentPerPage = CommentPaginationPolicy.DEFAULT.limit();
        int currentPage = page;
        boolean hasNext = (totalPages > currentPage);

        List<FindCommentResponseDto> commentDtoList = comments.stream()
                .filter(CommentPaginationPolicy.DEFAULT.predicate())
                .sorted(CommentPaginationPolicy.DEFAULT.comparator())
                .skip(CommentPaginationPolicy.DEFAULT.offset(page))
                .limit(CommentPaginationPolicy.DEFAULT.limit())
                .map((c) -> FindCommentResponseDto.toDto(c))
                .collect(Collectors.toCollection(ArrayList::new));

        return new BaseResponse(ResponseMessage.COMMENTS_LOAD_SUCCESS,
                FindCommentsResponseDto.toDto(postId, totalPages, totalCount, commentPerPage, currentPage, hasNext,
                        commentDtoList));
    }

    // 댓글 조회 By Comment Id
    @Loggable
    public BaseResponse<FindCommentResponseDto> findCommentByCommentId(long id) {
        Comment comment = postRepository.findCommentById(id).orElseThrow(() -> new CommentNotFoundException());

        return new BaseResponse(ResponseMessage.COMMENT_LOAD_SUCCESS, FindCommentResponseDto.toDto(comment));
    }

    // 댓글 수정 By Comment Id
    @Loggable
    public BaseResponse<UpdateCommentResponseDto> updateCommentById(long postId, long commentId, UpdateCommentRequestDto req) {
        postRepository.findPostById(postId).orElseThrow(() -> new PostNotFoundException());

        Comment originComment = postRepository.findCommentById(commentId).orElseThrow(() -> new CommentNotFoundException());

        originComment.updateContent(req.getContent());

        Comment updatedComment = postRepository.updateCommentById(commentId, originComment).orElseThrow(() -> new CommentUpdateException());

        return new BaseResponse(ResponseMessage.COMMENT_UPDATE_SUCCESS,
                UpdateCommentResponseDto.toDto(updatedComment));
    }

    // 댓글 삭제
    @Loggable
    public BaseResponse deleteCommentById(long postId, long commentId) {
        postRepository.findPostById(postId).orElseThrow(() -> new PostNotFoundException());

        postRepository.deleteCommentById(commentId).orElseThrow(() -> new CommentDeleteException());

        return new BaseResponse(ResponseMessage.COMMENT_DELETE_SUCCESS, new Comment());
    }

}
