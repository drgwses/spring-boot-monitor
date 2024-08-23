package com.sh.monitor.controller;

import com.sh.monitor.common.util.AutoSeleniumUtil;
import com.sh.monitor.common.util.OCRUtils;
import com.sh.monitor.entity.SysMonitorConfig;
import com.sh.monitor.entity.SysMonitorLog;
import com.sh.monitor.mapper.SysMonitorConfigDao;
import com.sh.monitor.mapper.SysMonitorLogDao;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.image.BufferedImage;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/qylnkfpt")
@Slf4j
public class QynlkfptController {

    @Value("${chromeDriverPath}")
    private String chromeDriverPath;

    public static ConcurrentHashMap<String, WebDriver> driverCache = new ConcurrentHashMap<>();

    public static Date sucDate;

    public static Date failDate;


    @Autowired
    private SysMonitorLogDao sysMonitorLogDao;

    @Autowired
    private SysMonitorConfigDao sysMonitorConfigDao;

    @RequestMapping(value = "start", method = RequestMethod.POST)
    public void start(SysMonitorConfig sysMonitorConfig) {
        try {
            // 循环5次
            for (int i = 0; i < 5; i++) {
                if (i > 0) { // 只有在第一次之后才需要等待
                    Thread.sleep(10000);
                }
                startRun(sysMonitorConfig);
            }
        } catch (InterruptedException e) {
            // 如果Thread.sleep()被中断
            Thread.currentThread().interrupt(); // 恢复中断状态
            throw new RuntimeException("Interrupted during sleep", e);
        } catch (Exception e) {
            // 处理或记录其他类型的异常
            throw new RuntimeException(e);
        }
    }

    public void startRun(SysMonitorConfig sysMonitorConfig) {
        if (null == sysMonitorConfig) {
            log.info("sysMonitorConfig参数为空");
            return;
        }
        if (null != sucDate) {
            long l = AutoSeleniumUtil.minutesBetween(new Date(), sucDate);
            if (l < 30l) {
                log.info("30分种内存在登录登出成功的记录{}", sysMonitorConfig.getSystemCode());
                return;
            }
        }

        if (null != failDate) {
            long l = AutoSeleniumUtil.minutesBetween(new Date(), failDate);
            if (l < 30l) {
                log.info("30分种内存在登录登出失败的记录{}", sysMonitorConfig.getSystemCode());
                return;
            }
        }
        if (driverCache.size() > 5) {
            sysMonitorConfig.setUpdateDate(AutoSeleniumUtil.getBusinessDateTime());
            sysMonitorConfig.setSystemStatus("1");
            int i = sysMonitorConfigDao.updateNotNullSysMonitorConfigById(sysMonitorConfig);
            if (i > 0) {
                SysMonitorLog sysMonitorLog = new SysMonitorLog();
                sysMonitorLog.setId(AutoSeleniumUtil.getUUID());
                sysMonitorLog.setSystemName(sysMonitorConfig.getSystemName());
                sysMonitorLog.setSystemCode(sysMonitorConfig.getSystemCode());
                sysMonitorLog.setMonitorResult("1");
                sysMonitorLog.setFailInfo("未登录登出成功");
                sysMonitorLog.setCreateDate(AutoSeleniumUtil.getBusinessDateTime());
                sysMonitorLog.setIsDeleted("0");
                sysMonitorLog.setSysType("1");
                sysMonitorLogDao.insertNotNullSysMonitorLog(sysMonitorLog);

                log.info("失败次数大于5次{}", sysMonitorConfig.getSystemCode());
                failDate = new Date();
                closeAllDrivers();
                return;
            }
        }
        try {
        log.info(sysMonitorConfig.toJson().toString() + "+任务start正在执行");
        WebDriver driver = AutoSeleniumUtil.getWebDriver(chromeDriverPath);
        driverCache.put(String.valueOf(driver.hashCode()), driver);
        driver.get(sysMonitorConfig.getClientUrl());

        WebElement usernameField = driver.findElement(By.id("details-button"));
        usernameField.click();
        WebElement element = driver.findElement(By.id("proceed-link"));
        element.click();

        WebElement element2 = driver.findElement(By.xpath("//input[@autocomplete='off' and @placeholder='账号']"));
        element2.sendKeys(sysMonitorConfig.getLoggerName());

        WebElement element3 = driver.findElement(By.xpath("//input[@autocomplete='off' and @placeholder='密码']"));

        element3.sendKeys(sysMonitorConfig.getLoggerPassword());

        WebElement element4 = driver.findElement(By.xpath(
                "//img[@data-v-b02c85e0 and contains(@style, 'width: 118px') and contains(@style, 'height: 38px;')]"
        ));
        String base64Image = element4.getAttribute("src");

        BufferedImage bufferedImage = OCRUtils.getBufferedImage(base64Image);
        String ocrString = OCRUtils.getOcrString(bufferedImage);
        System.out.println("ocrString:" + ocrString);
            WebElement element5 = driver.findElement(By.xpath("//input[@autocomplete='off' and @placeholder='验证码']"));
            element5.sendKeys(ocrString);

            // 使用 XPath 定位发送验证码的元素
            WebElement sendVerificationCodeElement = driver.findElement(By.xpath("//button[@type='button' and @style='height: 38px;']"));

            // 单击发送验证码元素
            sendVerificationCodeElement.click();


            // 获取当前窗口句柄
            String originalWindowHandle = driver.getWindowHandle();

            // 等待新窗口打开
            Set<String> windowHandles = driver.getWindowHandles();
            String newWindowHandle = null;
            while (windowHandles.size() == 1) {
                windowHandles = driver.getWindowHandles();
            }

            for (String handle : windowHandles) {
                if (!handle.equals(originalWindowHandle)) {
                    newWindowHandle = handle;
                    break;
                }
            }
            // 切换到新窗口
            driver.switchTo().window(newWindowHandle);

            WebDriverWait wait2 = new WebDriverWait(driver, 10); // 设置最大等待时间为 10 秒
            WebElement h1Element = wait2.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));

