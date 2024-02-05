//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cn.devcorp.demo.utils;



import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public final class ValueConverterRegistry {
    private static ValueConverterRegistry instance = new ValueConverterRegistry();
    private Map<Class<?>, ValueConverter<?>> converters = new HashMap();

    public static ValueConverterRegistry getInstance() {
        return instance;
    }

    private ValueConverterRegistry() {
        this.register(Integer.class, new IntConverter());
        this.register(Byte.class, new ByteConverter());
        this.register(Float.class, new FloatConverter());
        this.register(Long.class, new LongConverter());
        this.register(Short.class, new ShortConverter());
        this.register(Double.class, new DoubleConverter());
        this.register(BigDecimal.class, new BigDecimalConverter());
        this.register(BigInteger.class, new BigIntegerConverter());
        this.register(Character.class, new CharacterConverter());
        this.register(Boolean.class, new BooleanConverter());
        this.register(Integer.TYPE, new IntConverter());
        this.register(Byte.TYPE, new ByteConverter());
        this.register(Float.TYPE, new FloatConverter());
        this.register(Long.TYPE, new LongConverter());
        this.register(Short.TYPE, new ShortConverter());
        this.register(Double.TYPE, new DoubleConverter());
        this.register(Character.TYPE, new CharacterConverter());
        this.register(Boolean.TYPE, new BooleanConverter());
        this.register(String.class, new StringConverter());
        this.register(Array.class, new ArrayConverter());
        this.register(List.class, new ListConverter());
        this.register(Set.class, new SetConverter());
    }

    public void register(Class<?> type, ValueConverter<?> converter) {
        this.converters.put(type, converter);
    }

    public void unregister(Class<?> type) {
        this.converters.remove(type);
    }

    public Map<Class<?>, ValueConverter<?>> getConverters() {
        return this.converters;
    }

    private static class SetConverter extends CollectionConverter<Set<?>> {
        private SetConverter() {
            super();
        }

        protected Set<?> getCollection() {
            return new HashSet();
        }
    }

    private static class ListConverter extends CollectionConverter<List<?>> {
        private ListConverter() {
            super();
        }

        protected List<?> getCollection() {
            return new ArrayList();
        }
    }

    private abstract static class CollectionConverter<T extends Collection> implements ValueConverter<T> {
        private CollectionConverter() {
        }

        public T convert(Object value, Class<?> type, Object... extraParams) {
            T rslt = this.getCollection();
            Object arg0 = extraParams.length > 0 ? extraParams[0] : null;
            if (value instanceof String) {
                String split = arg0 instanceof String ? (String)arg0 : ",";
                value = ((String)value).split(split);
            }

            Class<?> elementType = getElementType(arg0, extraParams);

            everyAdd(value, rslt, elementType);

            return rslt;
        }

        private void everyAdd(Object value, T rslt, Class<?> elementType) {
            Object e;
            Object v;
            if (value.getClass().isArray()) {
                int length = Array.getLength(value);

                for(int i = 0; i < length; ++i) {
                    e = Array.get(value, i);
                    v = ValueUtils.convert(e, elementType);
                    rslt.add(v);
                }
            } else if (value instanceof Collection) {
                Collection<?> coll = (Collection) value;
                Iterator var13 = coll.iterator();

                while(var13.hasNext()) {
                    e = var13.next();
                    v = ValueUtils.convert(e, elementType);
                    rslt.add(v);
                }
            }
        }

        private Class<?> getElementType(Object arg0,  Object... extraParams) {
            Class<?> elementType = null;
            if (arg0 != null) {
                if (arg0 instanceof Class) {
                    elementType = (Class)arg0;
                } else {
                    elementType = extraParams.length > 1 ? (Class)extraParams[1] : null;
                }
            }
            return elementType;
        }

        protected abstract T getCollection();
    }

    public static class ArrayConverter implements ValueConverter<Object> {
        public ArrayConverter() {
        }

        public Object convert(Object value, Class<?> type, Object... extraParams) {
            Object obj;
            Object arg0 = extraParams.length > 0 ? extraParams[0] : null;
            if (value instanceof String) {
                String split = arg0 instanceof String ? (String)arg0 : ",";
                value = ((String)value).split(split);
            }

            Class<?> elementType = type.getComponentType();
            Object rslt;
            int index;
            Object v;
            if (value.getClass().isArray()) {
                if (elementType == value.getClass().getComponentType()) {
                    obj = value;
                } else {
                    int length = Array.getLength(value);
                    rslt = Array.newInstance(elementType, length);

                    for(index = 0; index < length; ++index) {
                        Object e = Array.get(value, index);
                        v = ValueUtils.convert(e, elementType);
                        Array.set(rslt, index, v);
                    }

                    obj = rslt;
                }
            } else if (!(value instanceof Collection)) {
                obj = null;
            } else {
                Collection<?> coll = (Collection)value;
                rslt = Array.newInstance(elementType, coll.size());
                index = 0;
                Iterator var9 = coll.iterator();

                while(var9.hasNext()) {
                    v = var9.next();
                    v = ValueUtils.convert(v, elementType);
                    Array.set(rslt, index++, v);
                }

                obj = rslt;
            }
            return obj;
        }
    }

    private static class BooleanConverter implements ValueConverter<Boolean> {
        private BooleanConverter() {
        }

        public Boolean convert(Object value, Class<?> type, Object... extraParams) {
            if ("1".equals(value.toString())) {
                return Boolean.TRUE;
            } else {
                return "Y".equals(value.toString()) ? Boolean.TRUE : Boolean.valueOf(value.toString());
            }
        }
    }

    private static class StringConverter implements ValueConverter<String> {
        private StringConverter() {
        }

        public String convert(Object value, Class<?> type, Object... extraParams) {
            String result = null;
            if (value instanceof Date) {
                result = DateUtil.date2Str((Date)value);
            } else if (value instanceof Double) {
                Double number = (Double)value;
                result = BigDecimal.valueOf(number).toString();
            } else if (value instanceof Long) {
                Long number = (Long)value;
                result = BigDecimal.valueOf(number).toString();
            } else {
                result = value.toString();
            }
            return result;
        }
    }

    private static class CharacterConverter implements ValueConverter<Character> {
        private CharacterConverter() {
        }

        public Character convert(Object value, Class<?> type, Object... extraParams) {
            boolean booleanType = Boolean.TYPE.isAssignableFrom(value.getClass());
            if (!(value instanceof Boolean) && !booleanType) {
                return value.toString().charAt(0);
            } else {
                boolean bool = false;
                if (value instanceof Boolean) {
                    bool = (Boolean)value;
                }

                if (booleanType) {
                    bool = (Boolean)value;
                }

                int c = bool ? 1 : 0;
                return (char)c;
            }
        }
    }

    public static class BigIntegerConverter extends NumberConverter<BigInteger> {
        public BigIntegerConverter() {
            super();
        }

        protected BigInteger convertString(String s) {
            return new BigInteger(s);
        }

        protected BigInteger convertNumber(Number n) {
            return new BigInteger(n.toString());
        }
    }

    public static class BigDecimalConverter extends NumberConverter<BigDecimal> {
        public BigDecimalConverter() {
            super();
        }

        protected BigDecimal convertString(String s) {
            return new BigDecimal(s);
        }

        protected BigDecimal convertNumber(Number n) {
            return new BigDecimal(n.toString());
        }
    }

    private static class DoubleConverter extends NumberConverter<Double> {
        private DoubleConverter() {
            super();
        }

        protected Double convertString(String s) {
            return Double.valueOf(s);
        }

        protected Double convertNumber(Number n) {
            return n.doubleValue();
        }
    }

    private static class LongConverter extends NumberConverter<Long> {
        private LongConverter() {
            super();
        }

        protected Long convertString(String s) {
            return Long.valueOf(s);
        }

        protected Long convertNumber(Number n) {
            return n.longValue();
        }
    }

    private static class ByteConverter extends NumberConverter<Byte> {
        private ByteConverter() {
            super();
        }

        protected Byte convertString(String s) {
            return Byte.valueOf(s);
        }

        protected Byte convertNumber(Number n) {
            return n.byteValue();
        }
    }

    private static class ShortConverter extends NumberConverter<Short> {
        private ShortConverter() {
            super();
        }

        protected Short convertString(String s) {
            return Short.valueOf(s);
        }

        protected Short convertNumber(Number n) {
            return n.shortValue();
        }
    }

    private static class FloatConverter extends NumberConverter<Float> {
        private FloatConverter() {
            super();
        }

        protected Float convertString(String s) {
            return Float.valueOf(s);
        }

        protected Float convertNumber(Number n) {
            return n.floatValue();
        }
    }

    private static class IntConverter extends NumberConverter<Integer> {
        private IntConverter() {
            super();
        }

        protected Integer convertString(String s) {
            return Integer.valueOf(s);
        }

        protected Integer convertNumber(Number n) {
            return n.intValue();
        }
    }

    private abstract static class NumberConverter<T> implements ValueConverter<T> {
        private NumberConverter() {
        }

        public T convert(Object value, Class<?> type, Object... extraParams) {
            T t = null;
            if (value instanceof String) {
                t = this.convertString((String)value);
            } else if (value instanceof Date) {
                t = this.convertString(((Date)value).getTime() + "");
            } else if (value instanceof Boolean) {
                t = this.convertNumber((Boolean)value ? 1 : 0);
            } else {
                t = value instanceof Number ? this.convertNumber((Number)value) : null;
            }
            return t;
        }

        protected abstract T convertString(String s);

        protected abstract T convertNumber(Number n);
    }

}


