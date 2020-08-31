package com.xzsd.pc.imageUpLoad.service;
import com.neusoft.core.restful.AppResponse;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import com.xzsd.pc.imageUpLoad.entity.Image;
import com.xzsd.pc.util.RandomCode;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * 图片上传处理
 */
@Service
public class ImageService {
    /**
     * image 上传
     * @return
     */
    public AppResponse upLoadImage(MultipartFile uploadFile) throws IOException {
        // 获取文件名
        String fileName = uploadFile.getOriginalFilename();
        // 获取文件后缀
        String prefix=fileName.substring(fileName.lastIndexOf("."));
        // 用uuid作为文件名，防止生成的临时文件重复
        File toFile = File.createTempFile(RandomCode.radmonkey(),prefix);
        uploadFile.transferTo(toFile);
        if(null == toFile){
            AppResponse.bizError("请选择文件");
        }
        //
        // 1 初始化用户身份信息（secretId, secretKey）。
        String secretId = "AKIDJOFs76oZv0rVO8dO9euvnQo1JOCk3A3g";
        String secretKey = "p67LUMyKPYS6XhC7rNdfQ3RglcERQ8g1";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-guangzhou");
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        //获得文件地址
        // 指定要上传的文件
        // 指定要上传到的存储桶
        String bucketName = "image-1300367685";
        // 指定要上传到 COS 上对象键
        String key = fileName;
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, toFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        // 关闭客户端(关闭后台线程)
        Image image = new Image();
        image.setUploadTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        URL url = cosClient.generatePresignedUrl(bucketName, key, expiration);
        image.setImageUrl(url.toString());
        cosClient.shutdown();
        return AppResponse.success("上传成功!",image);
    }
}
