import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestNGallTypes {

    AndroidDriver driver;
    Dimension dim;

    // 🔥 1. Sab se pehle – Suite level
    @BeforeSuite
    public void startSuite() {
        System.out.println("===== Test Suite Started =====");
        // Appium server start (agar manual nahi hai)
    }

    // 🔥 2. Test level
    @BeforeTest
    public void prepareDevice() {
        System.out.println("Prepare Android device for Vidfo Player");
    }

    // 🔥 3. Class level – App launch
    @BeforeClass
    public void launchApp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // 🔴 Appium 2 required
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:deviceName", "Android Device");
        caps.setCapability("appium:appPackage", "vidfo.video.player.videoplayer");
        caps.setCapability("appium:appActivity", "com.example.vidfo.ui.activity.MainActivity");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/wd/hub"), caps);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        dim = driver.manage().window().getSize();

        System.out.println(">>>> Vidfo Video Player Launched");
    }

    // 🔥 4. Har test se pehle
    @BeforeMethod
    public void beforeEachTest() {
        System.out.println("Navigate to Home Screen / Stop any playback");
        // Example: back press / stop video
    }

    // ================== TEST CASES ==================

    @Test(priority = 1, description = "Verify app launch")
    public void verifyAppLaunch() {
        System.out.println("Verify Vidfo app launched successfully");
    }

    @Test(priority = 2, description = "Play video")
    public void playVideoTest() {
        System.out.println("Play a local video and verify playback");
        // driver.findElement(...).click();
    }

    @Test(priority = 3, description = "Pause and resume video")
    public void pauseResumeVideoTest() {
        System.out.println("Pause and resume video playback");
    }

    // =================================================

    // 🔥 5. Har test ke baad
    @AfterMethod
    public void afterEachTest() {
        System.out.println("Stop video playback");
        // Screenshot on failure (future)
    }

    // 🔥 6. Class end
    @AfterClass
    public void closeApp() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println(">>>> Vidfo App Closed");
    }

    // 🔥 7. Test end
    @AfterTest
    public void afterTest() {
        System.out.println("Cleanup after test execution");
    }

    // 🔥 8. Suite end
    @AfterSuite
    public void endSuite() {
        System.out.println("===== Test Suite Finished =====");
        // Appium server stop
    }
}
