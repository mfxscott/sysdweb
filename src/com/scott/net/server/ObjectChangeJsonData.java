package com.scott.net.server;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
/**
 * json和实体类相互转换
 * @author scott
 *
 */
public class ObjectChangeJsonData {
	 /**
     * 将json转化为实体POJO
     * @param jsonStr
     * @param obj
     * @return
     */
    public static<T> Object JSONToObj(String jsonStr,Class<T> obj) {
        T t = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            t = objectMapper.readValue(jsonStr,
                    obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
    /**
     * 将实体POJO转化为JSON
     * @param obj
     * @return
     * @throws JSONException
     * @throws IOException
     */
    public static<T> String objectToJson(T obj) throws JSONException, IOException {
        ObjectMapper mapper = new ObjectMapper();  
        // Convert object to JSON string  
        String jsonStr = "";
        try {
             jsonStr =  mapper.writeValueAsString(obj);
        } catch (IOException e) {
            throw e;
        }
//        String jsonStr = new JSONObject(jsonStr).toString();
        return jsonStr;
    }
    /**
     * 将实体POJO转化为JSON
     * @param obj
     * @return
     * @throws JSONException
     * @throws IOException
     */
//    public static<T> String objectToJson(T obj) throws JSONException, IOException {
//        ObjectMapper mapper = new ObjectMapper();  
//        // Convert object to JSON string  
//        String jsonStr = "";
//        try {
//             jsonStr =  mapper.writeValueAsString(obj);
//        } catch (IOException e) {
//            throw e;
//        }
////        String jsonStr = new JSONObject(jsonStr).toString();
//        return jsonStr;
//    }
}
