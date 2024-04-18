package br.com.zenet.zenet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "user_account")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "user_login")
	private String login;
	
	@Column(name = "user_password")
	private String password;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_pers_id")
	private PersonEntity person;
}
