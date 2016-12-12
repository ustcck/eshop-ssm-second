package com.taotao.controller;

import com.taotao.common.utils.JsonUtils;
import com.taotao.service.UploadPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 上传图片处理
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/11 6:59.
 */
@Controller
public class UploadPictureController {
    @Autowired
    private UploadPictureService uploadPictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String pictureUpload(MultipartFile uploadFile) {
        Map result = uploadPictureService.uploadPicture(uploadFile);
        //为了保证功能的兼容性，需要把map转换为json数据
        String json = JsonUtils.objectToJson(result);
        return json;
    }
}
