package Definations;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    public static WebDriver driver;
    public static Faker faker;

    @Before
    public void setUp() {
        // Set path for WebDriver executable (if needed)
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver (for Chrome in this example)
        driver = new ChromeDriver();

        // Maximize the browser window
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
}
