package com.newvision.com.Assignment1.persistence.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@Column(name = "id")
	private Long roleId;

	@Column(name = "name")
	private String name;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@OneToMany(targetEntity = Permission.class, cascade = CascadeType.ALL)
	private List<Permission> permission;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Long roleId, String name, String title, String description, List<Permission> permission) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.title = title;
		this.description = description;
		this.permission = permission;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Permission> getPermission() {
		return permission;
	}

	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + ", title=" + title + ", description=" + description
				+ ", permission=" + permission + "]";
	}


}
