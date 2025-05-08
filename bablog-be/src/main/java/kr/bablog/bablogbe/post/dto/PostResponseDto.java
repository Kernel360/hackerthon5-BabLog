package kr.bablog.bablogbe.post.dto;



public record PostResponseDto(
        Long postId,
        String title,
        String address,
        String imgUrl) {
}
