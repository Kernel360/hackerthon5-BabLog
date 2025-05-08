package kr.bablog.bablogbe.users.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.bablog.bablogbe.users.domain.User;
import kr.bablog.bablogbe.users.repository.UserRepository;
import kr.bablog.bablogbe.users.service.errors.UserErrorType;
import kr.bablog.bablogbe.users.service.errors.exception.UserEmailExistException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	@Transactional
	public void createUser(final String email, final String password) {
		if (userRepository.existsByEmail(email)) {
			throw new UserEmailExistException(UserErrorType.USER_EMAIL_EXIST);
		}

		userRepository.save(new User(email, password));
	}
}
