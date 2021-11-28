package UI.StepDefination;

import UI.StepImplementation.NDTVStepImpl;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;

public class NDTVStepDef {
    NDTVStepImpl impl = new NDTVStepImpl();

    @When("^User clicks on bell icon$")
    public void userClicksOnBellIcon() {
        impl.clickOnBellIcon();
    }

    @Then("^User should see a popup box with text as:$")
    public void userShouldSeeAPopupBoxWithTextAs(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
         impl.validateText(data);
    }

    @When("^User clicks on close button$")
    public void userClicksOnCloseButton() {
        impl.clickOnCloseButton();
    }
}
