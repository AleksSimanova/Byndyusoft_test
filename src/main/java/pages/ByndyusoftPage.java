package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ByndyusoftPage extends AbsPage {
    public ByndyusoftPage(WebDriver driver) {
        super(driver);
    }

    String logo = "Byndyusoft";
    String tgContact = "http://t.me/alexanderbyndyu";

    public ByndyusoftPage checkHeader() {
        waiters.waitFroElementVisibole(By.xpath("//a[@href=\"https://byndyusoft.com/\"][1]"));
        WebElement headerLogo = $(By.cssSelector("a.header__logo"));
        assertThat(headerLogo.getAttribute("title"))
                .as("This is not a website {}", logo)
                .isEqualTo(logo);
        return this;
    }


    public ByndyusoftPage clickGetPresentation() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        assertThat(waiters.waitFroElementInvisibole(By.cssSelector("div.popup-callback--visible")))
                .as("the contact window is open").isTrue();
        waiters.waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector("section.knowMore span")));
        $(By.cssSelector("section.knowMore span")).click();
        assertThat(waiters.waitFroElementVisibole(By.cssSelector("div.popup-callback--visible")))
                .as("the contact window is not open").isTrue();
        WebElement telegram = $(By.cssSelector("a.popup-callback__contacts-tg"));
        assertThat(telegram.getAttribute("href"))
                .as("The non-telegram link does not match with{}", tgContact)
                .isEqualTo(tgContact);
        return this;
    }

}