package plus.knowing.kmall.exception;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Objects;

public interface Assert {

    BaseException newException();

    BaseException newException(String message);

    BaseException newException(Throwable cause);

    default void fail() {
        throw newException();
    }

    default void fail(String message) {
        throw newException();
    }

    default void fail(Throwable cause) {
        throw newException(cause);
    }

    default void assertTrue(Boolean condition) {
        if (Objects.isNull(condition) || !condition) {
            throw newException();
        }
    }

    default void assertTrue(Boolean condition, String message) {
        if (Objects.isNull(condition) || !condition) {
            throw newException(message);
        }
    }

    default void assertFalse(Boolean condition) {
        if (Objects.isNull(condition) || condition) {
            throw newException();
        }
    }

    default void assertFalse(Boolean condition, String message) {
        if (Objects.isNull(condition) || condition) {
            throw newException(message);
        }
    }

    default void assertNotNull(Object obj) {
        if (Objects.isNull(obj)) {
            throw newException();
        }
    }

    default void assertNotNull(Object obj, String message) {
        if (Objects.isNull(obj)) {
            throw newException(message);
        }
    }

    default void assertEmpty(Collection<?> collection) {
        if (!CollectionUtils.isEmpty(collection)) {
            throw newException();
        }
    }

    default void assertEmpty(Collection<?> collection, String message) {
        if (!CollectionUtils.isEmpty(collection)) {
            throw newException(message);
        }
    }

    default void assertNotEmpty(Collection<?> collection) {
        if (CollectionUtils.isEmpty(collection)) {
            throw newException();
        }
    }

    default void assertNotEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw newException(message);
        }
    }

    default void assertEquals(Object obj1, Object obj2) {
        if (!Objects.equals(obj1, obj2)) {
            throw newException();
        }
    }

    default void assertEquals(Object obj1, Object obj2, String message) {
        if (!Objects.equals(obj1, obj2)) {
            throw newException(message);
        }
    }

    default void assertNotEquals(Object obj1, Object obj2) {
        if (Objects.equals(obj1, obj2)) {
            throw newException();
        }
    }

    default void assertNotEquals(Object obj1, Object obj2, String message) {
        if (Objects.equals(obj1, obj2)) {
            throw newException(message);
        }
    }

    default void assertNotBlank(String str) {
        if (StringUtils.isEmpty(str)) {
            throw newException();
        }
    }

    default void assertNotBlank(String str, String message) {
        if (StringUtils.isEmpty(str)) {
            throw newException(message);
        }
    }
}
