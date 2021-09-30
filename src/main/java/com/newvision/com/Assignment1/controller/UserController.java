package com.newvision.com.Assignment1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newvision.com.Assignment1.persistence.entity.User;
import com.newvision.com.Assignment1.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("api/user")
@Api(value = "UserController")

public class UserController {
	@Autowired
	private UserService userService;
	

	/**
	 * @author Trupti
	 * 
	 * save user in database
	 */
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Insert new user ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User inserted successfully") })
	public ResponseEntity<User> addUser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	/**
	 * @author Trupti;
	 * 
	 * get all users from database
	 * 
	 */
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get All users ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Users are fetch successfully") })
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> userList = userService.getAllUser();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	/**
	 * @author Trupti
	 * @param id
	 * @return the specified user by id.
	 */
	/*@RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Give users", notes = "Returns a user of given index")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "User not found") })
	public ResponseEntity<User> getUser(@ApiParam(value = "Index of user array", required = true) @PathVariable Long id) {
		Optional<User> user= userService.getUserById(id);
		return new ResponseEntity<User>(user.get(), HttpStatus.FOUND);
	}

	
	*//**
	 * @author Trupti
	 * @param id user updated the exiting user by id
	 *//*
	@RequestMapping(value = "/updateUserById/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Add new user in existing list")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User updated successfully") })
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		User storedUser = userService.updateUser(id,user);
		return new ResponseEntity<User>(storedUser, HttpStatus.OK);
	}*/

	/**
	 * @Author Trupti
	 * 
	 * @Param id
	 * 
	 */
//	@RequestMapping(value = "/deleteUserById/{id}", method = RequestMethod.DELETE)
//	@ApiOperation(value = "delete exting user")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "user deleted successfully") })
//	public ResponseEntity<String> deleteUser(
//			@ApiParam(value = "Index of user array", required = true) @PathVariable Long id) {
//		userService.deleteUser(id);
//		return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
//	}


}
