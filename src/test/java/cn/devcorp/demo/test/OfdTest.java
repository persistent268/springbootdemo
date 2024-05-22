package cn.devcorp.demo.test;

import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfImportedPage;
import org.junit.jupiter.api.Test;
import org.ofdrw.converter.ConvertHelper;
import org.ofdrw.converter.ofdconverter.DocConverter;
import org.ofdrw.converter.ofdconverter.PDFConverter;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Description: TODO
 *
 * @author YK107
 * @date 2024/4/24 10:13
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@SpringBootTest
public class OfdTest {
    @Test
    public void testPdfToOfd() throws Exception {
        Path src = Paths.get("C:\\Users\\spark\\Desktop\\150ye.pdf");
        Path dst = Paths.get("target/convert.ofd");
        try (PDFConverter converter = new PDFConverter(dst)) {
            converter.convert(src);
        }
        System.out.println(">> " + dst.toAbsolutePath());
    }
}
