package BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


import java.util.logging.Logger;

import static org.testng.Reporter.log;

public abstract class BaseClass {
    public static WebDriver driver;
    public static Logger log;
    public static Actions actions;
    TakesScreenshot screenshot =((TakesScreenshot)driver);

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        // Refering to page awaits
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    public void navigateToUrl(String url){
        driver.get(url);
    }

    public static void screenshot(String message){
        screenshot(message);
    }

    public static void sendKeys(By locator, String key){
        if(key != null){
            driver.findElement(locator).sendKeys(key);
        }
        else{
            log("No data to input");
        }
    }

    public static WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }


    public abstract void initMetaData();
}
