package UI.StepImplementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Map;

public class NDTVStepImpl extends CommonStepImpl {
    private Logger logger = (Logger) LogManager.getLogger(CommonStepImpl.class);
    private String bellIconXpath = "/html/body/div[2]/div/div/div/div/div[3]/div[1]/a[5]/span[1]/span/a";
    private String popoutSelector = ".popover-content";
    private String popoverxpath = "/html/body/div[2]/div/div/div/div/div[3]/div[1]/a[5]/span[1]/span/div";
    private String closeXpath = "/html/body/div[2]/div/div/div/div/div[3]/div[1]/a[5]/span[1]/span/div/div[2]/div/img";

    public void clickOnBellIcon() {
        try {
            WebElement bellIcon = driver.findElement(By.xpath(bellIconXpath));
            String openPopover = driver.findElement(By.xpath(popoverxpath)).getAttribute("style");
            if(openPopover != null){
                bellIcon.click();
            }
            bellIcon.click();
        }catch (Exception e){
            logger.info("Unable to open bell icon, Exception occurred: "+e);
            Assert.fail();
        }
    }

    public void validateText(Map<String, String> data) {
        try {
            WebElement popout = driver.findElement(By.cssSelector(popoutSelector));
            String actualText = popout.getText().substring(0,56);
            if(!actualText.equalsIgnoreCase(data.get("Text"))){
                Assert.fail("The text is popout not as expected. Expected"+data.get("Text")+" Actual: "+actualText);
            }
        }catch (Exception e){
            logger.info("Unable to find text in popout, Exception occurred: "+e);
            Assert.fail();
        }
    }

    public void clickOnCloseButton() {
        try {
            WebElement closeButton = driver.findElement(By.xpath(closeXpath));
            closeButton.click();
        }catch (Exception e){
            logger.info("Unable to find text in popout, Exception occured: "+e);
            Assert.fail();
        }
    }
}
