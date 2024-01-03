package cn.devcorp.demo.controller;

import cn.devcorp.demo.pojo.User;
import cn.devcorp.demo.result.GeneralCode;
import cn.devcorp.demo.result.JsonResult;
import cn.devcorp.demo.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/16 21:14
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@RestController("userController")
@Slf4j
public class UserController {
    @PostMapping("/listUser")
    public JsonResult<User> listUser(@Valid @RequestBody UserVo userVo){
        System.out.println(userVo.getName());
        User user = new User();
        BeanUtils.copyProperties(userVo,user);
        user.setAge(18);
        Throwable e = new RuntimeException();
        log.info("inputParams: {} and errorMessage: {}", user.toString(), e.getMessage(), e);
        return JsonResult.getInstant(200,"good",user);
    }
    @GetMapping("/download1")
    @ResponseBody
    public void download1(HttpServletResponse response){
        FileInputStream fileInputStream = null;
        ServletOutputStream outputStream = null;
        try {
            // 这个文件名是前端传给你的要下载的图片的id
            // 然后根据id去数据库查询出对应的文件的相关信息，包括url，文件名等
            String  fileName = "楠老师.jpg";

            //1、设置response 响应头，处理中文名字乱码问题
            response.reset(); //设置页面不缓存,清空buffer
            response.setCharacterEncoding("UTF-8"); //字符编码
            response.setContentType("image/png"); //二进制传输数据
            //设置响应头，就是当用户想把请求所得的内容存为一个文件的时候提供一个默认的文件名。
            //Content-Disposition属性有两种类型：inline 和 attachment
            //inline ：将文件内容直接显示在页面
            //attachment：弹出对话框让用户下载具体例子：
            response.setHeader("Content-Disposition",
                    "attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));

            // 通过url获取文件
            File file = new File("C:\\Users\\spark\\Pictures\\2.png");
            fileInputStream = new FileInputStream(file);
            outputStream = response.getOutputStream();

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,len);
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if( fileInputStream != null ){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if( outputStream != null ){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @GetMapping("/download2")
    public ResponseEntity<byte[]> download2(){
        try {
            String fileName = "楠老师.jpg";
            byte[] bytes = FileUtils.readFileToByteArray(new File("D:/upload/"+fileName));
            HttpHeaders headers=new HttpHeaders();
            // Content-Disposition就是当用户想把请求所得的内容存为一个文件的时候提供一个默认的文件名。
            headers.set("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));
            headers.set("charsetEncoding","utf-8");
            headers.set("content-type","multipart/form-data");
            ResponseEntity<byte[]> entity=new ResponseEntity<>(bytes,headers, HttpStatus.OK);
            return entity;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
