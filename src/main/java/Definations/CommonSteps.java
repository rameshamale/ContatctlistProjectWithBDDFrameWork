package Definations;

import Pages.ContactDetailsPage;
import Pages.ContactListPage;
import Pages.EditContactPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.IOException;
import java.time.Duration;

import static Definations.Hooks.contactListPage;

public class CommonSteps {
    WebDriver driver = Hooks.getDriver();
    ContactListPage contactListPage =Hooks.getcontactListPage();
    @Given("^The user on login page$")
    public void userOnLoginPage() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    }

    @Given("The user click on any contact")
    public void the_user_click_on_any_contact() {
        contactListPage.clickOnRandomContact();
    }

    @Then("The user redirects on contactListPage")
    public void the_user_redirected_on_contact_list_page() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actText = driver.findElement(By.xpath("//h1[text()='Contact List']")).getText();
        String expText = "Contact List";
        Assert.assertEquals(actText, expText);
    }
}
