package Definations;

import Pages.ContactListPage;
import Pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LogOut {
    ContactListPage contactListPage=Hooks.getcontactListPage();
    LoginPage loginPage=Hooks.getLoginPage();
    @When("The user click on Logoutbutton")
    public void the_user_click_on_Logoutbutton() {
        contactListPage.clickOnLogoutButton();
    }
    @Then("The user on login page afterLogout")
    public void the_user_on_login_page_afterLogout() {
        String actText=loginPage.getLogInText();
        String expText="Log In:";
        Assert.assertEquals(actText,expText);
    }
}
