package Definations;

import Pages.AddcontactList;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.junit.Assert;


import static Utilities.JsonReader.readJsonData;

public class AddContact {
    AddcontactList addcontactList=Hooks.getAddContactListPage();
    int numberOfRowsBeforeAddContact;
    int numberOfRowsAfterAddContact;
    String filePath = "src/test/resources/TestData/AddContact.json";
    JSONObject jsonObject;
    JSONObject address;

    @Given("The user click on Add a new contact button")
    public void the_user_click_on_Add_a_new_contact_button() {
        numberOfRowsBeforeAddContact=addcontactList.getNumberOfRows();
        addcontactList.clickOnAddNewContactButton();
    }

    @When("The user enter valid creadentils")
    public void the_user_enter_valid_creadentils() {
        jsonObject= readJsonData(filePath);
        address = jsonObject.getJSONObject("address");
        addcontactList.enterFirstName(jsonObject.getString("firstName"));
        addcontactList.enterLastName(jsonObject.getString("lastName"));
        addcontactList.enterBirthdate(jsonObject.getString("dateOfBirth"));
        addcontactList.enterEmail(jsonObject.getString("email"));
        addcontactList.enterPhone(jsonObject.getString("phone"));
        addcontactList.enterStreet1(address.getString("street1"));
        addcontactList.enterStreet2(address.getString("street2"));
        addcontactList.enterCity(address.getString("city"));
        addcontactList.enterStateProvince(address.getString("stateProvince"));
        addcontactList.enterPostalCode(address.getString("postalCode"));
        addcontactList.enterCountry(address.getString("country"));
        addcontactList.clickcOnSubmitButton();
        numberOfRowsAfterAddContact=addcontactList.getNumberOfRows();
           }

    @Then("The new contatc is displayed in contactList table")
    public void the_new_contatc_is_displayed_in_contactList_table() {
        Assert.assertEquals(numberOfRowsBeforeAddContact+1,numberOfRowsAfterAddContact);
    }

    @When("The user enter invalid creadentils")
    public void the_user_enter_invalid_creadentils() {
        jsonObject= readJsonData(filePath);
        address = jsonObject.getJSONObject("address");
        addcontactList.enterFirstName(jsonObject.getString("firstName"));
        addcontactList.enterLastName(jsonObject.getString("lastName"));
        addcontactList.enterBirthdate(jsonObject.getString("dateOfBirth"));
        addcontactList.enterEmail(jsonObject.getString("invalidemail"));
        addcontactList.enterPhone(jsonObject.getString("phone"));
        addcontactList.enterStreet1(address.getString("street1"));
        addcontactList.enterStreet2(address.getString("street2"));
        addcontactList.enterCity(address.getString("city"));
        addcontactList.enterStateProvince(address.getString("stateProvince"));
        addcontactList.enterPostalCode(address.getString("postalCode"));
        addcontactList.enterCountry(address.getString("country"));
        addcontactList.clickcOnSubmitButton();}
    @Then("The invalidemail error message should be display")
    public void the_invalidemail_error_message_should_be_display() {
        String errorMessageAct=addcontactList.getErrorMessage();
        String errorMessageExp="Contact validation failed: email: Email is invalid";
        Assert.assertEquals(errorMessageAct,errorMessageExp);
    }

}
