package com.example.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.user.User;
import com.example.user.UserService;

import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("jwtfilter");
		final String authorisationHeader = request.getHeader("Authorization");
		System.out.println("");
		
		String username =null;
		String jwt =null;
		
		if(authorisationHeader != null) {
			jwt = authorisationHeader.substring(7);
			username = jwtUtil.getUsernameFromToken(jwt);
			System.out.println("jwtfilterusername"+username);
		}
		
		if ((username != null) && SecurityContextHolder.getContext().getAuthentication()==null) {
			User userDetails = userService.getUserByUsername(username);
			System.out.println(userDetails);
			if (jwtUtil.validateToken(jwt, userDetails));{
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
