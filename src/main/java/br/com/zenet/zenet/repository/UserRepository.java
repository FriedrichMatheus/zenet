package br.com.zenet.zenet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.zenet.zenet.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

//	@Query("select t1 from user_account t1 where t1.login = :login")
//	public Optional<UserEntity> findByLogin(String login);
	
}
