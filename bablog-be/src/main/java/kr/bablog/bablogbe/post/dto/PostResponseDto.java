package kr.bablog.bablogbe.post.dto;


import java.time.LocalDateTime;

public record PostResponseDto(
        Long id,
        String title,
        String address,
        String imgUrl,
        LocalDateTime createdAt) {
}
