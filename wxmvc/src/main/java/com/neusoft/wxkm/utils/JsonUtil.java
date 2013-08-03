package com.neusoft.wxkm.utils;


import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


/**
 * Json通用类,使用Jackson来实现.
 * @author Baishuang
 *
 */
public class JsonUtil {

	protected final static Log log = LogFactory.getLog(JsonUtil.class);

	/**
	 * 
	 * @param obj 要转json的对象
	 * @return JSON 串
	 */
	public static String getJson(Object obj) {
		ObjectMapper mapper = new ObjectMapper(); 
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			log.error(e);
		} catch (JsonMappingException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
		return "";
	}
	
	/**
	 * 通过JSON串得到对象
	 * @param jsonStr json对象
	 * @param clazz 返回对象的类型
	 * @return 得到的json的对象
	 */
	public static <T> T getObject(String jsonStr,Class<T> clazz)
	{
		if(StringUtils.isBlank(jsonStr)){
			return null;
		}
		ObjectMapper mapper = new ObjectMapper(); 
		try {
			return mapper.readValue(jsonStr, clazz);
		} catch (JsonParseException e) {
			log.error(e);
		} catch (JsonMappingException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
		return null;
	}
	
	/**
     * 通过JSON串得到对象
     * @param jsonStr json对象
     * @param clazz 返回对象的类型
     * @return 得到的json的对象
     */
    public static Object getObject2(String jsonStr,Class clazz)
    {
        if(StringUtils.isBlank(jsonStr)){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper(); 
        try {
            return mapper.readValue(jsonStr, clazz);
        } catch (JsonParseException e) {
            log.error(e);
        } catch (JsonMappingException e) {
            log.error(e);
        } catch (IOException e) {
            log.error(e);
        }
        return null;
    }
    

}

