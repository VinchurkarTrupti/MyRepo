package com.newvision.com.Assignment1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newvision.com.Assignment1.exception.UserNotFoundException;
import com.newvision.com.Assignment1.persistence.entity.User;
import com.newvision.com.Assignment1.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;

	/**
	 * @author Trupti
	 * @param user
	 * @return the newly created user by request.
	 */
	public User addUser(User newUser) {
		return userRepo.save(newUser);
	}

	/**
	 * @author Trupti
	 * 
	 * @return the list of all user by request.
	 */
	public List<User> getAllUser() {
		return userRepo.findAll();
	} 
	
	/**
	 * @author Trupti
	 * @param id
	 * @return the True if user is present 
	 * else return false.
	 */
	
	public boolean ifExist(Long id) {
		return userRepo.existsById(id);
	}

	/**
	 * @author Trupti
	 * @param id
	 * @return the User by request.
	 */
	public Optional<User> getUserById(Long id) {
		return userRepo.findById(id);
	}

	/**
	 * @author Trupti
	 * @param id
	 * @delete the User by request.
	 */
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}

	/**
	 * @author Trupti
	 * @param user,id
	 * @return the updated  user by request.
	 */
	public User updateUser(Long id, User user) {
		Optional<User> updateOpt = userRepo.findById(id);
		User userInDb = null;
		if (updateOpt.isPresent()) {
			userInDb = updateOpt.get();
			userInDb.setUserId(id); 
		//	userInDb.setCreationDate(user.getCreationDate());
		//	userInDb.setModificationDate(user.getModificationDate());
			userInDb.setPassword(user.getPassword());
//			userInDb.setReminderQueryQuestion(user.getReminderQueryQuestion());
//			userInDb.setReminderQueryAnswer(user.getReminderQueryAnswer());
//			userInDb.setEmailAddress(user.getEmailAddress());
//			userInDb.setFirstName(user.getFirstName());
	//		userInDb.setMiddleaName(user.getMiddleaName());
			userInDb.setLastName(user.getLastName());
//			userInDb.setJobTitle(user.getJobTitle());
//			userInDb.setLoginDate(user.getLoginDate());
//			userInDb.setAgreedToTermsOfUse(user.isAgreedToTermsOfUse());
//			userInDb.setStatus(user.getStatus());
//			userInDb.setEmailAddressVerified(user.isEmailAddressVerified());
//			userInDb.setRoles(user.getRoles());
//			userRepo.save(userInDb);
			return userInDb;

		} else {
			throw new UserNotFoundException(id);
		}

	}

}
