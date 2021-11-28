package UI.StepDefination;

import UI.StepImplementation.CommonStepImpl;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


public class CommonStepDef {

    CommonStepImpl impl = new CommonStepImpl();

    @Given("^User opens (.*)$")
    public void userOpens(String name){
        String url = impl.getUrl(name);
        impl.launchBrowser(url);
    }

    @And("^Allows all alerts on the page$")
    public void allowsAllAlertsOnThePage() {
        impl.allowAlerts();
    }

    @After
    public void afterScenario(){
        impl.closeBrowser();
    }
}
