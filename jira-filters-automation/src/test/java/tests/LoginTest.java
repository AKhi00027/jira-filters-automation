package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AtlassianLoginPage;

    public class LoginTest extends BaseTest {

        @Test
        public void loginWithInvalidCredentials_shouldShowError() {
            AtlassianLoginPage loginPage = new AtlassianLoginPage(driver, wait);

            loginPage.open();
            loginPage.enterEmail("invalid@test.com");
            loginPage.enterPassword("wrongPassword");

            Assert.assertTrue(loginPage.isLoginErrorDisplayed(),
                    "Expected login error message was not displayed");
        }

        @Test
        public void loginPageShouldLoadSuccessfully() {
            driver.get("https://id.atlassian.com/login");

            Assert.assertTrue(driver.getTitle().toLowerCase().contains("log in"),
                    "Login page title mismatch");
        }
    }
