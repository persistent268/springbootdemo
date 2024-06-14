//package cn.devcorp.demo.controller;
//
//import cn.devcorp.demo.result.JsonResult;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.math3.util.Pair;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.math.BigDecimal;
//
///**
// * Description: TODO
// *
// * @author YK107
// * @date 2024/4/13 12:59
// *
// * <pre>
// *              www.cloudscope.cn
// *      Copyright (c) 2019. All Rights Reserved.
// * </pre>
// */
//@RestController
//@Slf4j
//public class PDDDoucmentController {
//    @GetMapping("pdf")
//    public JsonResult get() throws IOException {
//        FileInputStream inputStream = new FileInputStream("C:\\Users\\spark\\Desktop\\20.pdf");
//        PDDocument document = PDDocument.load(inputStream);
//        PDPage firstPage = document.getPage(0);
//        final float width = firstPage.getMediaBox().getWidth();
//        final float height = firstPage.getMediaBox().getHeight();
//        log.info("PDF宽度:{} ", width);
//        log.info("PDF高度:{} ", height);
//        return JsonResult.getInstant(200, "success");
//    }
//}
