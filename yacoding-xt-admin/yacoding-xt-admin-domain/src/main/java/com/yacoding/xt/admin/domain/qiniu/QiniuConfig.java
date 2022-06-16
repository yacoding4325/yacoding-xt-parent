package com.yacoding.xt.admin.domain.qiniu;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Author yaCoding
 * @create 2022-05-08 下午 9:10
 */

@Configuration
@Data
public class QiniuConfig {

    @Value("${qiniu.file.server.url}")
    private String fileServerUrl;

    @Value("${qiniu.accessKey}")
    private String accessKey;
    @Value("${qiniu.accessSecret}")
    private String accessSecret;
    @Value("${qiniu.bucket}")
    private String bucket;
}
