package org.mitre.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;

// We do not want to inject this automatically. Please import this manually if needed
// The automatic creation adds another security chain and might cause problems
//@Order(700)
//@Configuration
public class CommonWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired 
	private OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler;
	
	@Override
	public void configure(WebSecurity web) {
		web.expressionHandler(oAuth2WebSecurityExpressionHandler);
	}
	
	@Bean(name = "org.springframework.security.authenticationManager")
	public AuthenticationManager authenticationManagerBean()
			throws Exception {
		return super.authenticationManagerBean();
	}

}
