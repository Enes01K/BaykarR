package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ChromeDriverClass;

import javax.xml.xpath.XPath;
import java.util.List;

public class CareerPage{
    ChromeDriverClass chrome;
    @FindBy(xpath = "//a[@class='nav-link']")
    public List<WebElement> navbarturkcelistesi;
    @FindBy(xpath = "//*[@class='nav-item  top-btn ']")
    public WebElement language;
    public CareerPage(ChromeDriverClass chrome) {
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
