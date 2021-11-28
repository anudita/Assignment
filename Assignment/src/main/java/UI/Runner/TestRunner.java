package UI.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {"pretty", "html:target/reports/report.html"},
        features = {"src/main/java/UI/features"},
        glue = {"UI/StepDefination"},
        tags = "@test"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }

    @BeforeTest
    public void BeforeTest(){
        System.setProperty("webdriver.chrome.driver", "../chromedriver.exe");
    }

}
