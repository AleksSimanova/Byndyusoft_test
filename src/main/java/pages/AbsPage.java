package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import wait.Waiters;

public class AbsPage {
        protected WebDriver driver = null;

        protected Actions actions = null;

        protected Waiters waiters = null;

    public AbsPage(WebDriver driver) {
            this.driver = driver;
            this.actions = new Actions(driver);
            this.waiters = new Waiters(driver);

        }

        public WebElement $(By locator) {
            return driver.findElement(locator);
        }

    }




