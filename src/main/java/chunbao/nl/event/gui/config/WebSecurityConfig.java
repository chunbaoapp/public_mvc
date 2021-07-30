package chunbao.nl.event.gui.config;

import chunbao.nl.event.gui.auth.MyInMemoryUserDetailsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired MyInMemoryUserDetailsManager myInMemoryUserDetailsManager;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/", "/home")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .and()
        .logout()
        .permitAll();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(myInMemoryUserDetailsManager);
  }

  // this is important!!!
  // https://stackoverflow.com/questions/25869260/how-can-i-add-users-to-the-inmemoryauthentication-builder-after-it-has-been-buil
  // https://spring.io/guides/gs/securing-web/
  /*  @Bean
  public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
    final Properties users = new Properties();
    return new InMemoryUserDetailsManager(users);
  }*/
}
