package Definations;

import Pages.ContactDetailsPage;
import Pages.ContactListPage;
import Pages.EditContactPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EditContactStep {
    ContactListPage contactListPage =Hooks.getcontactListPage();
    ContactDetailsPage contactDetailsPage=Hooks.getContactDetailsPage();
    EditContactPage editContactPage=Hooks.getEditContactPag();

    @Given("The user click on edit contact button")
    public void the_user_click_on_edit_contact_button() {
        contactDetailsPage.clickOnEditButton();
    }

    @Given("The user edit the firstName")
    public void the_user_edit_the_firstName() throws InterruptedException {
        editContactPage.setFirstName("Siddhi");
    }

    @When("The user click on submit button on contactDetailPage")
    public void the_user_click_on_submit_button_on_contactDetailPage() {
        editContactPage.clickOnSubmitButton();
    }
    @Then("Verify the firstName is changed")
    public void verify_the_firstName_is_changed() throws InterruptedException {
        String actName=contactDetailsPage.getFirstName();
        Assert.assertEquals("Siddhi",actName);
    }

}
