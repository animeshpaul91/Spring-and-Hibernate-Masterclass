package com.in28minutes.learning.jpa.jpain10steps;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;
import com.in28minutes.learning.jpa.jpain10steps.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User("Jill", "Smith");

		// New user is created in in memory Database
		userRepository.save(user);

		Optional<User> userWithId1 = userRepository.findById(1L);
		log.info("New User is Retrieved: " + userWithId1);

		List<User> users = userRepository.findAll();

		log.info("All users: " + users);

	}
}
