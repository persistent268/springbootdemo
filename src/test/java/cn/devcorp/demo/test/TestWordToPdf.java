package cn.devcorp.demo.test;

import org.jodconverter.core.DocumentConverter;
import org.jodconverter.core.document.DefaultDocumentFormatRegistry;
import org.jodconverter.core.office.OfficeException;
import org.jodconverter.local.LocalConverter;
import org.jodconverter.local.office.LocalOfficeManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/6/13 13:45
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class TestWordToPdf {
    @Autowired
    private DocumentConverter documentConverter;
    @Test
    public void testWordToPdf(){
        File source = new File("C:\\Users\\spark\\Desktop\\协同办公\\海发设计-数据字典.xlsx");
        File target = new File("C:\\Users\\spark\\Desktop\\数据字典.pdf");
        try {
            // source：源文件，target：转换后的文件
            // word-->pdf
            // ppt-->pdf
            // excel-->html
            documentConverter.convert(source).as(DefaultDocumentFormatRegistry.XLSX).to(target).as(DefaultDocumentFormatRegistry.PDF).execute();
        } catch (OfficeException e) {
            e.printStackTrace();
        }
    }
}
