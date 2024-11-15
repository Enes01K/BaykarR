package stepdefinition;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BaykarMainPage;
import pages.CareerPage;
import utilities.ChromeDriverClass;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.System.*;

public class BaykarStepDef {
    private static final Logger logger= LoggerFactory.getLogger(BaykarStepDef.class);
    ChromeDriverClass chrome = new ChromeDriverClass();
    BaykarMainPage mainPage = new BaykarMainPage(chrome);
    CareerPage careerPage=new CareerPage(chrome);

    @Given("^Baykar anasayfasi acilir$")
    public void baykar_Sayfasi_acilir() {
        logger.info("ana sayfaya gidiliyor");
        mainPage.openPage("https://baykartech.com/tr/");
        logger.info("navbar elementler gorulene kadar bekleniyor");
        WebDriverWait wait = new WebDriverWait(chrome.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(mainPage.navbarlistoptionOne.get(0)));
        logger.info("ana sayfadaki hakkimizda elementi goruldu");

        assert mainPage.navbarlistoptionOne.get(1).isDisplayed();
        logger.info("ana sayfadaki neler yapıyoruz elementi goruldu");

    }

    @Then("Navbar elementlerin tiklanabilirliginin kontrolu yapilir")
    public void navbarElementlerinTiklanabilirligininKontroluYapilir() throws InterruptedException {
      
        int j;
        for (int i = 0; i < mainPage.navbarlistoptionOne.size(); i++) {
            Actions actions = new Actions(chrome.getDriver());
            actions.moveToElement(mainPage.navbarlistoptionOne.get(i)).click().perform();
            logger.info("şu elemente tiklaniyor: "+mainPage.navbarlistoptionOne.get(i).getText());

            for( j=0;j<mainPage.subnavbarelements.size();j++){
                mainPage.subnavbarelements.get(j).click();
                logger.info("şu elemente tiklaniyor: "+mainPage.subnavbarelements.get(j).getText());
                if(chrome.getDriver().getCurrentUrl()!="https://baykartech.com/tr/"){
                    chrome.getDriver().navigate().back();
                    actions.moveToElement(mainPage.navbarlistoptionOne.get(i)).click().perform();
                    Thread.sleep(10000);
                }


            }
            Thread.sleep(10000);
            if(chrome.getDriver().getCurrentUrl()!="https://baykartech.com/tr/"){
                String url="https://baykartech.com/tr/";
                mainPage.openPage(url);
                Thread.sleep(10000);
            }
            else {
                chrome.getDriver().navigate().back();
                Thread.sleep(10000);

            }
            Thread.sleep(5000);
            logger.info("detaya tiklandi");
        }

    }

    @Then("navbardaki tum elementlere tiklandi ve siteden ayrildik")
    public void navbardakiTumElementlereTiklandiVeSitedenAyrildik() {
        mainPage.closePage();
    }
    @Given("Baykar kariyer sayfasi acilir")
    public void baykarKariyerSayfasiAcilir() {
        careerPage.openPage("https://kariyer.baykartech.com/tr/");
        logger.info("navbar elementler gorulene kadar bekleniyor");
        WebDriverWait wait = new WebDriverWait(chrome.getDriver(), Duration.ofSeconds(30));
    }
    @Then("Navbar elementlerinin türkçe halleri kayıt edilir ve ingilizceleriyle karsilastirilir")
    public void navbarElementlerininTurkceHalleriKayitEdilir() throws InterruptedException {

        List<String> textlist=new ArrayList<>();
        for(int i=0;i<careerPage.navbarturkcelistesi.size();i++){
            System.out.println(textlist.add(careerPage.navbarturkcelistesi.get(i).getText()));

        }
        //elementlerin ingilizcesini listeye koyma
        List<String> englishOptions = new ArrayList<>();
        englishOptions.add("OPEN POSITIONS");
        englishOptions.add("INTERNSHIP");
        englishOptions.add("FAQ");
        englishOptions.add("BAYKAR");
        englishOptions.add("LOGIN");

        careerPage.language.click();
        Thread.sleep(5000);
        List<String> translatelist=new ArrayList<>();
        for(int i=0;i<careerPage.navbarturkcelistesi.size();i++){
            translatelist.add(careerPage.navbarturkcelistesi.get(i).getText());

        }
        for(int i=0;i<careerPage.navbarturkcelistesi.size();i++){
            out.println("site üzerindeki türkce kelime:"+ textlist.get(i)+
                    "\n olmasi gereken cevirisi:" +englishOptions.get(i)+
                    "\n site üzerindeki cevirisi:"+translatelist.get(i));
            if(englishOptions.get(i).equals(translatelist.get(i))){
                out.println("site üzerindeki türkce kelime:"+ textlist.get(i)+" kelimesinin cevirisi dogrudur\n");

            }


        }
        careerPage.closePage();


    }


}

