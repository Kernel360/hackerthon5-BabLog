package kr.bablog.bablogbe.common.api.response;

import kr.bablog.bablogbe.common.api.error.ErrorMessage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<S> {

	private final ResultType result;

	private final S data;

	private final ErrorMessage error;

	public static ApiResponse<?> success() {
		return new ApiResponse<>(ResultType.SUCCESS, null, null);
	}

	public static <S> ApiResponse<S> success(S data) {
		return new ApiResponse<>(ResultType.SUCCESS, data, null);
	}

	public static ApiResponse<?> error(final String code, final String message) {
		return new ApiResponse<>(ResultType.ERROR, null, new ErrorMessage(code, message));
	}

	public static ApiResponse<?> error(final String code, final String message, Object errorData) {
		return new ApiResponse<>(ResultType.ERROR, null, new ErrorMessage(code, message, errorData));
	}
}
