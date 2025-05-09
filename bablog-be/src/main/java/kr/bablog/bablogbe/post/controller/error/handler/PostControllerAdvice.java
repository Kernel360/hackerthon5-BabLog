package kr.bablog.bablogbe.post.controller.error.handler;

import kr.bablog.bablogbe.common.api.response.ApiResponse;
import kr.bablog.bablogbe.post.service.errors.PostErrorType;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import java.util.NoSuchElementException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class PostControllerAdvice {


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentTypeMismatch() {
        final PostErrorType errorType = PostErrorType.ARGUMENT_MISSMATCH;
        
        return ResponseEntity.badRequest()
                .body(ApiResponse.error(errorType.getPostErrorCode().toString(), errorType.getMessage()));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiResponse<?>> handleNoSuchElement() {
        final PostErrorType errorType = PostErrorType.NOSUCH_ELEMENT;

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error(errorType.getPostErrorCode().toString(), errorType.getMessage()));
    }

}
