package my.utm.ip.lowcarbon.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
 
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.jdbcAuthentication().dataSource(dataSource)
	            .usersByUsernameQuery("SELECT email, password, 1 FROM users WHERE email=?")
	            .authoritiesByUsernameQuery("SELECT email, role FROM users WHERE email=?")
	            .passwordEncoder(new BCryptPasswordEncoder());
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(requests -> requests
                        .antMatchers("/logout").permitAll()
                        .antMatchers("/registration", "/css/**", "/js/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
                        .permitAll())
                .logout(logout -> logout
                    .logoutUrl("/logout") 
                    .logoutSuccessUrl("/login?logout") 
                    .permitAll());
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
