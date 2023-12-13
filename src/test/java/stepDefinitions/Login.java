package stepDefinitions;
import BaseClass.BaseClass;
import Functions.LoginFunctions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static Constants.LoginConstants.*;

public class Login extends BaseClass {

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

        @Given("user navigates to webdriver university login page")
        public void user_navigates_to_webdriver_university_login_page() {
            navigateToUrl(loginURL);
        }
        @When("user enters username {word}")
        public void user_enters_username(String userName) {
            LoginFunctions.enterUserName(userName);
        }
        @When("user enters password {word}")
        public void user_enters_password(String password) {
            LoginFunctions.enterPassword(password);
        }

        @When("user enters wrong password {string}")
        public void userEntersWrongPassword(String password) {
            LoginFunctions.enterPassword(password);
        }
        @When("user clicks on login button")
        public void user_clicks_on_login_button() {
            LoginFunctions.loginUser();
        }

    @Then("user should receive a login pop-up message {string}")
    public void userShouldReceiveALoginPopUpMessage(String message) {
        LoginFunctions.verifyAlertMessage(message);
    }


    @Override
    public void initMetaData() {

    }


}
