package com.scafisystems.converters;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public final class YamlJacksonConverter extends AbstractJackson2HttpMessageConverter{

	public YamlJacksonConverter() {
		super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
	}

}
