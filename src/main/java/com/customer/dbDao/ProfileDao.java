//package com.customer.dbDao;
//
//import java.sql.Timestamp;
//import java.sql.Types;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.support.SqlLobValue;
//import org.springframework.jdbc.support.lob.DefaultLobHandler;
//import org.springframework.jdbc.support.lob.LobHandler;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.customer.controller.entity.ProfileEntity;
//
//@Repository
//public class ProfileDao implements ProfileDaoInt {
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	@Override
//	public void connect() {
//
//	}
//
//	@Override
//	public ProfileEntity login(String pusername, String ppassword) {
//		ProfileEntity profileEntity = null;
//		String sql = "select username,password,name,email,qualification,mobile,photo,gender,createddate from user_login_tbl where username=? and password=?";
//		Object[] data = { pusername, ppassword };
//		List<ProfileEntity> prof = jdbcTemplate.query(sql, data, new BeanPropertyRowMapper<>(ProfileEntity.class));
//		if (prof.size() != 0)
//			profileEntity = prof.get(0);
//
//		return profileEntity;
//	}
//
//	@Override
//	public int delete(String email) {
//		int i = 0;
//		String sql = "delete from user_login_tbl where email=?";
//		Object[] data = { email };
//		i = jdbcTemplate.update(sql, data);
//		return i;
//	}
//
//	@Override
//	public ArrayList<ProfileEntity> profile() {
//		List<ProfileEntity> users = new ArrayList<ProfileEntity>();
//		String sql = "select username,password,name,email,qualification,mobile,photo,gender,createddate from user_login_tbl";
//		users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProfileEntity.class));
//		return (ArrayList<ProfileEntity>) users;
//	}
//
//	@Override
//	public List<String> qual() {
//
//		String sql = "select distinct qualification from user_login_tbl";
//		List<String> qualifications = jdbcTemplate.queryForList(sql, String.class);
//		return qualifications;
//
//	}
//
//	@Override
//	public ProfileEntity edit(String pemail) {
//
//		String sql = "select username,password,name,email,qualification,mobile,photo,gender,createddate from user_login_tbl where email=?";
//		Object[] data = { pemail };
//		List<ProfileEntity> user = jdbcTemplate.query(sql, data, new BeanPropertyRowMapper<>(ProfileEntity.class));
//
//		return user.get(0);
//
//	}
//
//	@Override
//	public ArrayList<ProfileEntity> qualfilter(String qual) {
//
//		String sql = "select username,password,name,email,qualification,mobile,photo,gender,createddate from user_login_tbl where qualification=?";
//		Object[] data = { qual };
//		List<ProfileEntity> users = jdbcTemplate.query(sql, data, new BeanPropertyRowMapper<>(ProfileEntity.class));
//		return (ArrayList<ProfileEntity>) users;
//	}
//
//	@Override
//	public String resetpw(String usernameEmail) {
//		String pw = "";
//		String sql = "select password from user_login_tbl where username=? or email=?";
//		Object[] data = { usernameEmail, usernameEmail };
//		try {
//			pw = jdbcTemplate.queryForObject(sql, data, String.class);
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return pw;
//	}
//
//	@Override
//	public ArrayList<ProfileEntity> dbsearch(String search) {
//		List<ProfileEntity> users = null;
//		String sql = "select username,password,name,email,qualification,mobile,photo,gender,createddate from user_login_tbl where name like '%"
//				+ search + "%' or qualification like '%" + search + "%'";
//		users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProfileEntity.class));
//
//		return (ArrayList<ProfileEntity>) users;
//
//	}
//
//	@Override
//	public int signup(ProfileEntity profileEntity) {
//		int i = 0;
//
//		String sql = "insert into user_login_tbl(username,password,name,email,qualification,mobile,photo,gender,createddate) values(?,?,?,?,?,?,?,?,?)";
//		Timestamp createddate = new Timestamp(System.currentTimeMillis());
//		Object[] data = { profileEntity.getUsername(), profileEntity.getPassword(), profileEntity.getName(),
//				profileEntity.getEmail(), profileEntity.getQualification(), profileEntity.getMobile(),
//				profileEntity.getPhoto(), profileEntity.getGender(), createddate };
//		i = jdbcTemplate.update(sql, data);
//		return i;
//	}
//
//	@Override
//
//	public ArrayList<ProfileEntity> sort(String order) {
//		List<ProfileEntity> users = new ArrayList<ProfileEntity>();
//		String sql = "select username,password,name,email,qualification,mobile,photo,gender,createddate from user_login_tbl order by email "
//				+ order;
//
//		users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProfileEntity.class));
//		;
//		return (ArrayList<ProfileEntity>) users;
//	}
//
//	@Override
//	public int update(ProfileEntity profileEntity) {
//		int i = 0;
//		String sql = "update user_login_tbl set password=?, name=?,email=?,qualification=?,mobile=?,photo=?,gender=? where username=?";
//		Object[] data = { profileEntity.getPassword(), profileEntity.getName(), profileEntity.getEmail(),
//				profileEntity.getQualification(), profileEntity.getMobile(), profileEntity.getPhoto(),
//				profileEntity.getGender(), profileEntity.getUsername() };
//		i = jdbcTemplate.update(sql, data);
//
//		return i;
//	}
//
//	@Override
//	public ProfileEntity srchUser(String pemail) {
//		ProfileEntity profileEntity = null;
//		String sql = "select username,password,name,email,qualification,mobile,photo,gender,createddate from user_login_tbl where email=?";
//		String[] user = { pemail };
//		List<ProfileEntity> users = jdbcTemplate.query(sql, user, new BeanPropertyRowMapper<>(ProfileEntity.class));
//		if (users.size() != 0) {
//			profileEntity = users.get(0);
//		}
//		return profileEntity;
//
//	}
//@Override
//	public int registerNew(ProfileEntity profileEntity) {
//		int i = 0;
//		byte[] image = null;
//		try {
//			image = profileEntity.getImage().getBytes();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		LobHandler lobHandler = new DefaultLobHandler();
//		SqlLobValue sqlLobValue = new SqlLobValue(image, lobHandler);
//		String sql = "insert into user_login_tbl1(username,password,name,email,qualification,mobile,photo,gender,createddate) values(?,?,?,?,?,?,?,?,?)";
//		Timestamp createddate = new Timestamp(System.currentTimeMillis());
//		Object[] data = { profileEntity.getUsername(), profileEntity.getPassword(), profileEntity.getName(),
//				profileEntity.getEmail(), profileEntity.getQualification(), profileEntity.getMobile(), sqlLobValue,
//				profileEntity.getGender(), createddate };
//		int[] dataType = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
//				Types.VARCHAR, Types.BLOB, Types.VARCHAR, Types.TIMESTAMP };
//
//		i = jdbcTemplate.update(sql, data, dataType);
//		return i;
//
//	}
//
//	@Override
//	public byte[] srchUserForImage(String username) {
//
//		String sql = "select photo from user_login_tbl1 where username=?";
//		String[] user = { username };
//		byte[] photo = jdbcTemplate.queryForObject(sql, user, byte[].class);
//
//		return photo;
//
//	}
//
//	@Override
//	public ArrayList<ProfileEntity> findAllWithPhoto() {
//		List<ProfileEntity> users = new ArrayList<ProfileEntity>();
//		String sql = "select username,password,name,email,qualification,mobile,gender,createddate from user_login_tbl1";
//		users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProfileEntity.class));
//		return (ArrayList<ProfileEntity>) users;
//	}
//
//	@Override
//	public int changeImage(String username, MultipartFile file) {
//		int i = 0;
//		byte[] photo = null;
//		try {
//			photo = file.getBytes();
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		LobHandler lobHandler = new DefaultLobHandler();
//		SqlLobValue sqlLobValue = new SqlLobValue(photo, lobHandler);
//		// System.out.println(Arrays.toString(photo));
//		String sql = "update user_login_tbl1 set photo=? where username=?";
//		Object[] data = { sqlLobValue, username };
//		int[] dataType = { Types.BLOB, Types.VARCHAR };
//		i = jdbcTemplate.update(sql, data, dataType);
//		return i;
//	}
//
//	@Override
//	public ArrayList<ProfileEntity> profileWithPage(int num) {
//		List<ProfileEntity> users = new ArrayList<ProfileEntity>();
//		int start = (num - 1) * 3;
//
//		// System.out.println(num+"start "+start+"end"+end);
//		String sql = "select username,password,name,email,qualification,mobile,photo,gender,createddate from user_login_tbl limit "
//				+ start + "," + 3;
//		users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProfileEntity.class));
//		return (ArrayList<ProfileEntity>) users;
//	}
//
//	@Override
//	public Double totalData() {
//		String sql = "select count(*) from user_login_tbl1";
//		Double i = jdbcTemplate.queryForObject(sql, Double.class);
//		return i;
//	}
//
//}
