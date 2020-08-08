package com.customer.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.customer.controller.entity.ProfileEntity;
import com.customer.dbDao.SpringDataJPA;
import com.customer.profileDTO.ProfileDTO;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

//	@Autowired
//	private ProfileDao profileDao;
	@Autowired
	private SpringDataJPA springDataJPA;

	@Override
	public ProfileDTO login(String pusername, String ppassword) {
		Optional<ProfileEntity> optional = springDataJPA.findByUsernameAndPassword(pusername, ppassword);
		ProfileDTO profileDTO = convertToDTO(optional);
		return profileDTO;

	}

	@Override
	public void delete(String email) {
		springDataJPA.deleteById(email);
	}

	@Override
	public ArrayList<ProfileDTO> profile() {
		List<ProfileEntity> elist = springDataJPA.findAll();
		// String test=elist.get(0).getPhoto();
		ArrayList<ProfileDTO> dlist = (ArrayList<ProfileDTO>) convert(elist);

		return dlist;
	}

	@Override
	public List<String> qual() {
		List<String> q = springDataJPA.findMyQualification();
		return q;
	}

	@Override
	public ProfileDTO edit(String pemail) {
		ProfileEntity entity = springDataJPA.getOne(pemail);
		// ProfileEntity entity = profileDao.edit(pemail);
		ProfileDTO profileDTO = new ProfileDTO();
		BeanUtils.copyProperties(entity, profileDTO);
		return profileDTO;
	}

	@Override
	public ArrayList<ProfileDTO> qualfilter(String qual) {
		// List<ProfileEntity> elist = profileDao.qualfilter(qual);
		List<ProfileEntity> elist = springDataJPA.filter(qual);
		ArrayList<ProfileDTO> dlist = (ArrayList<ProfileDTO>) convert(elist);
		return dlist;
	}

	@Override
	public String resetpw(String username) {
		// String pw = profileDao.resetpw(username);
		// String = springDataJPA.getOne(username).getPassword();
		ProfileEntity profileEntity = springDataJPA.findByUsernameOrEmail(username, username);

		return profileEntity.getPassword();
	}

	@Override
	public ArrayList<ProfileDTO> dbsearch(String search) {
		// List<ProfileEntity> elist = profileDao.dbsearch(search);
		List<ProfileEntity> elist = springDataJPA.search(search, search);
		// List<ProfileEntity> list=springDataJPA.findAll()
		ArrayList<ProfileDTO> dlist = (ArrayList<ProfileDTO>) convert(elist);
		return dlist;
	}

	@Override
	@Deprecated
	public int signup(ProfileDTO profileDTO) {

		ProfileEntity entity = new ProfileEntity();

		BeanUtils.copyProperties(profileDTO, entity);
		if (entity != null) {
			springDataJPA.save(entity);
			// int i = profileDao.signup(entity);
			// return i;
			return 1;
		}
		return 2;
	}

	@Override
	public ArrayList<ProfileDTO> sort(String order) {
		// List<ProfileEntity> elist = profileDao.sort(order);
		List<ProfileEntity> elist = new ArrayList<>();
		if (order.equalsIgnoreCase("asc")) {
			elist = springDataJPA.findAllByOrderByEmailAsc();
		} else {
			elist = springDataJPA.findAllByOrderByEmailDesc();
		}

		ArrayList<ProfileDTO> dlist = (ArrayList<ProfileDTO>) convert(elist);
		return dlist;
	}

	@Override
	public int update(ProfileDTO profileDTO) {
		ProfileEntity entity = springDataJPA.findById(profileDTO.getUsername()).get();

		BeanUtils.copyProperties(profileDTO, entity);

		// springDataJPA.save
		// int result = profileDao.update(entity);
		return 5;
	}

	@Override
	public ProfileDTO srchUser(String pemail) {
		// ProfileEntity entity = profileDao.srchUser(pemail);

		Optional<ProfileEntity> optional = springDataJPA.findByEmail(pemail);
		ProfileDTO profileDTO = convertToDTO(optional);
//		ProfileDTO profileDTO = new ProfileDTO();
//		BeanUtils.copyProperties(entity, profileDTO);
		return profileDTO;
	}

	private ProfileDTO convertToDTO(Optional<ProfileEntity> optional) {
		ProfileDTO profileDTO = null;
		if (optional.isPresent()) {
			ProfileEntity entity = optional.get();
			profileDTO = new ProfileDTO();
			BeanUtils.copyProperties(entity, profileDTO);
		}
		return profileDTO;
	}

	private List<ProfileDTO> convert(List<ProfileEntity> entityList) {
		List<ProfileDTO> list = new ArrayList<>();
		for (ProfileEntity entity : entityList) {
			ProfileDTO profileDTO = new ProfileDTO();
			BeanUtils.copyProperties(entity, profileDTO);
			list.add(profileDTO);
		}
		return list;

	}

	@Override
	public void connect() {
		// TODO Auto-generated method stub

	}

	@Override
	public byte[] srchUserForImage(String pemail) {
		// byte[] img = profileDao.srchUserForImage(pemail);
		byte[] img = springDataJPA.findById(pemail).get().getPhotoByte();
		return img;
	}

	@Override
	public ArrayList<ProfileDTO> findAllWithPhoto() {
		List<ProfileEntity> list = springDataJPA.findAll();
//		List<ProfileEntity> list = profileDao.findAllWithPhoto();
		List<ProfileDTO> dtoList = convert(list);
		return (ArrayList<ProfileDTO>) dtoList;
	}

	@Override
	public int changeImage(String username, MultipartFile file) {
		// int i = profileDao.changeImage(username, file);
		ProfileEntity profileEntity = springDataJPA.findById(username).get();
		try {
			profileEntity.setPhotoByte(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 5;

	}

	@Override
	public ArrayList<ProfileDTO> profileWithPage(int num) {

		Pageable elements = PageRequest.of(num - 1, 3);
		Page<ProfileEntity> page = springDataJPA.findAll(elements);
		// List<ProfileEntity> list=springDataJPA.findAll(ag );
		List<ProfileEntity> list = page.getContent();
		// List<ProfileEntity> list = profileDao.profileWithPage(num);
		List<ProfileDTO> dtoList = convert(list);
		return (ArrayList<ProfileDTO>) dtoList;

	}

	@Override
	public Double totalData() {
		// Double i = profileDao.totalData();
		Double i = (double) springDataJPA.count();
		return i;
	}

	@Override
	public int registerNew(ProfileDTO profileDTO) {
		ProfileEntity profileEntity = new ProfileEntity();
		BeanUtils.copyProperties(profileDTO, profileEntity);
//		int i = profileDao.registerNew(profileEntity);
		try {
			profileEntity.setPhotoByte(profileDTO.getImage().getBytes());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		springDataJPA.save(profileEntity);
		return 1;
	}

}
