//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cn.devcorp.demo.utils;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ReflectUtils {
    public ReflectUtils() {
    }

    public static Object callGetMethod(Object instance, String fieldName) {
        Object result = null;

        try {
            Method getter = getter(instance.getClass(), fieldName);
            if (getter != null) {
                result = getter.invoke(instance);
            }

            return result;
        } catch (Exception var4) {
            throw ExceptionUtils.wrap2Runtime(var4);
        }
    }

    public static Field getField(Class<?> entityClass, String fieldname, boolean caseSensitive) throws NoSuchFieldException {
        Field f = null;
        if (caseSensitive) {
            f = getFieldOne(entityClass, fieldname, caseSensitive);
        } else {
            Field[] fs = entityClass.getFields();
            for(int i = 0; i < fs.length; ++i) {
                Field f1 = fs[i];
                if (fieldname.toLowerCase().equals(f1.getName().toLowerCase())) {
                    f = f1;
                }
            }
        }
        return f;
    }

    private static Field getFieldOne(Class<?> entityClass, String fieldname, boolean caseSensitive) throws NoSuchFieldException {
        Field f;
        try {
            f = entityClass.getField(fieldname);
        } catch (NoSuchFieldException var6) {
            if (entityClass.getSuperclass() != null && entityClass.getSuperclass() != Object.class) {
                f = getField(entityClass.getSuperclass(), fieldname, caseSensitive);
            } else {
                throw var6;
            }
        }
        return f;
    }

    public static Method getMethod(Class<?> entityClass, String methodName, Class<?>... type) throws NoSuchMethodException {
        try {
            Method m = entityClass.getMethod(methodName, type);
            return m != null ? m : null;
        } catch (NoSuchMethodException var4) {
            if (entityClass.getSuperclass() != null && entityClass.getSuperclass() != Object.class) {
                return getMethod(entityClass.getSuperclass(), methodName, type);
            } else {
                throw var4;
            }
        }
    }

    public static Method setter(Class clazz, String fieldName, Class<?>... type) throws NoSuchMethodException {
        PropertyDescriptor pd = getPropertyDescriptor(clazz, fieldName);
        return pd != null && pd.getWriteMethod() != null && Modifier.isPublic(pd.getWriteMethod().getModifiers()) ? pd.getWriteMethod() : getMethod(clazz, "set" + StringUtils.capitalize(fieldName), type);
    }

    private static List<Method> doGetters(Class clazz) {
        PropertyDescriptor[] pds = getPropertyDescriptors(clazz);
        List<Method> rslt = new ArrayList();
        PropertyDescriptor[] var3 = pds;
        int var4 = pds.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            PropertyDescriptor pd = var3[var5];
            Method getter = pd.getReadMethod();
            if (getter != null && Modifier.isPublic(getter.getModifiers())) {
                rslt.add(getter);
            }
        }

        return rslt;
    }

    public static String[] getterNames(Class clazz) {
        PropertyDescriptor[] pds = getPropertyDescriptors(clazz);
        List<String> names = Lists.newArrayListWithExpectedSize(pds.length);
        PropertyDescriptor[] var3 = pds;
        int var4 = pds.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            PropertyDescriptor pd = var3[var5];
            if (pd.getReadMethod() != null) {
                names.add(pd.getName());
            }
        }

        return (String[])names.toArray(new String[names.size()]);
    }

    public static Method getter(Class clazz, String fieldName) throws NoSuchMethodException {
        PropertyDescriptor pd = getPropertyDescriptor(clazz, fieldName);
        if (pd != null) {
            return pd.getReadMethod();
        } else {
            throw new NoSuchMethodException(clazz.getName() + "." + fieldName + "()");
        }
    }

    public static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String propertyName) {
        return BeanUtils.getPropertyDescriptor(clazz, propertyName);
    }

    public static PropertyDescriptor[] getPropertyDescriptors(Class<?> clazz) {
        PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(clazz);
        int idx = 0;
        int hasClass = 0;
        PropertyDescriptor[] rslt = pds;
        int var5 = pds.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            PropertyDescriptor pd = rslt[var6];
            if ("class".equals(pd.getName())) {
                hasClass = 1;
                break;
            }

            ++idx;
        }

        rslt = new PropertyDescriptor[pds.length - hasClass];
        if (hasClass == 0) {
            System.arraycopy(pds, 0, rslt, 0, rslt.length);
        } else if (idx == 0) {
            System.arraycopy(pds, 1, rslt, 0, rslt.length);
        } else {
            System.arraycopy(pds, 0, rslt, 0, idx);
            System.arraycopy(pds, idx + 1, rslt, idx, rslt.length - idx);
        }

        return rslt;
    }

    public static PropertyDescriptor[] getPropertyDescriptors4IncludedNames(Class<?> clazz, String[] includedNames) {
        List<PropertyDescriptor> rslt = Lists.newArrayList();
        String[] var3 = includedNames;
        int var4 = includedNames.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String name = var3[var5];
            rslt.add(getPropertyDescriptor(clazz, name));
        }

        return (PropertyDescriptor[])rslt.toArray(new PropertyDescriptor[rslt.size()]);
    }

    public static PropertyDescriptor[] getPropertyDescriptors4ExcludedNames(Class<?> clazz, String[] excludedNames) {
        PropertyDescriptor[] pds = getPropertyDescriptors(clazz);
        if (excludedNames != null && excludedNames.length != 0) {
            List<PropertyDescriptor> rslt = Lists.newArrayList();
            PropertyDescriptor[] var4 = pds;
            int var5 = pds.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                PropertyDescriptor pd = var4[var6];
                boolean exclude = false;
                String[] var9 = excludedNames;
                int var10 = excludedNames.length;

                exclude = isExclude(pd, exclude, var9, var10);

                if (!exclude) {
                    rslt.add(pd);
                }
            }

            return (PropertyDescriptor[])rslt.toArray(new PropertyDescriptor[rslt.size()]);
        } else {
            return pds;
        }
    }

    private static boolean isExclude(PropertyDescriptor pd, boolean exclude, String[] var9, int var10) {
        for(int var11 = 0; var11 < var10; ++var11) {
            String excludedName = var9[var11];
            if (pd.getName().equals(excludedName)) {
                exclude = true;
                break;
            }
        }
        return exclude;
    }

    private static void extracted(int filterModifierSet, List<Field> fields, List<String> excludeProps, Field[] var7, int var8) {
        for(int var9 = 0; var9 < var8; ++var9) {
            Field f = var7[var9];
            if (!hasModifiers(f, filterModifierSet) && !excludeProps.contains(f.getName())) {
                fields.add(f);
            }
        }
    }

    public static boolean hasModifiers(Field field, int modifierSet) {
        int mdfr = field.getModifiers();
        return (mdfr & modifierSet) != 0;
    }
}
