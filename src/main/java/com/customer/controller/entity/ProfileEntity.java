package com.customer.controller.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "user_login_tbl1")
public class ProfileEntity {
	@Id
	@Column(length = 30)
	private String username;
	@Column(length = 45)
	private String password;
	@Column(length = 45)
	private String name;
	@Column(length = 45)
	private String email;
	@Column(length = 45)
	private String mobile;
	@Column(length = 45)
	private String gender;
	@Transient
	private String photo;
	@Column(length = 45)
	private String qualification;
	@Column
	private Timestamp createddate;
	@Transient
	private MultipartFile image;
	@Column(name = "photo", columnDefinition = "longblob")
	private byte[] photoByte;
	
	
	
	
	
	public byte[] getPhotoByte() {
		return photoByte;
	}

	public void setPhotoByte(byte[] photoByte) {
		this.photoByte = photoByte;
	}

	private static Set<ProfileEntity> loggedInUsers = new HashSet<>();

	public static Set<ProfileEntity> loggedInUser() {
		return loggedInUsers;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Timestamp getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}

	public ProfileEntity() {
	}

	public ProfileEntity(String username, String password, String name, String email, String mobile, String gender,
			String photo, String qualification) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.photo = photo;
		this.qualification = qualification;
	}

	public ProfileEntity(String username, String password, String name, String email, String mobile, String gender,
			String photo, String qualification, Timestamp createddate) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.photo = photo;
		this.qualification = qualification;
		this.createddate = createddate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfileEntity other = (ProfileEntity) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProfileEntity [username=" + username + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", mobile=" + mobile + ", gender=" + gender + ", photo=" + photo + ", qualification=" + qualification
				+ ", createddate=" + createddate + "]";
	}

}
