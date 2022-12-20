//package sugidog.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import sugidog.Service.UserService;
//
//
//
//@SuppressWarnings("deprecation")
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	//UserDetailsServiceを利用出来るように＠Autowiredしておく
//    @Autowired
//    private UserService userDetailsService;
//
//	/**
//	 * 認証・認可の情報を設定する
//	 */
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()//認証が必要となるURLを設定
//				.antMatchers("/login", "/general/**", "/css/**").permitAll()
//				.anyRequest().authenticated()//それ以外は認証必要
//				.and()
//				.formLogin()//ログインページに飛ばす
//				.loginProcessingUrl("/login")
//				.loginPage("/login")
//				.usernameParameter("username")
//				.passwordParameter("password");
//	}
//
//	/**
//	 * ユーザ情報の取得
//	 */
//		@Autowired
//		public void configure(AuthenticationManagerBuilder auth) throws Exception {
//			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//		}
//
//	// パスワードハッシュ化する
//	public BCryptPasswordEncoder passwordEncoder() {
//		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
//		return bcpe;
//	}
//}
