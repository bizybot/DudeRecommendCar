package com.yogotic.pravega.controller;

import java.text.ParseException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yogotic.pravega.dto.CarRecommendationDto;
import com.yogotic.pravega.dto.UserDto;
import com.yogotic.pravega.service.RatingService;
import com.yogotic.pravega.service.RecommendationService;
import com.yogotic.pravega.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RatingService ratingService;
	@Autowired
	private RecommendationService recommendationService;

	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody UserDto saveUser(@RequestBody UserDto dto) throws ParseException {
		return userService.saveUser(dto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody UserDto getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}
	
	@RequestMapping(value = "/find/{userName}", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody UserDto getUser(@PathVariable String userName) {
		return userService.findByUserName(userName);
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Set<UserDto> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/{id}/rate/{carId}", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void rateCar(@PathVariable Long id, @PathVariable Long carId, @RequestParam("stars") int stars,@RequestParam(required=false,value="comment") String comment) {
		ratingService.rate(id, carId, stars, comment);
	}
	
	@RequestMapping(value = "/{id}/recommendations", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Set<CarRecommendationDto> getRecommendations(@PathVariable Long id) {
		return recommendationService.getRecommendations(id);
	}
	
}
