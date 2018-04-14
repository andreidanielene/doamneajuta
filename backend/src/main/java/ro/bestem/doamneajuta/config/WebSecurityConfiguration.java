package ro.bestem.doamneajuta.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * Created by Andrei-Daniel Ene on 4/14/2018.
 */
@EnableOAuth2Client
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                    .disable()
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/**"/*,"/register","/login","/home_logout"*/)
                    .permitAll()
                .anyRequest()
                    .authenticated();
    }
}
