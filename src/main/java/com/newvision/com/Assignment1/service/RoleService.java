package com.newvision.com.Assignment1.service;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newvision.com.Assignment1.exception.UserNotFoundException;
import com.newvision.com.Assignment1.persistence.entity.Role;
import com.newvision.com.Assignment1.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	/**
	 * @author Trupti Vinchurkar
	 * @param Role role
	 * @return the newly created role by request.
	 */	
	public Role addRole(Role newRole) {
		return roleRepository.save(newRole);		
	}
	
	/**
	 * @author Trupti Vinchurkar
	 * 
	 * @return the list of  Role by request.
	 */	
	public List<Role> getRoles() {
		return roleRepository.findAll();
	}
	
	/**
	 * @author Trupti Vinchurkar
	 * @param id
	 * @return the  Role by request.
	 */	
	public Role getRoleById(long id) {
		Optional<Role> roleOpt = roleRepository.findById(id);
		if(roleOpt.isPresent()) {
			return roleOpt.get();
		}
		else
		{
			throw new UserNotFoundException(id);
		}
	}
	
	/**
	 * @author Trupti Vinchurkar
	 * @param id,role
	 * @return updated Role by request.
	 */	
	public Role updateRole(long id, Role role) {
		Optional<Role> roleOpt = roleRepository.findById(id);
		Role roleInDb = null;
		if(roleOpt.isPresent()) {
			roleInDb = roleOpt.get();
			roleInDb.setName(role.getName());
			roleInDb.setTitle(role.getTitle());
			roleInDb.setPermission(role.getPermission());
			roleInDb.setDescription(role.getDescription());
			return roleRepository.save(roleInDb);
		}
		else
		{
			throw new UserNotFoundException(id);
		}
		
	}
	
	/**
	 * @author Trupti Vinchurkar
	 * @param id
	 * @return delete Role by request.
	 */	
	public void deleteById(long id)	{
		roleRepository.deleteById(id);
	}

}
