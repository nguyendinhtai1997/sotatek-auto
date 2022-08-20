package common.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.thucydides.core.steps.StepEventBus;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Common {
    public static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    public static final Logger logger = LoggerFactory.getLogger(Common.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static final Gson gsonWithDateFormat(String dateFormat) {
        return new GsonBuilder().setDateFormat(dateFormat).create();
    }

    public static Object findObjectInListByKey(Object objectRefer, List<?> listObject, Object key, Class<?> clazz) {
        try {
            Map mapRefer = mapper.convertValue(objectRefer, Map.class);
            for (Object object : listObject) {
                Map mapObject = mapper.convertValue(object, Map.class);
                if (Objects.equals(mapObject.get(key), mapRefer.get(key))) {
                    return object;
                }
            }
            return clazz.newInstance();
        } catch (Exception e) {
            return clazz;
        }
    }

    public static void setLogger(Object expect, Object actual) {
        logger.info("actual: {}", actual);
        logger.info("expect: {}", expect);
    }

    public static String parseObjectToJson(Object object) {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void getListParam(Map<String, Object> request, String params) {
        if (StringUtils.isNotBlank(params)) {
            String[] listParam = params.split("\\?")[1].split("&");
            for (String param : listParam) {
                request.put(param.split("=")[0], param.split("=")[1]);
            }
        }
    }

    public static Map<String, Object> convertStringToMap(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, Map.class);
        } catch (Exception e) {
            return new HashMap<>();
        }
    }

    public static void failTest(String description) {
        StepEventBus.getEventBus().testFailed(new AssertionError(description));
    }
}
