package com.newvision.com.Assignment1.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class ContactDetailsView {
	@Id
	@Column(name = "id")
	private Long contactId;


	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Column(name = "contactNo")
	private String contactNo;

	@Override
	public String toString() {
		return "ContactDetailsView [contactId=" + contactId + ",  contactNo="
				+ contactNo +   "]";
	}
	
}
