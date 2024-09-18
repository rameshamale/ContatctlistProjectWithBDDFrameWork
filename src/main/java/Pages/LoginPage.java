package Pages;

import Utilities.PropertyManger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends Methods {

    public LoginPage(WebDriver driver,WebDriverWait wait, Actions actions ) {
        super(driver,wait, actions);
    }
    By emailIdField = By.id("email");
    By passWordField = By.id("password");
    By signupButton = By.id("signup");
    By submitButton=By.id("submit");
    By errorMessage=By.xpath(("(//span[@id='error'])[1]"));
    By loginText=By.xpath("//p[text()='Log In:']");

    public void EnterEmail(String UserEmail) {
        sendKeys(emailIdField,UserEmail);}

    public void EnterPassword(String password) {
        sendKeys(passWordField,password);
    }
    public void ClickOnSignupButton(){
        click(signupButton);
    }
    public String GetErrorrText(){
        return getText(errorMessage);
    }
    public void clickOnSubmitButton(){
        click(submitButton);
    }
    public String getLogInText(){
        return getText(loginText);
    }
}
