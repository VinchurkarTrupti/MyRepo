package com.newvision.com.Assignment1.persistence.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.newvision.com.Assignment1.persistence.ContactDetailsView;

@Entity
@Table(name = "json")
public class JsonValidator {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "jsonId")
	private Long jsonId;
	
	@OneToOne(targetEntity = ContactDetailsView.class, cascade = CascadeType.ALL)
	private List<ContactDetailsView> contactDetailsView;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;
	
	@Override
	public String toString() {
		return "Json [jsonId=" + jsonId + ",  firstName="
				+ firstName +  ", lastName=" + lastName +  "]";
	}

}
