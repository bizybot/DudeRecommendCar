package com.yogotic.pravega.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.yogotic.pravega.dto.UserDto;
import com.yogotic.pravega.model.User;

@Component
public class UserDtoConverter {

	public Set<UserDto> fromDo(Set<User> users) {
		Set<UserDto> userDtos = new HashSet<UserDto>();
		for(User user:users)
			userDtos.add(fromDo(user));
		return userDtos;
	}
	
	public UserDto fromDo(User user) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return new UserDto(
				user.getId(),
				user.getUserName(),
				sdf.format(user.getDateOfBirth()));
	}
	public User toDo(UserDto dto) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return new User(
				dto.getUserName(),
				dto.getPassword(),
				sdf.parse(dto.getDateOfBirth())
				);
	}
}
