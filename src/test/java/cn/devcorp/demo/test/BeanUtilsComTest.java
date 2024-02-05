package cn.devcorp.demo.test;

import cn.devcorp.demo.pojo.SignTask;
import cn.devcorp.demo.pojo.SignTaskDocDocument;
import cn.devcorp.demo.pojo.SignTaskDocument;
import cn.devcorp.demo.pojo.SignTaskDto;
import cn.devcorp.demo.utils.BeanUtils;
import cn.devcorp.demo.vo.SignTaskDocDocumentVo;
import cn.devcorp.demo.vo.SignTaskDocumentVo;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/1/27 14:47
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class BeanUtilsComTest {
    @Test
    public void testBeanUtils(){
        SignTaskDocDocument signTaskDocDocument = SignTaskDocDocument.builder().signMethod(1).fileName("文件1").build();
        SignTaskDocDocument signTaskDocDocument2 = SignTaskDocDocument.builder().signMethod(2).fileName("文件1").build();
        SignTaskDocument signTaskDocument = SignTaskDocument.builder()
                .taskName("测试任务").fileList(Arrays.asList(signTaskDocDocument,signTaskDocDocument2)).build();
        SignTaskDocumentVo signTaskDocumentVo = BeanUtils.copyProperties(signTaskDocument, SignTaskDocumentVo.class);
        System.out.println(JSON.toJSONString(signTaskDocumentVo));
    }
    @Test
    public void testBeanUtils2(){
        SignTaskDocDocumentVo signTaskDocDocumentVo = SignTaskDocDocumentVo.builder().signMethod(1).fileName("文件1").build();
        SignTaskDocDocumentVo signTaskDocDocumentVo2 = SignTaskDocDocumentVo.builder().signMethod(2).fileName("文件1").build();
        SignTaskDocumentVo signTaskDocumentVo = SignTaskDocumentVo.builder()
                .taskName("测试任务").fileList(Arrays.asList(signTaskDocDocumentVo,signTaskDocDocumentVo2)).build();
        SignTaskDocument signTaskDocument = BeanUtils.copyProperties(signTaskDocumentVo, SignTaskDocument.class);
        List<SignTaskDocDocument> fileList = signTaskDocument.getFileList();
        for (Object signTaskDocDocument:
             fileList) {
            System.out.println(signTaskDocDocument.getClass());
        }
        System.out.println(JSON.toJSONString(signTaskDocument));
    }
    @Test
    public void testEasy(){
        SignTask signTask = new SignTask();
        signTask.setSignType(1);
        signTask.setTaskName("任务1");
        SignTaskDto signTaskDto = BeanUtils.copyProperties(signTask, SignTaskDto.class);
        System.out.println(signTaskDto);
    }
    @Test
    public void testLocal(){
        LocalDateTime now1 = LocalDateTime.now();
        SignTaskDocDocumentVo signTaskDocDocumentVo = SignTaskDocDocumentVo.builder().signMethod(1).fileName("文件1").build();
        SignTaskDocDocumentVo signTaskDocDocumentVo2 = SignTaskDocDocumentVo.builder().signMethod(2).fileName("文件1").build();
        SignTaskDocumentVo signTaskDocumentVo = SignTaskDocumentVo.builder()
                .taskName("测试任务").fileList(Arrays.asList(signTaskDocDocumentVo,signTaskDocDocumentVo2)).build();
        SignTaskDocument signTaskDocument = BeanUtils.copyProperties(signTaskDocumentVo, SignTaskDocument.class);
        List<SignTaskDocDocument> fileList = signTaskDocument.getFileList();
        for (Object signTaskDocDocument:
                fileList) {
            System.out.println(signTaskDocDocument.getClass());
        }
        System.out.println(JSON.toJSONString(signTaskDocument));
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);
        System.out.println(now1);
    }
}
