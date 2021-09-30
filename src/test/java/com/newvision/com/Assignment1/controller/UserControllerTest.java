/*package com.newvision.com.Assignment1.controller;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newvision.com.Assignment1.persistence.entity.Role;
import com.newvision.com.Assignment1.persistence.entity.User;
import com.newvision.com.Assignment1.repository.UserRepository;
import com.newvision.com.Assignment1.service.UserService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {


	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

		
	@MockBean
	private UserRepository userRepository;

	private User user;
	List<User> usersList;

	private static ObjectMapper mapper = new ObjectMapper();
	@BeforeEach
	void setUp() {

		user = new User();
		user.setFirstName("trupti");
		user.setMiddleaName("vinayak");
		user.setLastName("vinchurkar");

		usersList = new ArrayList<User>();
		usersList.add(user);
	}


	@Test
	void shouldgetAllUsers() throws Exception {
		given(userService.getAllUser()).willReturn(usersList);
		this.mockMvc.perform(get("/api/user/getAllUsers").contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isOk()).andExpect(jsonPath("$.size()", is(usersList.size())));

	}


	@Test
	void fetchUserById() throws Exception {
		final Long userId = 1L;
		final User user = new User();
		user.setFirstName("new vision");
		user.setLastName("sofware");

		given(userService.getUserById(userId)).willReturn(Optional.of(user));

		this.mockMvc.perform(get("/api/user/getUserById/{id}", userId)).andExpect(status().isFound())
		.andExpect(jsonPath("$.firstName", is(user.getFirstName())));


	}

	@Test
	void shouldReturn404WhenFindUserById() throws Exception {

		final Long userId = 3L;
		given(userService.getUserById(userId)).willReturn(Optional.empty());
		this.mockMvc.perform(get("/api/user/getUser/{id}", userId)).andExpect(status().isNotFound());
	}


	@Test
	void shouldCreateNewUser() throws Exception {
		given(userService.addUser(any(User.class))).willAnswer((invocation) -> invocation.getArgument(0));
		List<Role> roles = new ArrayList<Role>();

		User user = new User(2L, new Date(), new Date(), "tyjn", "qwer", "indian",
				"trupti@newvision", "trupti", "m", "vinchurkar", "devloper", new Date(), true, 1, true, roles);

		this.mockMvc
		.perform(post("/api/user/insertUser").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(user)))
		.andExpect(status().isCreated()).andExpect(jsonPath("$.emailAddress", is(user.getEmailAddress())))
		.andExpect(jsonPath("$.firstName", is(user.getFirstName())))
		.andExpect(jsonPath("$.lastName", is(user.getLastName())))
		.andExpect(jsonPath("$.password", is(user.getPassword())));
	}

	@Test
	void shouldDeleteUserById() throws Exception {
		final Long userId=3L;
		List<Role> roles = new ArrayList<Role>();
		User user = new User(userId, new Date(), new Date(), "123", "abcd", "indian",
				"trupti@vinchurkar", "trupti", "m", "vinchurkar", "devloper", new Date(), true, 1, true, roles);

		given(userService.getUserById(userId)).willReturn(Optional.of(user));
		doNothing().when(userService).deleteUser(user.getUserId());

		this.mockMvc.perform(delete("/api/user/deleteUserById/{id}",userId))
		.andExpect(status().isOk());


	}

	@Test
	public void updateUserByIdTest() throws Exception {
		final Long userId = 2L;
		List<Role> roles = new ArrayList<Role>();
		final User user = new User(2L, new Date(), new Date(), "123", "4567", "indian",
				"trupti@newvision", "trupti", "m", "vinchurkar", "devloper", new Date(), true, 1, true, roles );
		Mockito.when(userRepository.existsById(userId)).thenReturn(true);
		Mockito.when(userService.getUserById(userId)).thenReturn(Optional.of(user));
	
		Mockito.when(userRepository.save(user)).thenReturn(user);
		String json = mapper.writeValueAsString(user);
		mockMvc.perform(put("/api/user/updateUserById/{id}", userId).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(json).accept(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().isOk());
		}
	
	
	@Test
	public void userNotFoundToUpdateServiceTest() throws Exception {
	
		final Long userId = 2L;
		
		user.setUserId(userId);
		user.setFirstName("trupti");
		user.setLastName("vinchurkar");
		Mockito.when(userRepository.existsById(userId)).thenReturn(false);
		Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
		String json = mapper.writeValueAsString(user);

		mockMvc.perform(put("/api/user/updateUserById/{id}",userId).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(json).accept(MediaType.APPLICATION_JSON_VALUE))
		.andDo(print()).andExpect(status().isBadRequest());
	}
	
	
}
*/