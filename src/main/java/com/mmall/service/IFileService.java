package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Timber
 * @date 2018/10/14
 */

public interface IFileService {

    /**
     * 上传图片文件
     * @param file 文件
     * @param path 路径
     * @return String
     */
    String upload(MultipartFile file, String path);
}
