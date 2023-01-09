package com.example.restservice.auth;
 
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.restservice.services.UserService;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

	@Autowired
	private TokenManager tokenManager;
	@Autowired
	private UserService userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authHeader = request.getHeader("Authorization");
		String username = null;
		String token = null;
		if (authHeader != null && authHeader.contains("Bearer")) {
			token = authHeader.substring(7);
			try {
				username = tokenManager.getUsernameFromToken(token);
				
				if(tokenManager.isTokenExpired(token)) {
					throw new ServletException("Token has expired");
				}
				
				var ud = userService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						ud, null, ud.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the
				// Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				/*
				
				UsernamePasswordAuthenticationToken upassToken = new UsernamePasswordAuthenticationToken(username,
						new ArrayList<>());
				upassToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(upassToken);
				*/
			} catch (Exception e) {
				System.out.println("Could not extract username from token");
				System.out.println(e.getMessage());
			}
		}
		filterChain.doFilter(request, response);
	}
}

