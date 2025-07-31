package local.example.controller;

import local.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import local.example.utils.AliyunOSSOperator;

@Slf4j
@RestController
@RequestMapping("/upload")
@SuppressWarnings("all")
public class UploadController {
    @Autowired
    AliyunOSSOperator aliyunOSSOperator;

    private static final String projectPath = System.getProperty("user.dir"); // 项目路径
    private static final String modulePath = "/tlias-web-management"; // 模块路径
    private static final String uploadPath = "/src/main/resources/static/image/"; // 上传路径

    @PostMapping("/local")
    public Result uploadToLocal(@RequestParam("image") MultipartFile file) throws IOException {
        log.info("上传文件：{}", file);
        String fileName = file.getOriginalFilename();
        assert fileName != null;
        String extension = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString().replace("-", "") + extension;
        file.transferTo(new File(projectPath + modulePath + uploadPath + newFileName));
        return Result.success();
    }

    @PostMapping("/remote")
    public Result uploadToAliyun(@RequestParam("image") MultipartFile file) throws Exception {
        log.info("上传文件：{}", file);
        String filename = file.getOriginalFilename();
        assert filename != null;
        String extension = filename.substring(filename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString().replace("-", "") + extension;
        String url = aliyunOSSOperator.upload(file.getBytes(), newFileName);
        return Result.success(url);
    }
}
