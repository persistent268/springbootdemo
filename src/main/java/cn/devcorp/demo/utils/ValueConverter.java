package cn.devcorp.demo.utils;

public interface ValueConverter<V> {
    V convert(Object value, Class<?> type, Object... extraParams) throws Exception;
}
