package Definations;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps  {

        WebDriver driver = Hooks.getDriver();
        // Get the WebDriver instance from Hooks

        @When("The user enter valid email")
        public void the_user_enterdvalid_email() {
                driver.findElement(By.id("email")).sendKeys("rameshamale45@gmail.com");
        }
        @When("The user enter valid loginPassword")
        public void the_user_enter_valid_password() {
                driver.findElement(By.id("password")).sendKeys("Test@123");
        }

        @When("The user click on submit button")
        public void the_user_click_on_submit_button() {
                driver.findElement(By.id("submit")).click();
        }

        @When("The user enter invalid email")
        public void the_user_enter_invalid_email() {
                driver.findElement(By.id("email")).sendKeys("rameshamale");
        }

        @When("The user enter invalid password")
        public void the_user_enter_invalid_password() {
                driver.findElement(By.id("password")).sendKeys("Testa");
        }


        @Then("The user error message should display")
        public void the_user_error_message_should_display() {
                WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
                String errormessage=element.getText();
                String expErrorMessage="Incorrect username or password";
                Assert.assertEquals(expErrorMessage,errormessage);
                driver.close();
        }
}