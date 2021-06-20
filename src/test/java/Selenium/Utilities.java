package Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utilities {
    WebDriver driver;

    public void waitforAjax() throws InterruptedException {
        Thread.sleep(5000);
    }
}
