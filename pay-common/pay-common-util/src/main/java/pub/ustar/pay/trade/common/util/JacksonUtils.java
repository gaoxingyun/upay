package pub.ustar.pay.trade.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.util.Map;

/**
 * Jackson Utils
 *
 * @author xy
 */
public class JacksonUtils {

    /**
     * json to bean.
     */
    public static <T> T jsonToBean(String str, Class<T> cls) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(str, cls);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * bean to json.
     */
    public static <T> String beanToJson(T bean) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(bean);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    /**
     * xml to bean.
     */
    public static <T> T xmlToBean(String str, Class<T> cls) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return xmlMapper.readValue(str, cls);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * Bean to xml.
     */
    public static <T> String beanToXml(T bean) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.writeValueAsString(bean);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * map to Bean.
     */
    public static <T> T mapToBean(Map<String, Object> map, Class<T> cls) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.convertValue(map, cls);
    }

    /**
     * Bean to map.
     */
    public static <T> Map beanToMap(T bean) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(bean, Map.class);
    }


}
