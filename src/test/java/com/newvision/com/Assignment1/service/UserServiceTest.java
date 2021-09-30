/*package com.newvision.com.Assignment1.service;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.newvision.com.Assignment1.persistence.entity.Role;
import com.newvision.com.Assignment1.persistence.entity.User;
import com.newvision.com.Assignment1.repository.UserRepository;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)

class UserServiceTest {

	@Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;
    
	
	@Test
	 void shouldSaveUserSuccessfully()throws Exception{
		final Long userId = null;
		List<Role> roles = new ArrayList<Role>();
		final User user = new User(userId, new Date(), new Date(), "asd", "sdasd", "hind",
				"trupti@newvision", "trupti", "m", "vinchurkar", "devloper", new Date(), true, 1, true, roles);
		
		Mockito.lenient().when(userRepository.findById(userId)).thenReturn(Optional.empty());
		given(userRepository.save(user)).willAnswer((invocation) -> invocation.getArgument(0));
	     
		User saveUser = userService.addUser(user);
		assertThat(saveUser).isNotNull();
	    verify(userRepository).save(any(User.class));
	}

	@Test
	 void shouldFindUserById()throws Exception{
		final Long userId = null;
	//	List<Role> roles = new ArrayList<Role>();
		final User user = new User();
		
		given(userRepository.findById(userId)).willReturn(Optional.of(user));

		final Optional<User> expected=userService.getUserById(userId);
		//System.out.println("userId  "+userId+" expected "+expected);
		assertThat(expected,is(not(equalTo(null))));
	    //verify(userRepository).save(any(User.class));
	}
	
	@Test
	void shouldDeleteUserById() throws Exception{
		final Long userId =2L; 
		userService.deleteUser(userId);
		userService.deleteUser(userId);
		verify(userRepository,times(2)).deleteById(userId);
	}
	
	@Test
	void shouldFindAllUserTest()throws Exception{
		List<User> userList = new ArrayList<User>();
		List<Role> roles = new ArrayList<Role>();
		
		userList.add(new User(2L, new Date(), new Date(), "asd", "sdasd", "hind",
				"trupti@newvision", "trupti", "m", "vinchurkar", "devloper", new Date(), true, 1, true, roles));
		
		userList.add(new User(3L, new Date(), new Date(), "asd", "sdasd", "hind",
				"trupti@newvision", "sayali", "m", "vinchurkar", "devloper", new Date(), true, 1, true, roles));
		
		given(userRepository.findAll()).willReturn(userList);
		List<User> expected = userService.getAllUser();
		assertEquals(expected, userList);
	}
	
	@Test
	void shouldUpdateUserByIdTest() throws Exception{
		List<Role> roles = new ArrayList<Role>();
		Long userId=2L;
		final User user = new User(userId, new Date(), new Date(), "asd", "sdasd", "hind",
				"trupti@newvision", "sayali", "m", "vinchurkar", "devloper", new Date(), true, 1, true, roles);
		
		Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
		
		given(userRepository.save(user)).willReturn(user);
		 User expected = userService.updateUser(userId, user);
		assertThat(expected).isNotNull();
		//verify(userRepository.save(expected));
	}
	
	@Test
	public void fetchUsersNotFoundTest() throws Exception {
	//	List<Role> roles = new ArrayList<Role>();
		Long userId=null;
		final User user = new User();
		Mockito.lenient().when(userRepository.findById(userId)).thenReturn(Optional.empty());
		
		//Optional<User> expected = userService.getUserById(userId);
		assertThat(user.getUserId()).isEqualTo(userId);
	//	assertThat(expected).isNotPresent();
	
	}
	@Test
	public void isPresentTest() {
		final Long userId = 7L;

		Mockito.when(userRepository.existsById(userId)).thenReturn(true);
		Boolean isPresent = userService.ifExist(userId);
		assertEquals(true, isPresent);
		verify(userRepository, times(1)).existsById(userId);
	}

	
	@Test
	public void updateUserNotFoundTest() throws Exception {
		final Long userId = 2L;
		final User user = new User();
		user.setUserId(userId);
		user.setFirstName("trupti");
		user.setLastName("vinchurkar");
		Mockito.when(userRepository.existsById(userId)).thenReturn(false);
		boolean userData = userService.ifExist(userId);
		assertEquals(false, userData);
		
		verify(userRepository, times(0)).save(user);

	}
}
*/