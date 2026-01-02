import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppOpenSample {

    AndroidDriver driver;
    Dimension dim;

    @BeforeClass
    public void StartApp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        // 🔴 VERY IMPORTANT for Appium 2
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:deviceName", "Android Device"); //Your Device Name
        caps.setCapability("appium:appPackage", "vidfo.video.player.videoplayer"); //Your App Package Name
        caps.setCapability("appium:appActivity", "com.example.vidfo.ui.activity.MainActivity"); //Your App Activity Name

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/wd/hub"), caps);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        dim = driver.manage().window().getSize();

        System.out.println(">>>> App Started Successfully ....");
    }
    @AfterClass
    public void StopApp() throws InterruptedException {
        if (driver != null) {
            System.out.println(">>>> App Close Successfully");
            Thread.sleep(10000);
            driver.quit();
        }
    }

}