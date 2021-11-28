package UI.StepImplementation;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class CommonStepImpl {
    private Logger logger = (Logger) LogManager.getLogger(CommonStepImpl.class);
    static WebDriver driver;
    ChromeOptions options;

    public String getUrl(String name){
        String url;
        switch (name.toLowerCase()){
            case "ndtv":
                url = "ndtv.com";
                break;
            default: url = null;
                break;
        }
        return url;
    }

    public void launchBrowser(String url) {
    try{
        browserAlerts();
        url = "http://"+ url;
        driver = new ChromeDriver(options);
        driver.get(url);
    }catch (Exception e){
        logger.info("Failed to load. Exception occured: " + e);
        Assert.fail();
    }
    }

    public void allowAlerts() {
        try{
            System.out.println(driver);
           WebDriverWait wait = new WebDriverWait(driver, 30);
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("noti_wrap")));
           WebElement allowButton = driver.findElement(By.xpath("//div[2]/div[2]/a[2]"));
           allowButton.click();
        }catch (Exception e){
            logger.info("Exception occured: "+e);
            Assert.fail();
        }
    }

    public void browserAlerts(){
        try{
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 1);
        options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        }catch (Exception e){
            logger.info("Exception occured: "+e);
            Assert.fail();
        }
    }

    public void closeBrowser() {
        driver.close();
    }
}
