package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ControlGroup {
    private final WebDriver driver;

    //locators

    private static final By btn_Standard_Transmission = By.xpath("//label[@for='transmission-standard']//span");
    private static final By chk_Insurance = By.xpath("//label[@for='insurance']//span");
    private static final By txt_Insurance_Period = By.xpath("//input[@id='horizontal-spinner']");
    private static final By rdo_Rental_Transmission = By.xpath("//label[@for='transmission-standard-v']//span");
    private static final By chk_Rental_Insurance = By.xpath("//label[@for='insurance-v']");
    private static final By txt_Rental_Insurance_Period = By.xpath("//input[@id='vertical-spinner']");
    private static final By btn_Book_Now = By.xpath("//button[@id='book']");
    private static final By iframe = By.xpath("//iframe[@class='demo-frame']");

    public ControlGroup(WebDriver driver) {
        this.driver = driver;
    }


    //Actions
    public ControlGroup clickStandardTransmission() {
        WebElement frame = driver.findElement(iframe);
        driver.switchTo().frame(frame);
        driver.findElement(btn_Standard_Transmission).click();
        return this;
    }

    public ControlGroup selectRentalTransmission() {
        driver.findElement(rdo_Rental_Transmission).click();
        return this;
    }

    public ControlGroup selectRentalInsurance() {
        driver.findElement(chk_Rental_Insurance).click();
        return this;
    }
    public ControlGroup enterRentalInsurancePeriod() {
        driver.findElement(txt_Rental_Insurance_Period).sendKeys("1");
        return this;
    }
    public ControlGroup enterInsurancePeriod() {
        driver.findElement(txt_Insurance_Period).sendKeys("2");
        return this;
    }
    public ControlGroup selectInsuranceCheckbox() {
        driver.findElement(chk_Insurance).click();
        return this;
    }
    public ControlGroup pressBookNow() {
        driver.findElement(btn_Book_Now).click();
        return this;
    }
}
