package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LoginPage extends Utilities{

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLogin() throws InterruptedException {
        driver.findElement(By.id("myAccount")).click();
        new WebDriverWait(driver,50).until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        driver.findElement(By.linkText("Giriş Yap")).click();
        waitforAjax();

    }
    public void enterUserName(String userName) throws InterruptedException {
        WebElement element= driver.findElement(By.name("username"));
        element.click();
        waitforAjax();
        element.sendKeys(userName);

    }

    public void enterPassword(String password) throws InterruptedException {
        WebElement element= driver.findElement(By.name("password"));
        element.click();
        waitforAjax();
        element.sendKeys(password);
    }

    public void clickLogin() throws InterruptedException {
        driver.findElement(By.name("btnLogin")).click();
        waitforAjax();
    }

    public void search(String search) throws InterruptedException {
        WebElement element= driver.findElement(By.className("desktopOldAutosuggestTheme-input"));
        element.click();
        waitforAjax();
        element.sendKeys(search);
    }
    public void clickSearchBtn() throws InterruptedException {
        driver.findElement(By.className("SearchBoxOld-buttonContainer")).click();
        waitforAjax();

    }
    public void controlSearch() throws Exception {
        String element=  driver.findElement(By.className("category-suggestion-title")).getText();
        waitforAjax();
        if(element.contains("Huawei")){
            System.out.println("Right Search");
        }else {
            throw new Exception("Test Failed");
        }
    }
    public void clickSecondPage() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.className("pagination"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        WebElement element2 = driver.findElement(By.linkText("2"));
        element2.click();
        waitforAjax();

    }
    public void checkSecondPage() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.className("pagination"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        WebElement element2 = driver.findElement(By.linkText("2"));
        waitforAjax();
        String page = element2.getText();
        if (page.contains("2")) {
            System.out.println("Right Page.");
        } else {
            throw new Exception("Test Failed");
        }
    }public void selectProduct() throws InterruptedException {
        WebElement element =driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/div/div/div[2]/section/div[1]/div[4]/div/div/div/div/ul/li[3]/div/a"));
        element.click();
        waitforAjax();
        WebElement element1=driver.findElement(By.className("MyLists-17qB_")).findElement(By.className("Like-1divm"));
        element1.click();
    }


    public void gotoMyFavs() throws Exception {
        driver.findElement(By.id("myAccount")).click();
        waitforAjax();
        WebElement element= driver.findElement(By.linkText("Beğendiklerim"));
        element.click();
        waitforAjax();

    }
    public void removeFromeMyFavs() throws Exception {
        WebElement element=driver.findElement(By.className("select-all"));
        element.getText();
        element.click();
        WebElement element1=driver.findElement(By.id("StickActionHeader-RemoveSelected"));
        element1.click();
        waitforAjax();

    }
    public void delete() throws Exception {
        WebElement element2=driver.findElement(By.id("DeleteConfirmationModal-ActionButton"));
        element2.click();
        waitforAjax();
        WebElement element3=driver.findElement(By.className("myList-container"));
        String text = element3.getText();
        waitforAjax();
        if (text.contains("boş")){
            System.out.println("List is empty.");
        } else {
            throw new Exception("Test Failed");
        }
    }

}

