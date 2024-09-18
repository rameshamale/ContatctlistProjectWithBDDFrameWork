package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditContactPage extends Methods {
    By firstName=By.xpath("//p//input[@id='firstName']");
    By submitButton=By.id("submit");

    public EditContactPage(WebDriver driver, WebDriverWait wait, Actions actions){
        super(driver,wait,actions);
    }

    public String getFirstName(){
        return getText(firstName);
    }
    public void clearFirstNameField(){
        clear(firstName);
    }
    public void setFirstName(String name) throws InterruptedException {
        elementUntillClickable(firstName);
        clearInputField(firstName);
        clear(firstName);
        sendKeys(firstName,name);
    }
    public void clickOnSubmitButton(){
        click(submitButton);
    }
}
