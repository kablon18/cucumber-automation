package Functions;

import BaseClass.BaseClass;
import locators.Common;
import static org.testng.internal.Utils.log;

public class LoginFunctions extends BaseClass {
    public static Common commonLocators = new Common(driver);

    public static void enterUserName(String userName){
        findElement(Common.userName).sendKeys(userName);
    }

    public static void enterPassword(String password){
        findElement(Common.password).sendKeys(password);
    }

    public static void loginUser(){
        findElement(Common.loginButton).click();
    }

    public static void verifyAlertMessage(String message){
        String alert = driver.switchTo().alert().getText();
        if(alert.contains(message)){
           log("Login Successful");
        }
    }

    @Override
    public void initMetaData() {

    }
}