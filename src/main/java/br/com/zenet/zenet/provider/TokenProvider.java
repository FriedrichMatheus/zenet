package br.com.zenet.zenet.provider;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.zenet.zenet.entity.UserEntity;

@Service
public class TokenProvider {

	@Value("${security.jwt.token.secret-key}")
	private String JWT_SECRET;


	public String generateAccessToken(UserEntity user) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);

			return JWT.create()
					.withSubject(user.getLogin())
					.withClaim("username", user.getLogin())
					.withExpiresAt(genAccessExpirationDate())
					.sign(algorithm);

		} catch (Exception e) {
			throw new JWTCreationException("Erro ao gerar token de acesso!", e);
		}
	}

	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
			return JWT.require(algorithm)
					.build()
					.verify(token)
					.getSubject();
		} catch (JWTVerificationException exception) {
			throw new JWTVerificationException("Erro ao validar token de acesso!", exception);
		}
	}


	private Instant genAccessExpirationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}

}
