package com.td.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.td.sb.config.ErrorFilter;
import com.td.sb.config.PostFilter;
import com.td.sb.config.PreFilter;
import com.td.sb.config.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
public class StartApplication {

	public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
 
    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }
}
