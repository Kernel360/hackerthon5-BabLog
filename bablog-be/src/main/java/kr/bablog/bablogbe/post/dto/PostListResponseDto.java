package kr.bablog.bablogbe.post.dto;

import java.util.List;

public record PostListResponseDto (

        List<PostResponseDto> contents,
        int currentPage,
        int totalElements,
        int totalPages,
        int pageSize,
        boolean hasNext,
        boolean hasPrevious) {

}
