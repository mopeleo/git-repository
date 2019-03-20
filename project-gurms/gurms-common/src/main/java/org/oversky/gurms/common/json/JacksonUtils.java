package org.oversky.gurms.common.json;

import java.io.IOException;
import java.util.Map;

import org.oversky.base.exception.BaseUtilException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtils {
	
	private static ObjectMapper MAPPER = new ObjectMapper();

	private JacksonUtils() {}
	
	public static String bean2Json(Object obj) {
		try {
			return MAPPER.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BaseUtilException("java对象转json字符串失败:" + e.getMessage());
		}
	}
	
	public static String bean2JsonIgnoreNull(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BaseUtilException("java对象转json字符串失败:" + e.getMessage());
		}
    }

	public static <T> T json2Bean(String jsonString, Class<T> objClass) {
		try {
			return MAPPER.readValue(jsonString, objClass);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BaseUtilException("json字符串转java对象失败:" + e.getMessage());
		}
	}
	
	public static Map<String, String> json2Map(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
			return (Map<String, String>)mapper.readValue(jsonString, Map.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BaseUtilException("json字符串转map对象失败:" + e.getMessage());
		}
    }
	
	//查找第一级的key属性,如果属性不存在,则返回null
	public static String getValue(String key, String jsonString) {
		JsonNode rootNode = null;
		try {
			rootNode = MAPPER.readTree(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BaseUtilException("解析json字符串失败:" + e.getMessage());
		}
		JsonNode query = rootNode.findValue(key);
		return query == null ? null:query.asText();
	}
}
