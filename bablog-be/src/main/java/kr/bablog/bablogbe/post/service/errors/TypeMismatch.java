package kr.bablog.bablogbe.post.service.errors;

public class TypeMismatch extends PostException {
    public TypeMismatch(PostErrorType postErrorType) {
        super(postErrorType);
    }
}
