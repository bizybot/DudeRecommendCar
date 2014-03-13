package com.yogotic.pravega.service;

import java.text.ParseException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yogotic.pravega.converter.UserDtoConverter;
import com.yogotic.pravega.dto.UserDto;
import com.yogotic.pravega.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDtoConverter userDtoConverter;
	
	@Transactional
	public UserDto saveUser(UserDto dto) throws ParseException {
		return userDtoConverter.fromDo(userRepository.save(userDtoConverter.toDo(dto)));
	}
	
	@Transactional
	public void deleteUser(Long id) {
		userRepository.delete(id);
	}
	
	@Transactional
	public UserDto getUser(Long id) {
		return userDtoConverter.fromDo(userRepository.findOne(id));
	}
	
	@Transactional
	public Set<UserDto> getAllUsers() {
		return userDtoConverter.fromDo(userRepository.findAll().as(Set.class));
	}
	
	@Transactional
	public UserDto findByUserName(String userName) {
		return userDtoConverter.fromDo(userRepository.findByUserName(userName));
	}
}
