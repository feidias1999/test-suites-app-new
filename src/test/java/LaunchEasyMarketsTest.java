import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class LaunchEasyMarketsTest {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        UiAutomator2Options opts = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName("emulator-5554") // check via: adb devices
                .setAppPackage("giniapps.easymarkets.com")
                .setAppActivity("com.easy.MainActivity") // put the exact one you found
                .setNoReset(true)
                .setNewCommandTimeout(Duration.ofSeconds(180));

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), opts);
    }

    @Test
    public void launchAppTest() throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("EasyMarkets launched!");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
