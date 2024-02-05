//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cn.devcorp.demo.utils;



import java.lang.reflect.Array;
import java.util.Map;

public class ValueUtils {
    public ValueUtils() {
    }

    public static boolean hasLength(CharSequence str) {
        return str != null && str.length() > 0;
    }

    public static boolean hasText(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        } else {
            int strLen = str.length();

            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return true;
                }
            }

            return false;
        }
    }

    public static String safe2Str(Object obj, String nullValue) {
        return obj != null ? obj.toString() : nullValue;
    }

    public static <T> T convert(Object value, Class<T> type) {
        return convert(value, type, (Object[])null);
    }

    public static <T> T convert(Object value, Class<T> type, Object[] extraParams) {
        T result = null;
        if (value == null) {
            return result;
        }
        if (value instanceof String) {
            if (String.class.isAssignableFrom(type)) {
                result = (T) value;
            } else if (!hasText((String)value)) {
            }
        } else if (type == null || type.isInstance(value)) {
            result = (T) value;
        } else {
            convertTemp(value, type, extraParams);
        }
        return result;
    }

    private static <T> T convertTemp(Object value, Class<T> type, Object[] extraParams) {
        T result;
        try {
            Map<Class<?>, ValueConverter<?>> converterMap = ValueConverterRegistry.getInstance().getConverters();
            ValueConverter<T> converter = (ValueConverter)converterMap.get(type);
            if (converter == null) {
                // 如果是一个类的话，直接再复制一次
                if (type != null) {
                    result = type.newInstance();
                    BeanUtils.copyProperties(value, result);
                    return result;
                }
                if (!type.isArray()) {
                    throw new RuntimeException("The type " + type + " has not supported yet.");
                }

                converter = (ValueConverter)converterMap.get(Array.class);
            }
            if (extraParams != null) {
                result = converter.convert(value, type, extraParams);
            } else {
                result = converter.convert(value, type, new Object[0]);
            }
            if (result == null) {
                throw new ClassCastException(value.getClass().getName() + " cannot be cast to " + type.getName() + ", value: " + value);
            }
        } catch (Exception var6) {
            throw new ClassCastException(value.getClass().getName() + " cannot be cast to " + type.getName() + ", value: " + value + ", reason: " + var6.getMessage());
        }
        return result;
    }

}
