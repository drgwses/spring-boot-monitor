package com.sh.monitor.common.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.util.Base64Utils;
import top.gcszhn.d4ocr.OCREngine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

public class OCRUtils {
    /**
     * 将base64编码的图像进行解码
     *
     * @param base64 编码字符串
     * @return 解码产生的图像实例
     */
    public static BufferedImage getBufferedImage(String base64) {
        // 移除 "data:image/jpeg;base64," 前缀
        String base64Data = base64.substring(base64.indexOf(",") + 1);
        // 解码 Base64 数据
//        byte[] decodedBytes = Base64Utils.decodeFromString(base64);
        byte[] decodedBytes = Base64.decodeBase64(base64Data);
//        byte[] decodedBytes = Base64.getDecoder().decode(base64Data);

        // 创建临时文件
        File tempFile = null;
        try {
            tempFile = File.createTempFile("temp", ".jpeg");
            // 将字节写入文件
            Files.write(tempFile.toPath(), decodedBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 从文件读取 BufferedImage
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(tempFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 清理临时文件
        if (tempFile != null) {
            boolean deleted = tempFile.delete();
            if (!deleted) {
                tempFile.deleteOnExit();
            }
        }

        return bufferedImage;
    }

    public static String getOcrString(BufferedImage var1) {
        OCREngine engine = OCREngine.instance();
        String result = engine.recognize(var1);
        return result;
    }

    /**
     * @Description: 将base64编码字符串转换为图片
     * @Author:
     * @CreateTime:
     * @param imgStr base64编码字符串
     * @param path 图片路径-具体到文件
     * @return
     */
    public static boolean generateImage(String imgStr, String path) {
        if (imgStr == null)
            return false;
        byte[] b = Base64Utils.decodeFromString(imgStr);
        try {
            // 解密
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(path);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void main(String[] args) {
        String path="C:\\1.jpg";
        String imgStr="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";
        boolean b = generateImage(imgStr, path);
        System.out.println(b);
    }
}
