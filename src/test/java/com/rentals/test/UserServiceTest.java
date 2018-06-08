package com.rentals.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import com.rentals.model.User;
import com.rentals.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	UserService userService;

	static User user;

	@BeforeClass
	public static void setUp() throws Exception {
		user = new User(1, "Spring", "spring@gmail.com", "qwerty1234", "99424467");

	}

	@Test
	public void testSaveUser() {
		User savedUser = userService.saveUser(user);

		assertEquals(1, savedUser.getId());
		assertEquals("Spring", savedUser.getName());
		assertEquals("spring@gmail.com", savedUser.getEmail());
		assertEquals(savedUser, user);

	}

	@Test
	public void testFindUserById() {
		User userFoundById = userService.findUserById(1);

		assertEquals(1, userFoundById.getId());
		assertEquals("Spring", userFoundById.getName());
		assertEquals("spring@gmail.com", userFoundById.getEmail());
		assertEquals("qwerty1234", userFoundById.getProofNumber());
		assertEquals(user.getPhoneNumber(), userFoundById.getPhoneNumber());

	}

	@Test
	public void testDeleteUser() {
		User userNew = new User(2, "hello", "hello@gmail.com", "abcd3456", "801558990");
		User userToBeDeleted = userService.saveUser(userNew);

		userService.deleteUser(userToBeDeleted);
		User deletedUserById = userService.findUserById(2);
		assertNull(deletedUserById);
	}

	/* saving two user with same email or proofnumber */
	@Test(expected = DataIntegrityViolationException.class)
	public void testUniqueConstraint() {
		userService.saveUser(new User(2, "hello", "hello@gmail.com", "abcd3456", "801558990"));
		userService.saveUser(new User(3, "hello", "hello@gmail.com", "abcd3456", "801558990"));
	}

	/* finding user by unknown id */
	@Test(expected = NullPointerException.class)
	public void testFindUserByUnknownId() {
		User userFoundByUnknownId = userService.findUserById(7);
		assertEquals(null, userFoundByUnknownId.getId());
	}

	@AfterClass
	public static void tearDown() {
		user = null;
	}

}
