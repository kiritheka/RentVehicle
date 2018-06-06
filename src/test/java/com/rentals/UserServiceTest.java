package com.rentals;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.rentals.model.User;
import com.rentals.repository.UserRepository;
import com.rentals.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	
	
	/*@RunWith(MockitoJUnitRunner.class)
	 * @Mock
	 AdminRepository adminRepository;

	@InjectMocks
	 AdminService adminService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSave() {
		Admin mockAdmin = new Admin(1, "Spring", "Spring@gmail.com", "9876543");
		Mockito.when(adminService.save(Mockito.any(Admin.class))).thenReturn(mockAdmin);
		Admin result = adminService.save(mockAdmin);
		assertEquals(1, result.getId());
		assertEquals("Spring", result.getName());
		assertEquals("Spring@gmail.com", result.getEmail());
	}*/
	
	
	@MockBean
	UserRepository userRepository;

	@Autowired
	UserService userService;
	
	@Test
	public void testSaveUser() {
		User expectedUser = new User(1, "Spring", "Spring@gmail.com", "yut67yy", "99876444");
		when(userRepository.save(expectedUser)).thenReturn(expectedUser);
		User savedUser = userService.saveUser(expectedUser);
		assertEquals(1, savedUser.getId());
		assertEquals("Spring", savedUser.getName());
		assertEquals("Spring@gmail.com", savedUser.getEmail());
	}
	
	
}
