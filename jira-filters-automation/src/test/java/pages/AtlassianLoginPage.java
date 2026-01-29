package pages;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class AtlassianLoginPage extends BaseTest {

        private WebDriver driver;
        private WebDriverWait wait;

        private By emailInput = By.id("username");
        private By continueButton = By.id("login-submit");
        private By passwordInput = By.id("password");
        private By errorMessage = By.cssSelector("[data-testid='form-error']");

        public AtlassianLoginPage(WebDriver driver, WebDriverWait wait) {
            this.driver = driver;
            this.wait = wait;
        }

        public void open() {
            driver.get("https://id.atlassian.com/login");
        }

        public void enterEmail(String email) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput))
                    .sendKeys(email);
            driver.findElement(continueButton).click();
        }

        public void enterPassword(String password) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput))
                    .sendKeys(password);
            driver.findElement(continueButton).click();
        }

        public boolean isLoginErrorDisplayed() {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage))
                    .isDisplayed();
        }
    }
