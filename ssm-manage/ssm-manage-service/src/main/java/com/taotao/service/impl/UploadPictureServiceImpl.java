package com.taotao.service.impl;

import com.jcraft.jsch.ChannelSftp;
import com.taotao.common.utils.IDUtils;
import com.taotao.common.utils.SFTPUtils;
import com.taotao.service.UploadPictureService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片上传服务
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/11 5:05.
 */
@Service
public class UploadPictureServiceImpl implements UploadPictureService {
    @Value("${sftp_host}")
    private String host;
    @Value("${sftp_port}")
    private int post;
    @Value("${sftp_username}")
    private String username;
    @Value("${sftp_password}")
    private String password;
    @Value("${sftp_upload_directory}")
    private String directory;
    @Value("${image_base_url}")
    private String image_base_url;

    @Override
    public Map uploadPicture(MultipartFile uploadFile) {
        Map resultMap = new HashMap<>();
        try {
            //取出老的文件名
            String oldName = uploadFile.getOriginalFilename();
            //生成新的文件名
            // UUID.randomUUID();
            String newName = IDUtils.genImageName();
            newName = newName + oldName.substring(oldName.lastIndexOf("."));
            //图片上传
            ChannelSftp connect = SFTPUtils.connect(host, post, username, password);

            String imagepath = new DateTime().toString("/yyyy/MM/dd");
            boolean result = SFTPUtils.upload(directory, imagepath, newName, uploadFile.getInputStream(), connect);
            if (!result) {
                resultMap.put("error", 1);
                resultMap.put("message", "文件上传失败了");
                return resultMap;
            }
            resultMap.put("error", 0);
            resultMap.put("url", image_base_url + imagepath + "/" + newName);
            return resultMap;
        } catch (IOException e) {
            resultMap.put("error", 1);
            resultMap.put("message", "文件上传发生异常");
            return resultMap;
        }
    }
}
