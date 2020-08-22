package com.example.hbhims.controller;

import com.example.hbhims.common.entity.JsonResult;
import com.example.hbhims.common.utils.ResultTool;
import com.example.hbhims.service.UploadService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 19622
 */
@Controller
@RequestMapping("file")
public class FileController {

    private final UploadService uploadService;

    public FileController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @GetMapping(value = "download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<InputStreamResource> download(
            @RequestParam String path,
            @RequestParam String fileName
    ) throws IOException {
        if (!path.endsWith("/")) {
            path += "/";
        }
        String filePath = path + fileName;
        FileSystemResource file = new FileSystemResource(filePath);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=%s", fileName));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(file.getInputStream()));
    }

    @PutMapping(value = "upload", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JsonResult<?> upload(
            @RequestBody MultipartFile file,
            @RequestParam("path") String path,
            @RequestParam("fileName") String fileName
    ) {
        if (path.endsWith("/")) {
            path += "/";
        }
        uploadService.uploadOneFile(path, "", fileName, "", file);
        return ResultTool.success("http://47.100.91.123:415/file/download?path=" + path + "&fileName=" + fileName);
    }
}
