package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class MultiSelect {
    private final WebDriver driver;

    //locators

    public static By get_Item(String Item) {

        return By.xpath("//li[contains(text(),'"+Item+"')]");
    }
    private static final By iframe = By.xpath("//iframe[@class='demo-frame']");
    public MultiSelect(WebDriver driver) {
        this.driver = driver;
    }


    //Actions

    public MultiSelect multiSelectOptions(String ItemA, String ItemB, String ItemC) {

        WebElement frame = driver.findElement(iframe);
        driver.switchTo().frame(frame);
        WebElement itemA = driver.findElement(get_Item(ItemA));
        WebElement itemB = driver.findElement(get_Item(ItemB));
        WebElement itemC = driver.findElement(get_Item(ItemC));

        Actions action = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", itemA);
        action.keyDown(Keys.CONTROL)
                .moveToElement(itemA)
                .click(itemA)
                .moveToElement(itemB)
                .click(itemB)
                .moveToElement(itemC)
                .click(itemC)
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
        return this;
    }



}
