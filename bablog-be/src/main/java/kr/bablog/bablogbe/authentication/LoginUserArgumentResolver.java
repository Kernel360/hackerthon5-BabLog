package kr.bablog.bablogbe.authentication;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import jakarta.servlet.http.HttpServletRequest;
import kr.bablog.bablogbe.authentication.dto.LoginUser;

@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterType() == LoginUser.class;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest servletRequest = (HttpServletRequest) webRequest.getNativeRequest();
		Object objectLoginUser = servletRequest.getAttribute("loginUser");

		if (objectLoginUser != null && objectLoginUser instanceof LoginUser) {
			return (LoginUser) objectLoginUser;
		}

		return null;
	}
}
