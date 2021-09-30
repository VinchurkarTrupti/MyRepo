package com.newvision.com.Assignment1.persistence.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "userId")
	private Long userId;

	/*@Column(name = "creationDate")
	private Date creationDate;

	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "modificationDate")
	private Date modificationDate;

	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}*/

	@Column(name = "password")
	private String password;

	/*@Column(name = "reminderQueryQuestion")
	private String reminderQueryQuestion;

	@Column(name = "reminderQueryAnswer")
	private String reminderQueryAnswer;

	@Column(name = "emailAddress")
	private String emailAddress;*/

	@Column(name = "firstName")
	private String firstName;

//	@Column(name = "middleaName")
//	private String middleaName;

	@Column(name = "lastName")
	private String lastName;

	/*@Column(name = "jobTitle")
	private String jobTitle;

	@Column(name = "loginDate")
	private Date loginDate;

	@Column(name = "agreedToTermsOfUse")
	private boolean agreedToTermsOfUse;

	@Column(name = "status")
	private int status;

	@Column(name = "emailAddressVerified")
	private boolean emailAddressVerified;

	@OneToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
	private List<Role> roles;
*/
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long userId,String password, String firstName, String lastName) {
		super();
		this.userId = userId;
		//this.creationDate = creationDate;
		//this.modificationDate = modificationDate;
		this.password = password;
		//this.reminderQueryQuestion = reminderQueryQuestion;
		//this.reminderQueryAnswer = reminderQueryAnswer;
		//this.emailAddress = emailAddress;
		this.firstName = firstName;
		//this.middleaName = middleaName;
		this.lastName = lastName;
		//this.jobTitle = jobTitle;
		//this.loginDate = loginDate;
		//this.agreedToTermsOfUse = agreedToTermsOfUse;
		//this.status = status;
		//this.emailAddressVerified = emailAddressVerified;
		//this.roles = roles;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

/*	public String getReminderQueryQuestion() {
		return reminderQueryQuestion;
	}

	public void setReminderQueryQuestion(String reminderQueryQuestion) {
		this.reminderQueryQuestion = reminderQueryQuestion;
	}

	public String getReminderQueryAnswer() {
		return reminderQueryAnswer;
	}

	public void setReminderQueryAnswer(String reminderQueryAnswer) {
		this.reminderQueryAnswer = reminderQueryAnswer;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
*/
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

//	public String getMiddleaName() {
//		return middleaName;
//	}
//
//	public void setMiddleaName(String middleaName) {
//		this.middleaName = middleaName;
//	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	public String getJobTitle() {
//		return jobTitle;
//	}
//
//	public void setJobTitle(String jobTitle) {
//		this.jobTitle = jobTitle;
//	}
//
//	public Date getLoginDate() {
//		return loginDate;
//	}
//
//	public void setLoginDate(Date loginDate) {
//		this.loginDate = loginDate;
//	}
//
//	public boolean isAgreedToTermsOfUse() {
//		return agreedToTermsOfUse;
//	}
//
//	public void setAgreedToTermsOfUse(boolean agreedToTermsOfUse) {
//		this.agreedToTermsOfUse = agreedToTermsOfUse;
//	}
/*
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isEmailAddressVerified() {
		return emailAddressVerified;
	}

	public void setEmailAddressVerified(boolean emailAddressVerified) {
		this.emailAddressVerified = emailAddressVerified;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}*/

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password +  ", firstName="
				+ firstName +  ", lastName=" + lastName   + "]";
	}

}
