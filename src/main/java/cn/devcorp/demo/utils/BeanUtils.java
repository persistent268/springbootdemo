package cn.devcorp.demo.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.Map.Entry;

public final class BeanUtils {
    private static final Map<String, BeanCopier> COPIER_MAP = new HashMap();

    public BeanUtils() {
    }

    public static List<Map<String, Object>> beans2MapsByIncludedAnnotation(List<? extends Object> beans, Class<? extends Annotation> includedAnnotation) {
        if (beans == null) {
            return null;
        } else if (beans.size() == 0) {
            return Collections.emptyList();
        } else {
            PropertyDescriptor[] pds = ReflectUtils.getPropertyDescriptors(beans.get(0).getClass());
            List<PropertyDescriptor> pdList = Lists.newArrayList();
            PropertyDescriptor[] var4 = pds;
            int var5 = pds.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                PropertyDescriptor pd = var4[var6];
                if (pd.getReadMethod() != null && pd.getReadMethod().isAnnotationPresent(includedAnnotation)) {
                    pdList.add(pd);
                }
            }

            return doBeans2Maps(beans, (PropertyDescriptor[])pdList.toArray(new PropertyDescriptor[0]));
        }
    }

    public static List<Map<String, Object>> beans2MapsByExcludedAnnotation(List<? extends Object> beans, Class<? extends Annotation> excludedAnnotation) {
        if (beans == null) {
            return null;
        } else if (beans.size() == 0) {
            return Collections.emptyList();
        } else {
            PropertyDescriptor[] pds = ReflectUtils.getPropertyDescriptors(beans.get(0).getClass());
            List<PropertyDescriptor> pdList = Lists.newArrayList();
            PropertyDescriptor[] var4 = pds;
            int var5 = pds.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                PropertyDescriptor pd = var4[var6];
                if (pd.getReadMethod() != null && !pd.getReadMethod().isAnnotationPresent(excludedAnnotation)) {
                    pdList.add(pd);
                }
            }

            return doBeans2Maps(beans, (PropertyDescriptor[])pdList.toArray(new PropertyDescriptor[pdList.size()]));
        }
    }

    public static List<Map<String, Object>> beans2MapsByIncludeGetters(List<? extends Object> beans, String... includedProperties) {
        if (beans == null) {
            return null;
        } else if (beans.size() == 0) {
            return Collections.emptyList();
        } else {
            PropertyDescriptor[] pds = ReflectUtils.getPropertyDescriptors4IncludedNames(beans.get(0).getClass(), includedProperties);
            return doBeans2Maps(beans, pds);
        }
    }


    private static List<Map<String, Object>> doBeans2Maps(List<? extends Object> beans, PropertyDescriptor[] pds) {
        List<Map<String, Object>> maps = new ArrayList(beans.size());
        Iterator var3 = beans.iterator();

        while(var3.hasNext()) {
            Object bean = var3.next();
            Map<String, Object> map = new HashMap(pds.length);
            doBean2Map(bean, map, pds);
            maps.add(map);
        }

        return maps;
    }

    public static Map<String, Object> bean2Map(Object obj, String... ignoreProperties) {
        if (obj == null) {
            return null;
        } else {
            Map<String, Object> map = new HashMap();
            bean2Map(obj, map);
            return map;
        }
    }

    public static void bean2Map(Object obj, Map<String, Object> map, String... ignoreProperties) {
        if (obj != null) {
        }
    }

    public static Map<String, Object> bean2MapByIncludeGetters(Object obj, String... includedProperties) {
        if (obj == null) {
            return null;
        } else {
            PropertyDescriptor[] pds = ReflectUtils.getPropertyDescriptors4IncludedNames(obj.getClass(), includedProperties);
            Map<String, Object> map = new HashMap();
            doBean2Map(obj, map, pds);
            return map;
        }
    }

    public static void bean2MapByIncludeGetters(Object obj, Map<String, Object> map, String... includedProperties) {
        if (obj != null) {
            PropertyDescriptor[] pds = ReflectUtils.getPropertyDescriptors4IncludedNames(obj.getClass(), includedProperties);
            doBean2Map(obj, map, pds);
        }
    }

    private static void doBean2Map(Object bean, Map<String, Object> map, PropertyDescriptor[] pds) {
        try {
            PropertyDescriptor[] var3 = pds;
            int var4 = pds.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                PropertyDescriptor pd = var3[var5];
                Method getter = pd.getReadMethod();
                if (getter != null && Modifier.isPublic(getter.getModifiers()) && !Modifier.isStatic(getter.getModifiers())) {
                    map.put(pd.getName(), getter.invoke(bean));
                }
            }

        } catch (Exception var8) {
            throw ExceptionUtils.wrap2Runtime(var8);
        }
    }

    public static <T> T map2Bean(Map<String, Object> data, Class<T> beanClass, String... ignoreKeys) {
        if (data == null) {
            return null;
        } else {
            try {
                T obj = beanClass.newInstance();
                map2Bean(data, obj, ignoreKeys);
                return obj;
            } catch (Exception var4) {
                throw ExceptionUtils.wrap2Runtime(var4);
            }
        }
    }

    public static void map2Bean(Map<String, Object> data, Object obj, String... ignoreKeys) {
        try {
            Set<String> ignoreSet = getSet(ignoreKeys);
            Iterator var4 = data.entrySet().iterator();

            while(var4.hasNext()) {
                Entry<String, Object> entry = (Entry)var4.next();
                dealMap2Bean(obj, ignoreSet, entry);
            }

        } catch (Exception var9) {
            throw ExceptionUtils.wrap2Runtime(var9);
        }
    }

    private static void dealMap2Bean(Object obj, Set<String> ignoreSet, Entry<String, Object> entry) throws IllegalAccessException, InvocationTargetException {
        if (!ignoreSet.contains(entry.getKey())) {
            PropertyDescriptor pd = ReflectUtils.getPropertyDescriptor(obj.getClass(), (String) entry.getKey());
            if (pd != null) {
                Object value = entry.getValue();
                Method setter = pd.getWriteMethod();
                if (setter != null && Modifier.isPublic(setter.getModifiers()) && !Modifier.isStatic(setter.getModifiers())) {
                    setter.invoke(obj, ValueUtils.convert(value, pd.getPropertyType()));
                }
            }
        }
    }

    public static <T> List<T> copyList(List<?> source, Class<T> targetClass) {
        return copyList(source, targetClass, (String[])null);
    }

    public static <T> List<T> copyList(List<?> source, Class<T> targetClass, String[] ignoreProperties) {
        Assert.notNull(source, "Parameter source is required");

        try {
            List<T> rslt = new ArrayList();
            Iterator var4 = source.iterator();

            while(var4.hasNext()) {
                Object obj = var4.next();
                T target = targetClass.newInstance();
                copyProperties(obj, target, ignoreProperties);
                rslt.add(target);
            }

            return rslt;
        } catch (Exception var7) {
            throw ExceptionUtils.wrap2Runtime(var7);
        }
    }

    public static <T> T copyProperties(Object source, Class<T> targetClass) {
        return (T) copyProperties(source, (Class)targetClass, (String[])null);
    }

    public static <T> T copyProperties(Object source, Class<T> targetClass, String[] ignoreProperties) {
        try {
            T target = targetClass.newInstance();
            copyProperties(source, target, ignoreProperties);
            return target;
        } catch (Exception var4) {
            throw ExceptionUtils.wrap2Runtime(var4);
        }
    }

    public static void copyProperties(Object source, Object target) {
        copyProperties(source, (Object)target, (String[])null);
    }

    public static void copyProperties(Object source, Object target, String[] ignoreProperties) {
        Assert.notNull(source, "Parameter source is required");
        Assert.notNull(target, "Parameter target is required");

        try {
            Class srcClass = source.getClass();
            Class targetClass = target.getClass();
            boolean isSrcMap = Map.class.isAssignableFrom(srcClass);
            boolean isTargetMap = Map.class.isAssignableFrom(targetClass);
            extracted(source, target, ignoreProperties, isSrcMap, isTargetMap);

        } catch (Exception var12) {
            throw ExceptionUtils.wrap2Runtime(var12);
        }
    }

    private static void extracted(Object source, Object target, String[] ignoreProperties, boolean isSrcMap, boolean isTargetMap) throws Exception {
        if (!isSrcMap) {
            extracted(source, target, ignoreProperties, isTargetMap);
        } else {
            ext(source, target, isTargetMap, ignoreProperties);
        }
    }

    private static void ext(Object source, Object target, boolean isTargetMap, String[] ignoreProperties){
        Map<String, Object> sourceMap = (Map)source;
        if (isTargetMap) {
            Map<String, Object> targetMap = (Map<String, Object>) target;
            Set<String> ignoreSet = new HashSet<>(Arrays.asList(ignoreProperties));
            processMapEntries(sourceMap.entrySet().iterator(), ignoreSet, targetMap);
        } else {
            map2Bean(sourceMap, target, ignoreProperties);
        }
    }


    private static void extracted(Object source, Object target, String[] ignoreProperties, boolean isTargetMap) throws Exception {
        if (isTargetMap) {
            bean2Map(source, (Map) target, ignoreProperties);
        } else {
            doCopyProperties(source, target, ignoreProperties);
        }
    }

    private static void processMapEntries(Iterator<Entry<String, Object>> iterator, Set<String> ignoreSet, Map<String, Object> targetMap) {
        while (iterator.hasNext()) {
            Entry<String, Object> entry = iterator.next();
            if (!ignoreSet.contains(entry.getKey())) {
                targetMap.put(entry.getKey(), entry.getValue());
            }
        }
    }

    private static void doCopyProperties(Object source, Object target, String[] ignoreProperties) throws Exception {
        if (ignoreProperties != null && ignoreProperties.length != 0) {
            doCopyPropertiesByReflection(source, target, ignoreProperties);
        } else {
            extracted(source, target, ignoreProperties);
        }

    }

    private static void extracted(Object source, Object target, String[] ignoreProperties) throws Exception {
        try {
            String copierKey = source.getClass().getName() + "|" + target.getClass().getName();
            BeanCopier copier = (BeanCopier)COPIER_MAP.get(copierKey);
            copier = getBeanCopier(source, target, copierKey, copier);

            copier.copy(source, target, (value, target1, context) -> {
                return ValueUtils.convert(value, target1);
            });
        } catch (Throwable var5) {
            System.err.println(var5.getMessage());
            doCopyPropertiesByReflection(source, target, ignoreProperties);
        }
    }

    private static BeanCopier getBeanCopier(Object source, Object target, String copierKey, BeanCopier copier) {
        if (copier == null) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), true);
            COPIER_MAP.put(copierKey, copier);
        }
        return copier;
    }

    private static void doCopyPropertiesByReflection(Object source, Object target, String[] ignoreProperties) throws Exception {
        Set<String> ignoreSet = getSet(ignoreProperties);
        PropertyDescriptor[] pds = ReflectUtils.getPropertyDescriptors(source.getClass());
        PropertyDescriptor[] var5 = pds;
        int var6 = pds.length;
        for(int var7 = 0; var7 < var6; ++var7) {
            doCopyPropertiesByReflection(source, target, var5, var7, ignoreSet);
        }
    }

    private static void doCopyPropertiesByReflection(Object source, Object target, PropertyDescriptor[] var5, int var7, Set<String> ignoreSet) throws Exception {
        PropertyDescriptor pd = var5[var7];
        if (!ignoreSet.contains(pd.getName())) {
            Method readMethod = pd.getReadMethod();
            if (readMethod != null && Modifier.isPublic(readMethod.getModifiers()) && !Modifier.isStatic(readMethod.getModifiers())) {
                PropertyDescriptor tgtPd = ReflectUtils.getPropertyDescriptor(target.getClass(), pd.getName());
                if (tgtPd == null) {
                    return;
                }
                Method writeMethod = tgtPd.getWriteMethod();
                if (writeMethod == null || !Modifier.isPublic(writeMethod.getModifiers()) || Modifier.isStatic(writeMethod.getModifiers())) {
                    return;
                }
                Object value = readMethod.invoke(source);
                if (value == null) {
                    return;
                }
                writeMethod.invoke(target, ValueUtils.convert(value, tgtPd.getPropertyType()));
            }
        }
    }

    private static Set<String> getSet(String[] array) {
        return (Set)(array != null && array.length > 0 ? Sets.newHashSet(array) : Collections.emptySet());
    }

    public static List<String> getNonNullFields(Object obj, String[] fields, String... excludeFields) {
        List<String> nonNullFields = Lists.newArrayList();
        List<String> excludes = Collections.emptyList();
        if (excludeFields != null) {
            excludes = Arrays.asList(excludeFields);
        }

        String[] var5 = fields;
        int var6 = fields.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            String getter = var5[var7];
            if (!excludes.contains(getter)) {
                Object value = ReflectUtils.callGetMethod(obj, getter);
                if (value != null) {
                    nonNullFields.add(getter);
                }
            }
        }

        return nonNullFields;
    }

}
