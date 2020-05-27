package plus.knowing.kmall.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.Map;

public enum  JsonUtils {
    ;

    private static final ObjectMapper objectMapper;

    static {
        Jackson2ObjectMapperBuilder builder = Jackson2ObjectMapperBuilder.json();
        builder
                .simpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS") // 格式化日期
                .timeZone("GMT+8") // 设置时区
                .failOnUnknownProperties(false) // 位置属性不抛出异常
                .serializationInclusion(JsonInclude.Include.NON_NULL) // 忽略null属性
                ;
        objectMapper = builder.build();
    }

    @SneakyThrows
    public static String writeValueAsString(Object value) {
        return objectMapper.writeValueAsString(value);
    }

    @SneakyThrows
    public static <T> T read(String text, Class<T> valueType) {
        return objectMapper.readValue(text, valueType);
    }

    @SneakyThrows
    public static <T> T read(String text, Class<?> collectionClass, Class<?>... elementClasses) {
        JavaType valueType = objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
        return objectMapper.readValue(text, valueType);
    }

    @SneakyThrows
    public static <K, V> Map<K, V> readMap(String text, Class<K> keyClass, Class<V> valueClass) {
        JavaType valueType = objectMapper.getTypeFactory().constructMapType(Map.class, keyClass, valueClass);
        return objectMapper.readValue(text, valueType);
    }
}
