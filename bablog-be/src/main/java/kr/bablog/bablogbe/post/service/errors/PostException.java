package kr.bablog.bablogbe.post.service.errors;


import lombok.Getter;

@Getter
public abstract class PostException extends RuntimeException{
    private final PostErrorType errorType;

    public PostException(final PostErrorType postErrorType) {
        super(postErrorType.getMessage());
        this.errorType = postErrorType;
    }
}
