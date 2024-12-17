
package pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPage extends BasePage {
    public CareersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span[data-testid='stylablebutton-label']")
    private WebElement openPositionsElement;


    public void goToQAPositionsPage() {
        waitForVisibilityOf(openPositionsElement);
        openPositionsElement.click();

    }

}
