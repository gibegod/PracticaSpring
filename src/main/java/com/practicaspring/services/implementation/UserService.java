package com.practicaspring.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practicaspring.entities.UserRole;
import com.practicaspring.repositories.IUserRepository;


//Conectar el Repository con los Controllers necesarios.
//No se genera una interfaz pq se usa una existente de Spring Security

@Service("userService")
public class UserService implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private IUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.practicaspring.entities.User user = userRepository.findByUsernameAndFetchUserRolesEagerly(username);
		return buildUser(user, buildGrantedAuthorities(user.getUserRoles()));
	}
	
	public User buildUser(com.practicaspring.entities.User user, List<GrantedAuthority> grantedAuthorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), 
						true, true, true, //accountNonExpired, credentialsNonExpired, accountNonLocked,
						grantedAuthorities);
	}
	
	private List<GrantedAuthority> buildGrantedAuthorities(Set<UserRole> userRoles) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		for(UserRole userRole : userRoles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}
	
	
}
