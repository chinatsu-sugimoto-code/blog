package sugidog.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sugidog.entity.User;
import sugidog.repository.UserRepository;

@Service
public class DefaultUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository
				.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("user not found"));

		Collection<GrantedAuthority> authority = Arrays.stream(user.getRoles().split(","))
				.map((role) -> new SimpleGrantedAuthority(role))
				.collect(Collectors.toList());

		return new org.springframework.security.core.userdetails.User(
				user.getEmail(),
				user.getPassword(),
				authority);
	}

}
