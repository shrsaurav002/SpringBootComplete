//package com.customer.dbDao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.web.multipart.MultipartFile;
//
//import com.customer.controller.entity.ProfileEntity;
//
//public interface ProfileDaoInt {
//
//	ProfileEntity login(String pusername, String ppassword);
//
//	int delete(String email);
//
//	ArrayList<ProfileEntity> profile();
//
//	List<String> qual();
//
//	ProfileEntity edit(String pemail);
//
//	ArrayList<ProfileEntity> qualfilter(String qual);
//
//	String resetpw(String username);
//
//	ArrayList<ProfileEntity> dbsearch(String search);
//
//	int signup(ProfileEntity profileDTO);
//
//	ArrayList<ProfileEntity> sort(String order);
//
//	int update(ProfileEntity profileDTO);
//
//	ProfileEntity srchUser(String pemail);
//
//	void connect();
//
//	byte[] srchUserForImage(String pemail);
//
//	ArrayList<ProfileEntity> findAllWithPhoto();
//
//	int changeImage(String username, MultipartFile file);
//
//	ArrayList<ProfileEntity> profileWithPage(int num);
//
//	Double totalData();
//
//	int registerNew(ProfileEntity profileEntity);
//
//
//	
//
//}
