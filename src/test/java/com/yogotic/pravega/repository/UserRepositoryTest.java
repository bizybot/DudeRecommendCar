package com.yogotic.pravega.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yogotic.pravega.model.User;
import com.yogotic.pravega.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-config.xml")
@Transactional
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		User user = new User("admin", "123", sdf.parse("9/15/1983"));
		User userSaved = userRepository.save(user);
		User userRetrieved = userRepository.findByUserName("admin");
		Assert.assertEquals(userSaved, userRetrieved);
		userRepository.delete(userRetrieved.getId());
	}
	
}
