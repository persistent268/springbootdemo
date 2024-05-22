package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.Lao;
import cn.devcorp.demo.utils.ValidatorUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/4/27 9:51
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class YamlTest {
    @Value("esealName")
    private String esealName;
    @Test
    public void testYaml(){
        if(esealName.contains("合同章")){
            System.out.println(1);
        }
    }
    @Test
    public void testId(){
//        System.out.println(ValidatorUtils.isEmpty(""));
        List<Lao> laoList = new ArrayList<>();
        Lao lao = new Lao();
//        lao.setIdNumber("");
        laoList.add(lao);
        System.out.println(ValidatorUtils.isEmpty(laoList));
    }
}
