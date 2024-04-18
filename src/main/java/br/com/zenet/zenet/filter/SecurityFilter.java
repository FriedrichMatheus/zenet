package br.com.zenet.zenet.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.zenet.zenet.provider.TokenProvider;
import br.com.zenet.zenet.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	TokenProvider tokenService;

	@Autowired
	UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//		String token = this.recoverToken(request);
//		if (token != null) {
//			String login = tokenService.validateToken(token);
//			UserEntity user = null;
//			try {
//				user = userService.getUserByLogin(login);
//			} catch (NotFoundException e) {
//				e.printStackTrace();
//			}
//			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, null);
//			SecurityContextHolder.getContext().setAuthentication(authentication);
//		}	
		filterChain.doFilter(request, response);
	}

	private String recoverToken(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		if (authHeader == null)
			return null;
		return authHeader.replace("Bearer ", "");
	}
}
