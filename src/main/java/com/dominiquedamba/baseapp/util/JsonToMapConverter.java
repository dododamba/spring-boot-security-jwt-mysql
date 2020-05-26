/**
 * 
 */
package com.dominiquedamba.baseapp.util;

import java.util.Map;
import java.io.IOException;
import java.util.*;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author DOMINIQUE DAMBA
 *
 */
@Converter
public class JsonToMapConverter implements AttributeConverter<String, Map<String, Object>> {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonToMapConverter.class);

	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Object> convertToDatabaseColumn(String attribute) {
		if (attribute == null) {
			return new HashMap<>();
		}
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.readValue(attribute, HashMap.class);
		} catch (IOException e) {
			LOGGER.error("Convert error while trying to convert string(JSON) to map data structure.");
		}
		return new HashMap<>();
	}

	@Override
	public String convertToEntityAttribute(Map<String, Object> dbData) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(dbData);
		} catch (JsonProcessingException je) {
			LOGGER.error("Could not convert map to json string." + je);
			return null;
		}
	}
}