package com.bupt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author czgggggggg
 * @Date 2021/12/9
 * @Description
 */
@Controller
public class FileUploadController {
    @Value("${file.upload.directory}")
    String directory;

    @RequestMapping("file/upload")
    public String fileUpload(MultipartFile myfile) throws IOException {
        String originalFilename = myfile.getOriginalFilename();  //上传的文件的名称（包含后缀）
        String name = myfile.getName(); //myfile

        //以file来接收我们的multipartfile
        File file = new File(directory, originalFilename);
        myfile.transferTo(file);

        return "/WEB-INF/view/ok.jsp";
    }
}
