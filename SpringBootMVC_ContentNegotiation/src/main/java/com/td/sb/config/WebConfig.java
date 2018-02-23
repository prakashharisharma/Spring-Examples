package com.td.sb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * Setup a simple strategy: use all the defaults and return XML by default when
	 * not sure.
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		/*configurer.favorPathExtension(false).
        favorParameter(true).
        parameterName("mediaType").
        ignoreAcceptHeader(true).
        useJaf(false).
        defaultContentType(MediaType.TEXT_HTML).
        mediaType("xml", MediaType.APPLICATION_XML).
        mediaType("json", MediaType.APPLICATION_JSON);*/
		
		// Simple strategy: only path extension is taken into account
				configurer.favorPathExtension(true).
					ignoreAcceptHeader(true).
					useJaf(false).
					defaultContentType(MediaType.TEXT_HTML).
					mediaType("html", MediaType.TEXT_HTML).
					mediaType("xml", MediaType.APPLICATION_XML).
					mediaType("json", MediaType.APPLICATION_JSON);
	}
	
	@Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setViewClass(JstlView.class);
	    bean.setPrefix("/WEB-INF/view/");
	    bean.setSuffix(".jsp");
	    return bean;
	}
}
