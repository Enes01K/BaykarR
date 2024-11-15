package utilities;

import io.cucumber.java.AfterAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverClass {
    private WebDriver driver;

    public ChromeDriverClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
