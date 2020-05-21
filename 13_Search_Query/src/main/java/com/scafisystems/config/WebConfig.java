package com.scafisystems.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.scafisystems.converters.YamlJacksonConverter;


@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	
	  private static final MediaType MEDIA_TYPE_YML =
	  MediaType.valueOf("application/x-yaml");
	  
	  public void extendMessageConverters(List<HttpMessageConverter<?>> converters)
	  { converters.add(new YamlJacksonConverter());
	  
	 }
	  
	
	  public void addCorsMappings(CorsRegistry registry) {
	  registry.addMapping("/**") .allowedMethods("GET", "POST", "PUT", "PATCH",
	  "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
	 }
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer ) {
		
		//first way
		// Via EXTENSION. localhost:8080/person.x-yaml
		
		  configurer.favorParameter(false)
		  .ignoreAcceptHeader(false)
		  .defaultContentType(MediaType.APPLICATION_JSON)
		  .mediaType("json", MediaType.APPLICATION_JSON)
		  .mediaType("xml", MediaType.APPLICATION_XML)
		  .mediaType("x-yaml", MEDIA_TYPE_YML);
		 
		 
		
		//Second way
		// Via QUERY PARAM. localhost:8080/person?mediaType=xml 
		
		/*
		 * configurer.favorPathExtension(false) .favorParameter(true)
		 * .parameterName("mediaType") .ignoreAcceptHeader(true)
		 * .useRegisteredExtensionsOnly(false)
		 * .defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json",
		 * MediaType.APPLICATION_JSON) .mediaType("xml", MediaType.APPLICATION_XML)
		 * .mediaType("x-yaml", MEDIA_TYPE_YML);
		 */
		 
		 
		
		//Third way
		// Via HEADER. Accept / application/x-yaml
		
		/*
		 * configurer.favorPathExtension(false) .favorParameter(false)
		 * .ignoreAcceptHeader(false) .useRegisteredExtensionsOnly(false)
		 * .defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json",
		 * MediaType.APPLICATION_JSON) .mediaType("xml", MediaType.APPLICATION_XML)
		 * .mediaType("x-yaml", MEDIA_TYPE_YML);
		 */
		 
		 
	}

}
