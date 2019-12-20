package com.web.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

/**
 * @author lhj
 * @date 2019/12/18 18:23
 */
@RestController
//@MultipartConfig
public class MultipartFileController {


    @PostMapping("/up")
    public void upload(MultipartFile file){
        try {
            InputStream inputStream = file.getInputStream();


            String originalFilename = file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @PostMapping("/upload")
    public void uploadFile(HttpServletRequest request, HttpServletResponse response){


        //创建目录
        File path = new File("D:\\tmp");
        if (!path.exists()) {
            path.mkdir();
        }
            try {
            Part file = request.getPart("file");
                String submittedFileName = path.getPath() + File.separator + file.getSubmittedFileName();
                file.write(submittedFileName);
                response.setContentType("application/x-download");
                response.addHeader("Content-Disposition", "attachment;filename="+new String( submittedFileName.getBytes("utf-8"), "ISO8859-1" )+".jpg");
                OutputStream out = response.getOutputStream();
                out.flush();
                response.flushBuffer();
            } catch (Exception e) {
                System.err.println("文件名称异常");
        }

    }
}
