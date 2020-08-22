package com.example.hbhims.service.impl;

import com.example.hbhims.exception.FileUploadException;
import com.example.hbhims.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 19622
 */
@Service
public class UploadServiceImpl implements UploadService {

    private File createFile(String pathName) {
        File file = new File(pathName);
        if (!file.getParentFile().exists()) {
            if (!file.getParentFile().mkdirs()) {
                throw new FileUploadException("创建文件失败");
            }
        }
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    return file;
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new FileUploadException("创建文件失败");
            }
        }
        return file;
    }

    private void writeToFile(String pathName, MultipartFile multipartFile) {
        File file;
        try {
            file = createFile(pathName);
        } catch (Exception e) {
            throw new FileUploadException("创建文件失败");
        }
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileUploadException("服务器繁忙");
        }
    }

    @Override
    public void uploadOneFile(String path, String filePrefix, String fileName, String fileSuffix, MultipartFile multipartFile) {
        // 文件路径
        String pathName = path + filePrefix + fileName + fileSuffix;
        System.out.println("文件路径" + pathName);
        // 创建文件夹和文件，写入文件
        writeToFile(pathName, multipartFile);
    }

}
