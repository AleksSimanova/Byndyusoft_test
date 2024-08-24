package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage extends AbsPage {
    protected String googleLocator = "//form/descendant::div[@jscontroller][@jsname][1]";
    protected String firstSearchLocator = "//div[@data-async-context='query:Byndyusoft']/descendant::div[@style='position:relative']/parent::div/div/div[1]";


    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public GooglePage siteSearch(String logo) {

        WebElement searchBar = $(By.xpath(googleLocator));
        actions.moveToElement(searchBar).sendKeys(logo).perform();
        actions.sendKeys(Keys.ENTER).perform();
        return this;
    }

    public void firstSearchLink() {
        waiters.waitFroElementVisibole(By.xpath(firstSearchLocator));
        WebElement linkFirst = $(By.xpath(firstSearchLocator));
        actions.moveToElement(linkFirst).click().perform();
    }
}
