package local.example.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
@SuppressWarnings("all")
public class AliyunOSSProperties {
    private String endpoint;
    private String bucketName;
    private String region;
}