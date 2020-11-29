package org.as.devtechsolution.user.mapper;

import org.as.devtechsolution.user.dto.UserDto;
import org.as.devtechsolution.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

	public User userDtoToUser(UserDto userDto);
	public UserDto userToUserDto(User user);

}
