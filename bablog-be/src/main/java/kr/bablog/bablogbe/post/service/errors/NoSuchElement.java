package kr.bablog.bablogbe.post.service.errors;

public class NoSuchElement extends PostException {
    public NoSuchElement(PostErrorType postErrorType) {
        super(postErrorType);
    }
}
