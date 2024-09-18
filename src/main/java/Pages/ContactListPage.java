package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactListPage extends Methods {
    By logButton=By.id("logout");
    By contcatListTable=By.xpath("//table[@class='contactTable']");

    public ContactListPage(WebDriver driver, WebDriverWait wait, Actions actions){
    super(driver,wait,actions);}

    public void clickOnLogoutButton(){
    click(logButton);
    }

    public void clickOnRandomContact(){
        clickOnRandomContact(contcatListTable);
    }

}