            // 获取 <h1> 元素中的文本
            String h1Text = h1Element.getText();


//
//            // 切换回原始窗口
            driver.switchTo().window(originalWindowHandle);

            WebElement element6 = driver.findElement(By.xpath("//input[@autocomplete='off' and @placeholder='短信验证码']"));
            element6.sendKeys(h1Text);


            WebElement element7 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[4]/button"));
            element7.click();

            Wait<WebDriver> waita = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(5)) // Wait for up to 5 seconds
                    .pollingEvery(Duration.ofMillis(500)) // Poll every 500 milliseconds
                    .ignoring(NoSuchElementException.class);

            try {
                WebElement errorMessageBox = waita.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]")));
                String messageContent = errorMessageBox.findElement(By.className("el-message__content")).getText();
                System.out.println("Error message content: " + messageContent);
            } catch (Exception e) {
                System.out.println("The error message box did not appear within the timeout period.");
            }

            try {
                // Set up the WebDriverWait
                WebDriverWait wait = new WebDriverWait(driver, 3);

//                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//                String alertText = alert.getText();
//                System.out.println("The text of the alert is: " + alertText);
//                alert.accept();
            } catch (NoAlertPresentException e) {
                System.out.println("There is no alert available to interact with.");
            } finally {
//                log.info("end driver quit end finally");
//                closeAllDrivers();
            }

            Thread.sleep(2000);

            WebDriverWait wait9 = new WebDriverWait(driver, 10); // 设置最大等待时间为 10 秒
            WebElement endElement = wait9.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div")));
            endElement.click();
            Thread.sleep(2000);
            WebDriverWait wait3 = new WebDriverWait(driver, 10); // 设置最大等待时间为 10 秒
            WebElement logoutSpan = wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ul/li[2]/span")));
            logoutSpan.click();
            log.info("end suc driver quit end 执行第{}次成功了", driverCache.size());

            SysMonitorLog sysMonitorLog2 = new SysMonitorLog();
            sysMonitorLog2.setId(AutoSeleniumUtil.getUUID());
            sysMonitorLog2.setSystemName(sysMonitorConfig.getSystemName());
            sysMonitorLog2.setSystemCode(sysMonitorConfig.getSystemCode());
            sysMonitorLog2.setMonitorResult("0");
            sysMonitorLog2.setCreateDate(AutoSeleniumUtil.getBusinessDateTime());
            sysMonitorLog2.setIsDeleted("0");
            sysMonitorLog2.setSysType("1");
            sysMonitorLogDao.insertNotNullSysMonitorLog(sysMonitorLog2);
            //更新检测状态
            sysMonitorConfig.setUpdateDate(AutoSeleniumUtil.getBusinessDateTime());
            sysMonitorConfig.setSystemStatus("0");
            int i = sysMonitorConfigDao.updateNotNullSysMonitorConfigById(sysMonitorConfig);
            if (i > 0) {
                log.info("end suc driver quit end 更新检测状态成功{}", sysMonitorConfig.getSystemCode());
                sucDate = new Date();
            }
            closeAllDrivers();
        } catch (Exception e) {
            log.info("selenium end exection:{}",e.getMessage());
            if (e.getMessage().contains("服务器异常")){
                sysMonitorConfig.setUpdateDate(AutoSeleniumUtil.getBusinessDateTime());
                sysMonitorConfig.setSystemStatus("1");
                int i = sysMonitorConfigDao.updateNotNullSysMonitorConfigById(sysMonitorConfig);
                if (i > 0) {
                    SysMonitorLog sysMonitorLog = new SysMonitorLog();
                    sysMonitorLog.setId(AutoSeleniumUtil.getUUID());
                    sysMonitorLog.setSystemName(sysMonitorConfig.getSystemName());
                    sysMonitorLog.setSystemCode(sysMonitorConfig.getSystemCode());
                    sysMonitorLog.setMonitorResult("1");
                    sysMonitorLog.setFailInfo("服务器异常");
                    sysMonitorLog.setCreateDate(AutoSeleniumUtil.getBusinessDateTime());
                    sysMonitorLog.setIsDeleted("0");
                    sysMonitorLog.setSysType("1");
                    sysMonitorLogDao.insertNotNullSysMonitorLog(sysMonitorLog);
                    log.info("服务器异常：{}", sysMonitorConfig.getSystemCode());
                    failDate = new Date();
                    closeAllDrivers();
                    return;
                }
            }
            e.printStackTrace();
        }
    }


    private void closeAllDrivers() {
        if (driverCache.size() > 0) {
            driverCache.forEach((key, value) -> {
                value.quit();
            });
        }
        driverCache.clear();
    }
}
