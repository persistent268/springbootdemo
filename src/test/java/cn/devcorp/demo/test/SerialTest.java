package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.CountryDTO;
import cn.devcorp.demo.pojo.MyDtoAccessLevel;
import cn.devcorp.demo.pojo.MyDtoWithGetter;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.bytecode.AccessFlag;
import javassist.bytecode.ClassFile;
import javassist.bytecode.FieldInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/11 14:29
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class SerialTest {
    @Test
    public void givenDifferentAccessLevels_whenPublic_thenSerializable()
            throws JsonProcessingException {

        MyDtoAccessLevel dtoObject = new MyDtoAccessLevel();

        String dtoAsString = JSON.toJSONString(dtoObject);
        assertThat(dtoAsString, not(containsString("stringValue")));
        assertThat(dtoAsString, not(containsString("intValue")));
        assertThat(dtoAsString, not(containsString("floatValue")));

        assertThat(dtoAsString, containsString("booleanValue"));
    }
    @Test
    public void givenDifferentAccessLevels_whenGetterAdded_thenSerializable()
            throws JsonProcessingException {

        MyDtoWithGetter dtoObject = new MyDtoWithGetter();
        String dtoAsString = JSON.toJSONString(dtoObject);
        assertThat(dtoAsString, containsString("stringValue"));
        assertThat(dtoAsString, not(containsString("intValue")));
        assertThat(dtoAsString, not(containsString("stringValue")));
    }

    @Test
    public void testSerialize() {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setCountry("中国");
        String str = JSON.toJSONString(countryDTO);
        System.out.println(str);
    }
    @Test
    public void testJavaAssist() throws CannotCompileException {
        ClassFile cf = new ClassFile(
                false, "cn.devcorp.demo.pojo.JavassistGeneratedClass", null);
        cf.setInterfaces(new String[] {"java.lang.Cloneable"});

        FieldInfo f = new FieldInfo(cf.getConstPool(), "id", "I");
        f.setAccessFlags(AccessFlag.PUBLIC);
        cf.addField(f);
        ClassPool classPool = ClassPool.getDefault();
        Field[] fields = classPool.makeClass(cf).toClass().getFields();

        assertEquals(fields[0].getName(), "id");
    }
}
