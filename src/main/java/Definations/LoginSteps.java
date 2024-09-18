package Definations;

import Pages.LoginPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps  {
        LoginPage loginPage=Hooks.getLoginPage();
        WebDriverWait wait=Hooks.getWait();
        Actions actions=Hooks.getActions();

        @When("The user enter valid email")
        public void the_user_enterdvalid_email() {
                loginPage.EnterEmail("rameshamale45@gmail.com");
        }
        @When("The user enter valid loginPassword")
        public void the_user_enter_valid_password() {
                loginPage.EnterPassword("Test@123");
        }

        @When("The user click on submit button")
        public void the_user_click_on_submit_button() {
                loginPage.clickOnSubmitButton();
        }

        @When("The user enter invalid email")
        public void the_user_enter_invalid_email() {
                loginPage.EnterEmail("rameshamale");
        }

        @When("The user enter invalid password")
        public void the_user_enter_invalid_password() {
                loginPage.EnterPassword("Test");
        }
        @Then("The user error message should display")
        public void the_user_error_message_should_display() {
                String errorMessageAct=loginPage.GetErrorrText();
                String errorMessageExp="Incorrect username or password";
                Assert.assertEquals(errorMessageAct,errorMessageExp);
        }
}