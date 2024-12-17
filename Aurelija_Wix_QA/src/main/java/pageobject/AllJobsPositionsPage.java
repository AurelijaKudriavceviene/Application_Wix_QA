
package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AllJobsPositionsPage extends BasePage {
    public AllJobsPositionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "comp-m0zj64t8-container")
    private WebElement jobTitlesContainerElement;

    @FindBy(css = "#input_comp-lu193j2211")
    private WebElement searchingInputElement;

    public void acceptCookies() {
        waitForVisibilityOf(cookiesBtnElement);
        cookiesBtnElement.click();
    }

    public boolean hasAJobTitle(String jobTitle) {
        waitForVisibilityOf(jobTitlesContainerElement);
        searchingInputElement.sendKeys(jobTitle);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {

        }

        List<WebElement> containers = driver.findElements(By.className("comp-m0zj64t8-container"));

        if (!containers.isEmpty()) {
            List<WebElement> jobElements = jobTitlesContainerElement.findElements(By.cssSelector("div[class='rM7ckN YJEKQk comp-m0zj64tm-container comp-m0zj64tm J6KGih wixui-repeater__item']"));

            for (WebElement jobElement : jobElements) {
                WebElement jobTitleElement = jobElement.findElement(By.className("wixui-rich-text__text"));
                String titleText = jobTitleElement.getText();
                if (titleText.contains(jobTitle)) {
                    return true;
                }
            }
        }

        return false;
    }
}
