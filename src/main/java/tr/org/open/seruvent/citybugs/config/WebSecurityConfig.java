package tr.org.open.seruvent.citybugs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import tr.org.open.seruvent.citybugs.filter.JwtRequestFilter;
import tr.org.open.seruvent.citybugs.service.UserService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{

        /**
         * httpBasic -> basic authentication ile postman üzerinden request atılmasını sağlar
         */

        httpSecurity
                .sessionManagement()
                    .and()
                .authorizeRequests()
                    .antMatchers("/admin/*").hasRole("ADMIN")
                    .antMatchers("/api/login").permitAll()
                    .antMatchers(HttpMethod.POST,"/api/authenticate").permitAll()
                    .antMatchers(HttpMethod.POST, "/api/**").permitAll()
                    .antMatchers(HttpMethod.PUT, "/api/**").permitAll()
                    .antMatchers(HttpMethod.DELETE, "/api/**").permitAll()
                    .antMatchers(HttpMethod.GET, "/api/**").permitAll()
                    .antMatchers(HttpMethod.GET , "/").permitAll()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/perform_login")
                    .and()
                .httpBasic()
                    .and()
                .csrf().disable();


        // Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * inMemoryAuthentication kullanımında kullanıcı adı ve şifresi direk yazılması için
         * PasswordEncoder Bean'ı return NoOpPasswordEncoder.getInstance() kullanmalıdır
         *
         * Eğer şifrenin encoded hali kullanılacak ise password değeri encode edilmelidir
         *
         */

        /**
            util.inMemoryAuthentication()
                .withUser("seruvent").password(passwordEncoder.encode("seruvent")).roles("ADMIN")
                .and()
                .withUser("seruvent").password(passwordEncoder.encode("seruvent")).roles("USER");
        */


        /**
         * userDetailsService kullanımında custom bir user tablosu üzerinden işlem yapılabilir
         * önemli olan UserService class'ının UserDetailsService class'ını implement etmesidir
         * UserDetailsService implement edildikten sonra loadUserByUsername methodunda kullanıcı
         * adı, password ve role tanımlanım
         */
        auth.parentAuthenticationManager(authenticationManagerBean())
                .userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

}
