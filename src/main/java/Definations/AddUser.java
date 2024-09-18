package Definations;

import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AddUser {
    WebDriver driver = Hooks.getDriver();
    Faker faker = Hooks.getFaker();
    @When("The user click on SignUpButton")
    public void the_user_click_on_SignUpButton() {
        driver.findElement(By.id("signup")).click();
    }

    @When("The user redirect on AddUserPage")
    public void the_user_redirect_on_AddUserPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actText=driver.findElement(By.xpath("//p[text()='Sign up to begin adding your contacts!']")).getText();
        String expText="Sign up to begin adding your contacts!";
        Assert.assertEquals(actText,expText);
    }
    @When("The user enter FirstName")
    public void the_user_enter_FirstName() {
        driver.findElement(By.id("firstName")).sendKeys("Ramesh");
    }
    @When("The user enter LastName")
    public void the_user_enter_LastName() {
        driver.findElement(By.id("lastName")).sendKeys("Amale");
    }
    @When("The user enter email")
    public void the_user_enter_email() {
        driver.findElement(By.id("email")).sendKeys(faker.internet().emailAddress());
    }
    @When("The user enter password")
    public void the_user_enter_password() {
        driver.findElement(By.id("password")).sendKeys("Test@123");
    }
    @When("The user click on SignUp Button")
    public void the_user_click_on_SignUp_Button() {
       driver.findElement(By.id("submit")).click();
    }
}
