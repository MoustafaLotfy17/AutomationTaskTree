package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    private final WebDriver driver;

    //locators
    private static final By iframe = By.xpath("//iframe[@class='demo-frame']");
    private static final By lbl_dragbox = By.id("draggable");
    private static final By lbl_dropbox = By.id("droppable");

    public DragAndDrop(WebDriver driver) {
        this.driver = driver;
    }

    //Actions

    public DragAndDrop dragAndDropElement() {
        WebElement frame = driver.findElement(iframe);
        driver.switchTo().frame(frame);
        WebElement drag = driver.findElement(lbl_dragbox);
        WebElement drop = driver.findElement(lbl_dropbox);
        Actions action = new Actions(driver);
        action.dragAndDrop(drag,drop).perform();
        return this;
    }
}
