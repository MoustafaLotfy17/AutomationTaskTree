package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.DriverManager;
import managers.FileReaderManager;
import pages.Landing;
import pages.ControlGroup;
import pages.DragAndDrop;
import pages.MultiSelect;

public class Jquery_Steps extends DriverManager {

    private final Landing landingPage = new Landing(getDriver());
    private final ControlGroup controlgroup = new ControlGroup(getDriver());

    private final DragAndDrop draganddrop = new DragAndDrop(getDriver());

    private final MultiSelect multiSelect = new MultiSelect(getDriver());
    @Given("user navigates to the JQUERY landing page")
    public void user_navigates_to_the_jquery_landing_page() {
        getDriver().get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    @When("user selects the Droppable interaction action")
    public void he_selects_the_droppable_action() {
        landingPage.clickDroppableActionInteraction();
    }

    @Then("user can drag and drop element")
    public void user_can_drag_and_drop_element(){
        draganddrop.dragAndDropElement();
    }

    @When("user selects the Selectable interaction action")
    public void he_selects_the_selectable_action() {
        landingPage.clickSelectableActionInteraction();
    }

    @Then("user can multiselect {string} {string} {string}")
    public void user_can_multiselect_items(String ItemA, String ItemB, String ItemC){
        multiSelect.multiSelectOptions(ItemA, ItemB, ItemC);
    }

    @When("user selects the ControlGroup Widget action")
    public void user_selects_the_control_group_widget_action() {
        landingPage.clickControlGroup();
    }

    @When("user select Vehicle Transmission type")
    public void user_select_vehicle_transmission_type() {
        controlgroup.clickStandardTransmission();
    }
    @When("user select Vehicle Insurance period")
    public void user_select_vehicle_insurance_period() {
        controlgroup.selectInsuranceCheckbox()
                .enterInsurancePeriod();
    }
    @When("user select Rental Vehicle Transmission type")
    public void user_select_rental_vehicle_transmission_type() {
        controlgroup.selectRentalTransmission();
    }
    @When("user select Rental Vehicle Insurance period")
    public void user_select_rental_vehicle_insurance_period() {
        controlgroup.selectRentalInsurance()
                .enterRentalInsurancePeriod();
    }
    @Then("user can book now Vehicle")
    public void user_can_book_now_vehicle() {
        controlgroup.pressBookNow();
    }

}
