package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class FiltersPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FiltersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Jira Cloud stable locators
    private By filtersMenu =
            By.xpath("//button[contains(@aria-label,'Filter')]");

    private By createFilterBtn =
            By.xpath("//span[text()='Create filter']");

    private By jqlTextArea =
            By.xpath("//textarea[contains(@aria-label,'JQL')]");

    private By saveAsBtn =
            By.xpath("//span[text()='Save as']");

    private By filterNameInput =
            By.xpath("//input[contains(@aria-label,'Filter name')]");

    private By saveBtn =
            By.xpath("//span[text()='Save']");

    private By issueStatuses =
            By.cssSelector("[data-testid='issue-field-status']");

    public void openFiltersMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(filtersMenu)).click();
    }

    public void createFilter(String jql, String filterName) {
        openFiltersMenu();

        wait.until(ExpectedConditions.elementToBeClickable(createFilterBtn)).click();

        WebElement jqlInput =
                wait.until(ExpectedConditions.visibilityOfElementLocated(jqlTextArea));
        jqlInput.clear();
        jqlInput.sendKeys(jql);

        wait.until(ExpectedConditions.elementToBeClickable(saveAsBtn)).click();

        WebElement nameInput =
                wait.until(ExpectedConditions.visibilityOfElementLocated(filterNameInput));
        nameInput.sendKeys(filterName);

        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
    }

    public List<String> getIssueStatuses() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(issueStatuses));
        return driver.findElements(issueStatuses)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}