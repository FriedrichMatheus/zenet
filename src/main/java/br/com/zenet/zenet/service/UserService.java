package br.com.zenet.zenet.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.zenet.zenet.entity.UserEntity;
import br.com.zenet.zenet.exception.NotFoundException;
import br.com.zenet.zenet.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;	
	}
	
	@Transactional(readOnly = true)
	public UserEntity getUserByLogin(String login) throws NotFoundException {
//		Optional<UserEntity> userEntity = userRepository.findByLogin(login);
//		return userEntity.orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));
		return null;
	}

	
	
}
