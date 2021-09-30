package com.newvision.com.Assignment1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newvision.com.Assignment1.exception.UserNotFoundException;
import com.newvision.com.Assignment1.persistence.entity.Permission;
import com.newvision.com.Assignment1.repository.PermissionRepository;

@Service
public class PermissionService {
	@Autowired
	private PermissionRepository permissionRepository;
	
	/**
	 * @author Trupti
	 * @param role
	 * @return the newly created Permission by request.
	 */	
	public Permission addPermission(Permission newPermission) {
		return permissionRepository.save(newPermission);
	}
	
	/**
	 * @author Trupti
	 * 
	 * @return the list of  Permission by request.
	 */	
	public List<Permission> getPermissions() {
		return permissionRepository.findAll();
	}
	
	
	/**
	 * @author Trupti
	 * @param id
	 * @return the  Permission by request.
	 */	
	
	public Permission getPermissionById(long id) {
		return permissionRepository.findById(id).get();
	}
	
	/**
	 * @author Himanshu Mangal
	 * @param id, permission1
	 * @return updated Permission1 by request.
	 */	
	public Permission updatePermission(long id, Permission permission) {
		Optional<Permission> permissionOpt = permissionRepository.findById(id);
		Permission permissionInDb = null;
		if(permissionOpt.isPresent()) {
			permissionInDb = permissionOpt.get();
			permissionInDb.setAction(permission.getAction());
			permissionInDb.setActive(permission.isActive());
			return permissionRepository.save(permissionInDb);
		}
		else
		{
			throw new UserNotFoundException(id);
		}
		
	}
	
	
	/**
	 * @author Trupti Vinchurkar
	 * @param id
	 * @return delete Permission by id.
	 */	
	public void deleteById(long id)	{
		permissionRepository.deleteById(id);
	}

}
