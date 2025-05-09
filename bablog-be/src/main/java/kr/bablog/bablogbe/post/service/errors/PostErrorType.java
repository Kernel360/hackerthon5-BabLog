package kr.bablog.bablogbe.post.service.errors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PostErrorType {
    ARGUMENT_MISSMATCH(PostErrorCode.ERROR_POST01, "잘못된 접근입니다"),
    NOSUCH_ELEMENT(PostErrorCode.ERROR_POST02, "요청받은 리소스를 찾을 수 없습니다");

    private final PostErrorCode postErrorCode;
    private final String message;
}
