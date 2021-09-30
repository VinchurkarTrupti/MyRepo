package com.newvision.com.Assignment1.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permission")
public class Permission {

	@Id 
	@Column(name = "permission_id")
	private Long permissionId;

	@Column(name = "action")
	private String action;

	@Column(name = "active")
	private boolean active;

	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Permission(Long permissionId, String action, boolean active) {
		super();
		this.permissionId = permissionId;
		this.action = action;
		this.active = active;
	}

	
	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Permission [permissionId=" + permissionId + ", action=" + action + ", active=" + active + "]";
	}

}
