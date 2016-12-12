package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * Created by ustcck on 2016/12/11 5:02.
 */
public interface UploadPictureService {
    Map uploadPicture(MultipartFile uploadFile);
}
