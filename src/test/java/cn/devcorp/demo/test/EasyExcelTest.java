//package cn.devcorp.demo.test;
//
//import cn.devcorp.demo.pojo.FillData;
//import cn.devcorp.demo.utils.TestFileUtil;
//import com.alibaba.excel.EasyExcel;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
///**
// * Description: TODO
// *
// * @author YK107
// * @date 2024/1/9 13:46
// *
// * <pre>
// *              www.cloudscope.cn
// *      Copyright (c) 2019. All Rights Reserved.
// * </pre>
// */
//@SpringBootTest
//public class EasyExcelTest {
//    @Test
//    public void simpleFill() {
//        // 模板注意 用{} 来表示你要用的变量 如果本来就有"{","}" 特殊字符 用"\{","\}"代替
//        String templateFileName =
//                TestFileUtil.getPath() + "simple.xlsx";
//
//        // 方案1 根据对象填充
//        String fileName = TestFileUtil.getPath() + "simpleFill" + System.currentTimeMillis() + ".xlsx";
//        // 这里 会填充到第一个sheet， 然后文件流会自动关闭
//        FillData fillData = new FillData();
//        fillData.setName("张三");
//        fillData.setNumber(5.2);
//        EasyExcel.write(fileName).withTemplate(templateFileName).sheet().doFill(fillData);
//
//        // 方案2 根据Map填充
////        fileName = TestFileUtil.getPath() + "simpleFill" + System.currentTimeMillis() + ".xlsx";
////        // 这里 会填充到第一个sheet， 然后文件流会自动关闭
////        Map<String, Object> map = MapUtils.newHashMap();
////        map.put("name", "张三");
////        map.put("number", 5.2);
////        EasyExcel.write(fileName).withTemplate(templateFileName).sheet().doFill(map);
//    }
//}
