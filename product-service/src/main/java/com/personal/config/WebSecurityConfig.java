package com.personal.config;

import com.microsoft.azure.spring.autoconfigure.b2c.AADB2COidcLoginConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(WebSecurityConfig.class);

    private final AADB2COidcLoginConfigurer configurer;

    @Autowired
    private CorsConfigurationSource corsConfiguration;

    public WebSecurityConfig(AADB2COidcLoginConfigurer configurer) {
        this.configurer = configurer;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOG.info("START: Configure Azure AD B2C Websecurity");
        http
                .authorizeRequests()
                .antMatchers("/doc/**").hasAnyRole()
                .and()
                .sessionManagement().invalidSessionStrategy(((request, response) -> response.sendRedirect("/doc/login")))
                .and()
                .cors().configurationSource(corsConfiguration)
                .and()
                .apply(configurer);
        LOG.info("END: Configure Azure AD B2C Websecurity");
    }

}
