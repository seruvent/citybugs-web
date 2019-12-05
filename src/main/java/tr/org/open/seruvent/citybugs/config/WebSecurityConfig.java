package tr.org.open.seruvent.citybugs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tr.org.open.seruvent.citybugs.service.UserService;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder passwoedEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/admin/*").hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST, "/api/**").permitAll()
                    .antMatchers(HttpMethod.PUT, "/api/**").permitAll()
                    .antMatchers(HttpMethod.DELETE, "/api/**").permitAll()
                    .antMatchers(HttpMethod.GET, "/api/**").permitAll()
                    .antMatchers(HttpMethod.GET , "/").permitAll()
                    .and()
                .formLogin();

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
            auth.inMemoryAuthentication()
                .withUser("seruvent").password(passwordEncoder.encode("seruvent")).roles("ADMIN")
                .and()
                .withUser("guppy").password(passwordEncoder.encode("guppy")).roles("USER");
        */


        /**
         * userDetailsService kullanımında custom bir user tablosu üzerinden işlem yapılabilir
         * önemli olan UserService class'ının UserDetailsService class'ını implement etmesidir
         * UserDetailsService implement edildikten sonra loadUserByUsername methodunda kullanıcı
         * adı, password ve role tanımlanım
         */
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

}
