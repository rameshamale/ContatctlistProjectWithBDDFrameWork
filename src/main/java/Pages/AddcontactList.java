package Pages;

import Utilities.PropertyManger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddcontactList extends Methods {
    By contactTable=By.xpath("//table[@class='contactTable']");
    By addNewContactButton=By.id("add-contact");
    By firstNameField = By.cssSelector("#firstName");
    By lastNameField = By.xpath("//input[@id='lastName']");
    By birthdateField = By.xpath("//input[@id='birthdate']");
    By emailField = By.xpath("//p//input[@id='email']");
    By phoneField = By.cssSelector("#phone");
    By street1Field = By.cssSelector("#street1");
    By street2Field = By.cssSelector("#street2");
    By cityField = By.cssSelector("#city");
    By stateProvinceField = By.cssSelector("#stateProvince");
    By postalCodeField = By.cssSelector("#postalCode");
    By countryField = By.cssSelector("#country");
    By submitButton=By.xpath("//p//button[@id='submit']");
    By errorMeassage=By.xpath("//span[@id='error']");

    public AddcontactList(WebDriver driver,WebDriverWait wait , Actions actions){
        super(driver,wait,actions);
    }
    public int getNumberOfRows(){
        WebElement conetactTable=element(contactTable);
        List<WebElement> rowBefore=conetactTable.findElements(By.tagName("tr"));
        return rowBefore.size();
    }
    public void clickOnAddNewContactButton(){
        click(addNewContactButton);
    }
    public void enterFirstName(String firstName) {
        click(firstNameField);
        sendKeys(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        sendKeys(lastNameField, lastName);
    }

    public void enterBirthdate(String birthdate) {
        sendKeys(birthdateField, birthdate);
    }

    public void enterEmail(String email) {
        sendKeys(emailField, email);
    }

    public void enterPhone(String phone) {
        sendKeys(phoneField, phone);
    }

    public void enterStreet1(String street1) {
        sendKeys(street1Field, street1);
    }

    public void enterStreet2(String street2) {
        sendKeys(street2Field, street2);
    }

    public void enterCity(String city) {
        sendKeys(cityField, city);
    }

    public void enterStateProvince(String stateProvince) {
        sendKeys(stateProvinceField, stateProvince);
    }

    public void enterPostalCode(String postalCode) {
        sendKeys(postalCodeField, postalCode);
    }

    public void enterCountry(String country) {
        sendKeys(countryField, country);
    }

    public void clickcOnSubmitButton(){
        click(submitButton);
    }

    public String getErrorMessage(){
        return getText(errorMeassage);
    }
}



