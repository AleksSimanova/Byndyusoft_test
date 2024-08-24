import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ByndyusoftPage;
import pages.GooglePage;


public class ContactTelegram_Test {
    private WebDriver driver;

    String logo = "Byndyusoft";


    @BeforeAll
    public static void instDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterEach
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebElement $(By locator) {
        return driver.findElement(locator);
    }

    @Test
    public void contactTelegram() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.google.com/");
        new GooglePage(driver)
                .siteSearch(logo)
                .firstSearchLink();

        new ByndyusoftPage(driver)
                .checkHeader()
                .clickGetPresentation();

    }

}
