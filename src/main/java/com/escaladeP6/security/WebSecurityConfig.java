package com.escaladeP6.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// classe de configurationb générale de la sécurité


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        //pages qui n'ont pas besoin d'authentification
        http.authorizeRequests().antMatchers("/", "/login", "/signUp").permitAll();

        //si pas de login, redirection de ces pages :
        http.authorizeRequests().antMatchers("/topoGerer", "/topoConsulter", "/topoConsulter/fichiers", "/topoHome", "/topoEditer", "/topoDetails", "/topoEmprunter", "/empruntConsulter", "/topoVoiesDetails").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

        // page réservée à l'admin
        http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");

        //accès refusé pour problème de rôle ==> erreur 403
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        //configuration du login de form
        http.authorizeRequests().and().formLogin()
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/login")
                .defaultSuccessUrl("/topoHome")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/?logout=true");

    }

}
