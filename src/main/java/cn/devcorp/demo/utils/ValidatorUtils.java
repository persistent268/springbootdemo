package cn.devcorp.demo.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class ValidatorUtils {

    public static boolean isEmpty(Object object) {
        return !isNotEmpty(object);
    }

    public static boolean isNotEmpty(Object object) {
        if (null == object) {
            return false;
        } else if (object instanceof Optional && !((Optional) object).isPresent()) {
            return false;
        } else if (object instanceof CharSequence && StringUtils.isBlank(String.valueOf(object))) {
            return false;
        } else if (isCollectionsSupportType(object) && CollectionUtils.isEmpty((Collection<?>) object)) {
            return false;
        }
        return true;
    }

    private static boolean isCollectionsSupportType(Object value) {
        boolean isCollectionOrMap = value instanceof Collection || value instanceof Map;
        boolean isEnumerationOrIterator = value instanceof Enumeration || value instanceof Iterator;
        return isCollectionOrMap || isEnumerationOrIterator || value.getClass().isArray();
    }
}