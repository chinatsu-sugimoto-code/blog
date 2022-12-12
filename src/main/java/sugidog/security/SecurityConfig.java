package sugidog.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SpringSecurityを利用するための設定クラス
 * ログイン処理でのパラメータ、画面遷移や認証処理でのデータアクセス先を設定する
 */
@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * 認可設定を無視するリクエストを設定
	 * 静的リソース(image,javascript,css)を認可処理の対象から除外する
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers("/resources/**");
		/**
		* その他の例
		* .antMatchers("/images/**")
		* .antMatchers("/css/**")
		* .antMatchers("/javascript/**")
		* .antMatchers("/js/**")
		*　,で繋げて連続で書くことも可能
		*　.antMatchers("/images/**","/css/**");
		*/
	}

	/**
	 * 認証・認可の情報を設定する
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/login").permitAll()
				.anyRequest().authenticated();

		http.formLogin()
				.defaultSuccessUrl("/sample")
				.usernameParameter("username")
				.passwordParameter("password")
				.defaultSuccessUrl("/sample", true)
				.failureUrl("/eroor")
				.permitAll();
	}
    /**
     * 認証時に利用するデータソースを定義する設定メソッド
     * ここではDBから取得したユーザ情報をuserDetailsServiceへセットすることで認証時の比較情報としている
     */
//    @Autowired
//    public void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }

}
