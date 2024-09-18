package Definations;

import Pages.AddcontactList;
import Pages.ContactDetailsPage;
import Pages.ContactListPage;
import Pages.EditContactPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Definations.Hooks.driver;

public class DeleteContact {
    ContactDetailsPage contactDetailsPage=Hooks.getContactDetailsPage();
    AddcontactList addcontactList=Hooks.getAddContactListPage();
    @Given("The user on contact contactDetailsPage and cliked on delete button")
    public void the_user_on_contact_contactDetailsPage_and_cliked_on_delete_button() {
        contactDetailsPage.clickOnDeleteContactButton();
    }

    @Given("The popalert is diplayed and user is clicked on ok button")
    public void the_popalert_is_diplayed_and_user_is_clicked_on_ok_button() {
        contactDetailsPage.acceptDeleteContactAlert();
            }

    @Then("Verify the contact is deleted")
    public void verify_the_contact_is_deleted() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://thinking-tester-contact-list.herokuapp.com/contactList"));

    }

}
