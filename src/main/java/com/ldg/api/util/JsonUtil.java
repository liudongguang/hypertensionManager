package com.ldg.api.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
	public static ObjectMapper objectMapper = new ObjectMapper();

	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

	static {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * 对象转json字符串
	 * 
	 * @param obj
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String parseToJson(Object obj) throws JsonProcessingException {
		return objectMapper.writeValueAsString(obj);
	}

	/**
	 * json字符串 转 list对象
	 * 
	 * @param source
	 * @param clazz
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> List<T> getListByString(String source, Class<T> clazz)
			throws IOException {
		ObjectMapper jacksonMapper = new ObjectMapper();
		JavaType javaType = getCollectionType(ArrayList.class, clazz);
		List<T> lst = jacksonMapper.readValue(source, javaType);
		return lst;
	}

	/**
	 * 字符串转java对象
	 * 
	 * @param jsonSource
	 * @param clazz
	 * @return
	 */
	public static <T> T getObjectByJSON(String jsonSource, Class<T> clazz) {
		T t = null;
		try {
			t = objectMapper.readValue(jsonSource, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return t;
	}

	public static void main(String[] args) throws IOException {
		String jsonStr = "[{\"id\":\"1\",\"values\":[\"1\",\"2\"]},{\"id\":\"2\",\"values\":[\"11\",\"22\"]}]";
		// JavaType javaType = getCollectionType(ArrayList.class,
		// JsonArrayToList.class);
		// List<JsonArrayToList> list = objectMapper.readValue(jsonStr,
		// javaType);
		// for (JsonArrayToList jatl : list) {
		// System.out.println(jatl.toString());
		// }
	}
}
