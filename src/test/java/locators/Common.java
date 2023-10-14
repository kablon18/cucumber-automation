package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Common {

    public Common(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public By firstName = By.xpath("//input[@placeholder='First name']");
    public static By userName = By.xpath("//input[@placeholder='Username']");
    public static By password = By.xpath("//input[@placeholder='Password']");
    public static By loginButton = By.xpath("//button[contains(@id,'login-button')]");

}
