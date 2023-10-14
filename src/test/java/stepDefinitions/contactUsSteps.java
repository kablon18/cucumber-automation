package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import locators.Common;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import static io.opentelemetry.api.internal.ApiUsageLogger.log;

public class contactUsSteps {
    private WebDriver driver;

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

    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }

    @Given("user access webdriver university contact us page")
    public void user_access_webdriver_university_contact_us_page() {
        // Write code here that turns the phrase above into concrete actions
       driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }
    @When("user enters unique first name")
    public void user_enters_unique_first_name() {
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("AutoFN" + generateRandomNumber(5));
        log("First Name entered");
    }
    @When("user enters unique last name")
    public void user_enters_unique_last_name() {
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("AutoLN" + generateRandomNumber(5));
        log("Last Name entered");
    }
    @When("user enters unique email address")
    public void user_enters_unique_email_address() {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("AutoEmail" + generateRandomNumber(5) + "@mailtest.com");
        log("Email Address entered");
    }
    @When("user enters unique comments")
    public void user_enters_unique_comments() {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("AutoComments" + generateRandomNumber(5));
        log("Comments entered");
    }
    @When("user clicks on submit button")
    public void user_clicks_on_submit_button() {
        driver.findElement(By.xpath("//input[contains(@value,'SUBMIT')]")).click();
    }
    @Then("user should be redirected to page with success message")
    public void user_should_be_redirected_to_page_with_success_message() {
        WebElement expectedMessage = driver.findElement(By.xpath("//div/h1[contains(text(),'Thank You for your Message!')]"));
        Assert.assertEquals(expectedMessage.getText(),"Thank You for your Message!" );
    }

 // <-- Specific Data -->
 @When("user enters a specific first name {word}")
 public void user_enters_a_specific_first_name(String firstName) {
     driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
     log("First Name entered");
 }

    @When("user enters a specific last name - {word}")
    public void user_enters_a_specific_last_name(String lastName) {
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
    }

    @When("user enters a specific email address - {word}")
    public void user_enters_a_specific_email_address(String email) {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
    }

    @When("user enters a specific comment - {string}")
    public void user_enters_a_specific_comment(String comment) {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);
    }


}
