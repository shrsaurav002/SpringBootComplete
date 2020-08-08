package com.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.customer.profileDTO.ProfileDTO;

public interface ProfileService {

	ProfileDTO login(String pusername, String ppassword);

	void delete(String email);

	ArrayList<ProfileDTO> profile();

	List<String> qual();

	ProfileDTO edit(String pemail);

	ArrayList<ProfileDTO> qualfilter(String qual);

	String resetpw(String username);

	ArrayList<ProfileDTO> dbsearch(String search);

	int signup(ProfileDTO profileDTO);

	ArrayList<ProfileDTO> sort(String order);

	int update(ProfileDTO profileDTO);

	ProfileDTO srchUser(String pemail);

	void connect();

	byte[] srchUserForImage(String pemail);

	ArrayList<ProfileDTO> findAllWithPhoto();

	int changeImage(String username, MultipartFile file);

	ArrayList<ProfileDTO> profileWithPage(int num);

	Double totalData();
	
	int registerNew(ProfileDTO	profileDTO);

}
