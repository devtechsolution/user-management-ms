package org.as.devtechsolution.user.service;
import org.as.devtechsolution.user.dto.UserDto;
import org.as.devtechsolution.user.mapper.UserMapper;
import org.as.devtechsolution.user.repository.UserRepository;
import org.as.devtechsolution.user.vo.Department;
import org.as.devtechsolution.user.vo.ResponseTemplateVO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;


	private final RestTemplate restTemplate;

	public UserDto saveUser(UserDto user) {
		log.info("Inside saveUser of UserService");
		return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(user)));
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Inside getUserWithDepartment of UserService");
		final ResponseTemplateVO vo = new ResponseTemplateVO();
		final UserDto userDto = userMapper.userToUserDto(userRepository.findByUserId(userId));

		final Department department =
				restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + userDto.getDepartmentId()
				,Department.class);

		vo.setUser(userDto);
		vo.setDepartment(department);

		return  vo;
	}
}