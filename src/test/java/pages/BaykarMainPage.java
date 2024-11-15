package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ChromeDriverClass;

import java.util.List;

public class BaykarMainPage {
    ChromeDriverClass chrome;

    @FindBy(xpath = "(//a[@class='nav-item nav-link'])")
    public List<WebElement> navbarlistoptionOne;
    @FindBy(xpath = "//a[@class='mega-link']")
    public List<WebElement> subnavbarelements;
    public BaykarMainPage(ChromeDriverClass chrome) {
        this.chrome = chrome;
        PageFactory.initElements(chrome.getDriver(), this);
    }

    public void openPage(String url) {
        chrome.openUrl(url);
    }

    public void closePage() {
        chrome.closeDriver();
    }
}
