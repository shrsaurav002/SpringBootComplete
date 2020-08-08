package com.customer.dbDao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.customer.controller.entity.ProfileEntity;

public interface SpringDataJPA extends JpaRepository<ProfileEntity, String> {
	ProfileEntity findByUsernameOrEmail(String username, String email);

	Optional<ProfileEntity> findByEmail(String email);

	Optional<ProfileEntity> findByUsernameAndPassword(String username, String password);

	public List<ProfileEntity> findAllByOrderByEmailAsc();

	public List<ProfileEntity> findAllByOrderByEmailDesc();

	@Query("Select distinct p.qualification FROM ProfileEntity p ")
	public List<String> findMyQualification();

	@Query("Select p FROM ProfileEntity p where p.qualification =?1")
	public List<ProfileEntity> filter(String search);
	@Query("select p from ProfileEntity p where p.name like ?1 Or p.qualification like ?2")
	public List<ProfileEntity> search(String search,String search1);
}
