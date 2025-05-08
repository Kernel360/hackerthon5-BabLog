package kr.bablog.bablogbe.post.controller;

import kr.bablog.bablogbe.common.api.response.ApiResponse;
import kr.bablog.bablogbe.post.domain.Post;
import kr.bablog.bablogbe.post.dto.PostResponseDto;
import kr.bablog.bablogbe.post.dto.PostListResponseDto;
import kr.bablog.bablogbe.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
@Slf4j
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ApiResponse<PostListResponseDto> getPostList(
            @RequestParam(value = "offset", defaultValue = "0") int offset
        , @RequestParam(value = "limit", defaultValue = "9") int limit) {

        Page<Post> postPage = this.postService.getPostList(offset, limit);

        //todo: builder패턴으로
        List<PostResponseDto> postListDto = postPage.getContent().stream()
                .map(post -> new PostResponseDto(post.getId()
                        , post.getTitle()
                        , post.getAddress()
                        , post.getImgUrl()
                        , post.getCreatedAt()))
                .collect(Collectors.toList());

        PostListResponseDto postListResponseDto = new PostListResponseDto(postListDto
                , postPage.getNumber()
                , (int)postPage.getTotalElements()
                , postPage.getTotalPages()
                , postPage.getSize()
                , postPage.hasNext()
                , postPage.hasPrevious());

        return ApiResponse.success(postListResponseDto);
    }

    @GetMapping("/post/{postId}")
    public ApiResponse<PostResponseDto> getPostDetail(@PathVariable long postId) {
        Post post = postService.getPostById(postId);

        PostResponseDto postResponseDto = new PostResponseDto(
                post.getId()
                , post.getTitle()
                , post.getAddress()
                , post.getImgUrl()
                , post.getCreatedAt());

        return ApiResponse.success(postResponseDto);
    }


}
