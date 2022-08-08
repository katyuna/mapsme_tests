package mapsme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import mapsme.po.MainScreen;
import mapsme.po.SearchBottomSheet;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static URL url;
    protected static DesiredCapabilities capabilities;
    protected static AndroidDriver driver;

    @BeforeAll
    static void init() throws MalformedURLException {
        //URL
        url = new URL("http://127.0.0.1:4723/wd/hub");
        //CAPABILITIES
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("noReset", true);
        /*Xiaomi Mi 9 SE*/
        //capabilities.setCapability("deviceName", "Xiaomi Mi 9 SE"); //f0c565e9
        //capabilities.setCapability("udid", "f0c565e9");
        /*samsung SM M215F*/
        //capabilities.setCapability("deviceName", "samsung SM M215F");  //R58R102ZDMT
        //capabilities.setCapability("udid", "R58R102ZDMT");
        /*Emulator*/
        capabilities.setCapability("deviceName", "Pixel 2 API 31 2");
        capabilities.setCapability("udid", "emulator-5554");
        //googleRelease
        capabilities.setCapability("appPackage", "com.mapswithme.maps.pro");
        capabilities.setCapability("appActivity", "com.mapswithme.maps.MainActivity");
        //debug
        //capabilities.setCapability("appPackage", "com.mapswithme.maps.pro.kode.debug");
        //capabilities.setCapability("appActivity", "com.mapswithme.maps.MainActivity");
        //DRIVER
        driver = new AndroidDriver(url, capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            /*driver.resetApp();
            if(driver.findElement(By.xpath(".//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")).isDisplayed()){
                driver.findElement(By.xpath(".//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")).click();
             }
            if (driver.findElement(By.xpath(".//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")).isDisplayed()){
                driver.findElement(By.xpath(".//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")).click();
            }*/
    }


}
