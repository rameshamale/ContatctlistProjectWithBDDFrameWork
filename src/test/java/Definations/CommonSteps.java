package Definations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.IOException;
import java.time.Duration;

public class CommonSteps {
    WebDriver driver = Hooks.getDriver();
    ConfigLoader configLoader = new ConfigLoader("src/test/java/Definations/ConfigLoader.java");

    public CommonSteps() throws IOException {
    }
    @Given("^The user on login page$")
    public void userOnLoginPage() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        //driver.get(configLoader.getProperty("https://thinking-tester-contact-list.herokuapp.com/"));
    }
    @Then("The user redirects on contactListPage")
    public void the_user_redirected_on_contact_list_page() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actText = driver.findElement(By.xpath("//h1[text()='Contact List']")).getText();
        String expText = "Contact List";
        Assert.assertEquals(actText, expText);
        driver.close();
    }
}
