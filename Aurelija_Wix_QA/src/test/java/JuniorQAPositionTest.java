
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.CareersPage;
import pageobject.HomePage;
import pageobject.AllJobsPositionsPage;

public class JuniorQAPositionTest extends BaseTest {

    @Test
    void searchingForJobTitle() {
        HomePage homePage = new HomePage(driver);
        CareersPage careersPage = new CareersPage(driver);
        AllJobsPositionsPage allJobsPositionsPage = new AllJobsPositionsPage(driver);

        String jobTitle = "Junior Quality Assurance";

        homePage.goToCareersPage();
        careersPage.goToQAPositionsPage();
        allJobsPositionsPage.acceptCookies();

        boolean isThereJuniorQAPosition = allJobsPositionsPage.hasAJobTitle(jobTitle);
        Assertions.assertTrue(isThereJuniorQAPosition, "So sad, there are no junior QA positions at the moment");

    }
}
