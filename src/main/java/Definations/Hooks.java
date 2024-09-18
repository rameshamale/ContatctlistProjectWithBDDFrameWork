package Definations;

import Pages.*;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks {

    public static WebDriver driver;
    public static Faker faker;
    public static LoginPage loginPage ;
    public static WebDriverWait wait;
    public static Actions actions;
    public static AddcontactList addcontactList;
    public static ContactListPage contactListPage;
    public static EditContactPage editContactPage;
    public static ContactDetailsPage contactDetailsPage;

    @Before

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920x1080");*//*
        driver = new ChromeDriver(options);*/
        driver = new ChromeDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // Set an implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        faker=new Faker();
    }

    @After
    public void tearDown() {
        // Close the browser after the scenario
        if (driver != null) {
            driver.quit();
        }
        System.out.println("WebDriver closed");
    }

    public static WebDriver getDriver() {
        return driver;
    }
    public static Faker getFaker(){
        return faker;
    }

    public static LoginPage getLoginPage(){
        return loginPage=new LoginPage(driver,wait,actions);
    }
    public static AddcontactList getAddContactListPage(){
        return addcontactList=new AddcontactList(driver,wait,actions);
    }
    public static WebDriverWait getWait(){
        return wait;
    }
    public static Actions getActions(){
        return actions;
    }
    public static ContactListPage getcontactListPage(){
        return contactListPage=new ContactListPage(driver,wait,actions);
    }
    public static EditContactPage getEditContactPag(){
        return editContactPage=new EditContactPage(driver,wait,actions);
    }
    public static ContactDetailsPage getContactDetailsPage(){
        return contactDetailsPage=new ContactDetailsPage(driver,wait,actions);
    }

}
