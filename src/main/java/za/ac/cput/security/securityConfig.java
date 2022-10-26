package za.ac.cput.security;
/*
*
*
 * Abdul Aleem Chilwan - 220108447 - Added security for Parent and School
 * ADP3 - Final Capstone
 * Security - SecurityConfig.java
 * October 2022
 */

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
        
                //Parent Authentication
                .antMatchers(HttpMethod.POST, "/Student_Management-ADP3-Group14/parent/save_parent").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/Student_Management-ADP3-Group14/parent/update_parent").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/Student_Management-ADP3-Group14/parent/readParent/").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/Student_Management-ADP3-Group14/parent/deleteParent/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/Student_Management-ADP3-Group14/parent/readAllParent").hasRole("USER")
        
                //School Authentication
                .antMatchers(HttpMethod.POST, "/Student_Management-ADP3-Group14/school/save_school").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/Student_Management-ADP3-Group14/school/update_school").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/Student_Management-ADP3-Group14/school/readSchool/").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/Student_Management-ADP3-Group14/school/deleteSchool/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/Student_Management-ADP3-Group14/school/readAllSchools").hasRole("USER")

                //Login_Authentication

                //Register Authentication

                .and()
                .formLogin().disable()
                .httpBasic();

    }


}
