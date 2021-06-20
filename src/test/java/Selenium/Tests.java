package Selenium;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Tests {

    @Test
    public void loginTest() throws Exception {
        String Chrome_Driver_Path="C:\\ChromeDriver\\chromedriver.exe";
        String expectedTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        String url= Variables.BASE_URL;
        Logger log = Logger.getLogger(Tests.class.getName());

        System.setProperty("webdriver.chrome.driver", Chrome_Driver_Path);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(url);
        String actualTitle=driver.getTitle();
        if (actualTitle.contentEquals(expectedTitle)){
            log.info("Right Website is opened");
        } else {
            throw new Exception("Test Failed");
            //System.out.println("Test Failed");
        }
        //Creating object of home page
        LoginPage home = new LoginPage(driver);
        home.enterLogin();
        log.info("UserName and Password is entered");
        home.enterUserName(Variables.userName);
        home.enterPassword(Variables.password);
        home.clickLogin();
        log.info("Searching Huawei ");
        home.search(Variables.searchWord);
        home.clickSearchBtn();
        home.controlSearch();
        log.info("Opening the second page of the site");
        home.clickSecondPage();
        home.checkSecondPage();
        log.info("Selecting the product");
        home.selectProduct();
        log.info("Go to Favorite List");
        home.gotoMyFavs();
        log.info("Remove the product from Favorite List");
        home.removeFromeMyFavs();
        home.delete();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File("C:\\selenium\\homePageScreenshot.png"));
            log.info("Screenshot is taken");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        log.info("Test finished successfully");
        driver.quit();
    }

}
