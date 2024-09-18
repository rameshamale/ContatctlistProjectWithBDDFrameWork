package Pages;

import Utilities.PropertyManger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUser extends Methods{

    public AddUser(WebDriver driver, WebDriverWait wait, Actions actions){
        super(driver,wait,actions);
    }
    By signUpButton=By.id(PropertyManger.signUpButton);
    By firsNameField= By.id(PropertyManger.firsName);
    By lastNameFiled=By.id(PropertyManger.lastname);
    By emailField=By.cssSelector(PropertyManger.emailId);
    By adduserpassword =By.cssSelector(PropertyManger.adduserpassWord);
    By submitButton=By.cssSelector(PropertyManger.addusersubmitButton);
    By errorMessage=By.cssSelector(PropertyManger.addeUserErrorMessage);

    public void clickSignButton() {
        click(signUpButton);
    }
    public void enterFirstName(String firstName) {
       sendKeys(firsNameField,firstName);
    }

    public void enterLastName(String lastName) {
        sendKeys(lastNameFiled,lastName);
    }

    public void enterEmail(String email) {
        sendKeys(emailField,email);
    }

    public void enterPassword(String password) {
        sendKeys(adduserpassword,password);
    }

    public void clickSubmitButton() {
        click(submitButton);
    }
    public String verifyErrrorMessage(){
        return getText(errorMessage);
    }

}
