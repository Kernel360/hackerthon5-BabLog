package kr.bablog.bablogbe.post.dto;



public record PostResponseDto(
        Long id,
        String title,
        String address,
        String imgUrl) {
}
