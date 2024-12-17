
package pageobject;
import helpers.ScrollingHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".KuIaYs[href='https://careers.wix.com']")
    private WebElement careersBtnElement;

    public void goToCareersPage() {
        ScrollingHelper.scrollToElement(driver, careersBtnElement, 10);
        waitForVisibilityOf(careersBtnElement);
        careersBtnElement.click();
    }
}
