package com.ruanzz.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ruanzz
 * @date 2018/12/16
 * @description JSON 工具类
 */
@Slf4j
public class JsonUtil {

  private static final ObjectMapper mapper = new ObjectMapper();

  /**
   * 对象转换过JSON字符串
   */
  public static String toJSON(Object object) {
    if (object == null) {
      return null;
    }
    if (object.getClass() == String.class) {
      return (String) object;
    }
    try {
      return mapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      log.error("json序列化对象{}出错", object, e);
    }
    return null;
  }

  /**
   * JSON字符串反序列化
   */
  public static <T> T toBean(String jsonStr, Class<T> clazz) {
    try {
      return mapper.readValue(jsonStr, clazz);
    } catch (IOException e) {
      log.error("json解析[{}]出错", jsonStr, e);
    }
    return null;
  }

  /**
   * JSON字符串转换成List
   */
  public static <E> List<E> toList(String jsonStr, Class<E> clazz) {
    try {
      return mapper
          .readValue(jsonStr, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
    } catch (IOException e) {
      log.error("json序列化成数组出错", e);
    }
    return null;
  }

  /**
   * JSON字符串转换成Map
   */
  public static <K, V> Map<K, V> toMap(String jsonStr, Class<K> kClass, Class<V> vClass) {
    try {
      return mapper
          .readValue(jsonStr, mapper.getTypeFactory().constructMapType(Map.class, kClass, vClass));
    } catch (IOException e) {
      log.error("json序列化Map出错", e);
    }
    return null;
  }

  /**
   * Jackson 原生反序列化
   */
  public static <T> T readValue(String jsonStr, TypeReference<T> typeReference) {
    try {
      return mapper.readValue(jsonStr, typeReference);
    } catch (IOException e) {
      log.error("json反序列化出错", e);
    }
    return null;
  }

}
