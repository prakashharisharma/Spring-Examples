package com.td.sb.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.td.sb.resource.EmployeeResource;

@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {

		/*
		 * Jersey will automatically register class with @provider, @Component by
		 * scanning these packages + nested packages
		 */
		packages("com.td.sb.resources", "com.td.sb.config");

		/* CustomTypeParamterConsumeResource auto scanned and register */
		// register(CustomTypeParamterConsumeResource.class);
		register(EmployeeResource.class);

	}
}
