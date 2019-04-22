package org.ebullq.config;

import org.ebullq.service.UserDetailsServiceImpl;
import org.ebullq.util.AuthProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan("org.ebullq")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthProviderImpl authProvider;

    @Autowired
    UserDetailsServiceImpl detailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/login","/registration").anonymous()
                .antMatchers("/").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .and().csrf().disable()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login/?error=true")
                .usernameParameter("login")
                .and().exceptionHandling().accessDeniedPage("/denied")
                .and().logout().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.authenticationProvider();
        auth.userDetailsService(detailsService);
    }
}
