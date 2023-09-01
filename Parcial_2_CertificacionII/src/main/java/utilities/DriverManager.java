package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class DriverManager {
    private static DriverManager instance;
    public WebDriver driver;

    private DriverManager()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    public static DriverManager getDriver()
    {
        if(instance==null)
        {
            instance = new DriverManager();
        }
        return instance;
    }
    public static void switchToNextWindow()
    {
        Set<String> windowHandles = DriverManager.getDriver().driver.getWindowHandles();
        for (String handle : windowHandles)
        {
            if (!handle.equals(DriverManager.getDriver().driver.getWindowHandle()))
            {
                DriverManager.getDriver().driver.switchTo().window(handle);
                break;
            }
        }
    }
    public static void closeAndSwitchToPreviousWindow() {
        WebDriver driver = DriverManager.getDriver().driver;
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                driver.switchTo().window(handle);
                driver.close();
                driver.switchTo().window(currentWindowHandle);
                break;
            }
        }
    }
    public static String getCurrentURL()
    {
        return DriverManager.getDriver().driver.getCurrentUrl();
    }
    public static void closeAllWindows()
    {
        for (String handle : DriverManager.getDriver().driver.getWindowHandles())
        {
            DriverManager.getDriver().driver.switchTo().window(handle);
            DriverManager.getDriver().driver.close();
        }
    }
}
