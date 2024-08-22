package com.sh.monitor.common.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class AutoSeleniumUtil {

    public static WebDriver getWebDriver(String chromeDriverPath) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        // 创建ChromeOptions对象
        ChromeOptions options = new ChromeOptions();
        // 添加启动参数
//        options.addArguments("--start-minimized"); // 最大化窗口
//        options.addArguments("--disable-extensions"); // 禁用扩展
//        options.addArguments("--incognito"); // 无痕浏览模式
//        options.addArguments("--disable-popup-blocking"); // 禁用弹窗阻止
//        options.addArguments("--disable-notifications"); // 禁用通知
//        options.addArguments("--disable-infobars"); // 禁用信息栏
//        options.addArguments("--no-sandbox"); // 不使用沙箱模式 (仅适用于Linux)
//        options.addArguments("--disable-dev-shm-usage"); // 解决Linux沙箱问题
        WebDriver driver = null;
        try {
            driver = new ChromeDriver(options);
        } catch (Exception e) {
        }
        return driver;
    }

    /**
     * 生成主键UUID
     *
     * @return
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }

    /**
     * 得到当前的计算机日期时间 如 yyyymmddhhmmsssss Add by sunzuolei
     *
     * @return
     */
    public static String getBusinessDateTime() {

        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }

    /**
     * 计算两个Date对象之间相差的分钟数。
     *
     * @param date1 第一个Date对象
     * @param date2 第二个Date对象
     * @return 两个Date对象之间相差的分钟数
     */
    public static long minutesBetween(Date date1, Date date2) {
        // 将Date转换为Instant
        Instant instant1 = date1.toInstant();
        Instant instant2 = date2.toInstant();

        // 计算两个Instant之间的Duration
        Duration duration = Duration.between(instant1, instant2);

        // 返回相差的分钟数
        return Math.abs(duration.toMinutes());
    }
}
