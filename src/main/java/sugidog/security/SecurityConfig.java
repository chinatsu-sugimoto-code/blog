package sugidog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//UserDetailsServiceを利用出来るように＠Autowiredしておく
	@Autowired
	UserDetailsService userDetailsService;

	//パスワードハッシュ化する実装を@Bean登録

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * アクセス制御
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				//ログイン画面とユーザー登録画面は誰でもアクセス可能
				.antMatchers("/user/login", "/user/register").permitAll()
				//それ以外は認証必要
				.anyRequest().authenticated();
		http
				.formLogin()
				.usernameParameter("email")
				.passwordParameter("password")
				.loginPage("/user/login")
				.loginProcessingUrl("/login")
				.failureUrl("/usre/login?error=1")
				.defaultSuccessUrl("/user/home", true);
		http.logout().logoutSuccessUrl("/user/login").permitAll();

	}

	/**
	 * ユーザ情報の取得
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder());

	}

}
