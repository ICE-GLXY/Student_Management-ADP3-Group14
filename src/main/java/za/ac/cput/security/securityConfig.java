package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter
{
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("AdminA")
                .password(passwordEncoder().encode("0000"))
                .roles("ADMIN","USER");
        auth.inMemoryAuthentication()
                .withUser("clientA")
                .password(passwordEncoder().encode("1234"))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable();
        http.authorizeRequests()

                //User Authentication
                .antMatchers(HttpMethod.POST, "/Student_Management-ADP3-Group14/user/save_user").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/Student_Management-ADP3-Group14/user/update_user").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/Student_Management-ADP3-Group14/user/readUser/").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/Student_Management-ADP3-Group14/user/deleteUser/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/Student_Management-ADP3-Group14/user/readAllUsers").hasRole("USER")

                .and()
                .formLogin().disable()
                .httpBasic();

    }


}
