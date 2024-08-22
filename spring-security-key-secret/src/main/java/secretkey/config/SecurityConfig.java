package secretkey.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import secretkey.filter.ApiKeyAuthFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private ApiKeyAuthFilter apiKeyAuthFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // Disabling CSRF protection
				.addFilterBefore(apiKeyAuthFilter, UsernamePasswordAuthenticationFilter.class) // Add our custom filter
				.authorizeRequests(requests -> requests.anyRequest().authenticated());
	}
	/* THIS OLD WAY OF writing the code
	   protected void configure1(HttpSecurity http) throws Exception {
	        http.csrf().disable() // Disabling CSRF protection
	            .addFilterBefore(apiKeyAuthFilter, UsernamePasswordAuthenticationFilter.class) // Add our custom filter
	            .authorizeRequests()
	            .anyRequest().authenticated(); // All requests must be authenticated
	    }
	    
	 */
}