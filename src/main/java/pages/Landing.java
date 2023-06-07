package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Landing {
    private final WebDriver driver;

    //locators
    private static final By btn_Droppable_Interaction = By.xpath("//a[contains(text(),'Droppable')]");

    private static final By btn_Selection_Interaction = By.xpath("//a[contains(text(),'Selectable')]");

    private static final By btn_Control_Group = By.xpath("//a[contains(text(),'Controlgroup')]");

    public Landing(WebDriver driver) {
        this.driver = driver;
    }


    //Actions
    public Landing clickDroppableActionInteraction() {
        driver.findElement(btn_Droppable_Interaction).click();
        return this;
    }

    public Landing clickSelectableActionInteraction() {
        driver.findElement(btn_Selection_Interaction).click();
        return this;
    }

    public Landing clickControlGroup() {
        driver.findElement(btn_Control_Group).click();
        return this;
    }

}
