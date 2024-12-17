
package helpers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScrollingHelper {

    public static void scrollToElement(WebDriver driver, WebElement element, int timeoutSeconds) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));

        long initialScrollY = ((Number) js.executeScript("return window.scrollY;")).longValue();

        js.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", element);

        wait.until((ExpectedCondition<Boolean>) wd -> {
            long currentScrollY = ((Number) js.executeScript("return window.scrollY;")).longValue();
            return currentScrollY != initialScrollY;
        });

        wait.until((ExpectedCondition<Boolean>) wd -> {
            long oldScrollY = ((Number) js.executeScript("return window.scrollY;")).longValue();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long newScrollY = ((Number) js.executeScript("return window.scrollY;")).longValue();
            return oldScrollY == newScrollY;
        });
    }
}
