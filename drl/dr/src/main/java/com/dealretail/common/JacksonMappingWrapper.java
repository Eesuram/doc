package com.dealretail.common;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

public class JacksonMappingWrapper extends MappingJacksonHttpMessageConverter {
	
	public JacksonMappingWrapper() {
        super();
        this.getObjectMapper().configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        this.getObjectMapper().configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

}
