package com.sh.monitor.common.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TrafficMonitor{
    public static void main(String[] args) {
        String chromeDriverPath = "C:\\Users\\袁振\\Desktop\\springaaa\\spring-boot-monitor\\src\\main\\resources\\drivers\\chromedriver.exe"; // 从类路径获取

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);


        // 创建ChromeOptions对象
        ChromeOptions options = new ChromeOptions();

        // 添加启动参数
        options.addArguments("--start-maximized"); // 最大化窗口
        options.addArguments("--disable-extensions"); // 禁用扩展
        options.addArguments("--incognito"); // 无痕浏览模式
        options.addArguments("--disable-popup-blocking"); // 禁用弹窗阻止
        options.addArguments("--disable-notifications"); // 禁用通知
        options.addArguments("--disable-infobars"); // 禁用信息栏
        options.addArguments("--no-sandbox"); // 不使用沙箱模式 (仅适用于Linux)
        options.addArguments("--disable-dev-shm-usage"); // 解决Linux沙箱问题
        options.addArguments("--remote-allow-origins=*"); // 允许远程源 (适用于Chrome 100+)

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://ydopenapi.com.cn/admin/#/login");
//        driver.get("http://192.168.110.102:19994/#/login");

//        WebElement usernameField = driver.findElement(By.name("username"));
//        WebElement passwordField = driver.findElement(By.name("password"));
//        WebElement submitButton = driver.findElement(By.name("submit"));
        ;
        WebElement usernameField = driver.findElement(By.id("details-button"));
        usernameField.click();
        WebElement element = driver.findElement(By.id("proceed-link"));
        element.click();
        WebElement element2 = driver.findElement(By.name("username"));
        element2.sendKeys("openapi_admin");

//        WebElement element3 = driver.findElement(By.xpath("//*[@type='password']"));
        WebElement element3 = driver.findElement(By.cssSelector("input[type='password']"));
        element3.clear();
        element3.sendKeys("1qaz@WSX");

//        element3.sendKeys("1qaz@WSX");

//        usernameField.sendKeys("openapi_admin");
//        passwordField.sendKeys("1qaz@WSX");
//        submitButton.click();

        // 获取验证码图片
//        WebElement captchaImageElement = driver.findElement(By.id("captcha_image"));
//        String captchaImageUrl = captchaImageElement.getAttribute("src");
//
//        // 发送验证码图片到OCR服务
////        String captchaText = sendCaptchaToOCRService(captchaImageUrl);
//        String captchaText = "";
//
//        // 填入验证码
//        WebElement captchaField = driver.findElement(By.name("captcha"));
//        captchaField.sendKeys(captchaText);
//
//        WebElement successMessage = driver.findElement(By.id("success_message"));
//        if (successMessage != null) {
//            System.out.println("Login successful.");
//        } else {
//            System.out.println("Login failed.");
//        }
    }
}