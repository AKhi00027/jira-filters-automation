package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FiltersPage;

import java.util.List;

public class JiraFiltersTest extends BaseTest {

    @Test
    public void validateOpenItemsFilter() {
        FiltersPage filtersPage = new FiltersPage(driver);

        filtersPage.createFilter(
                "status IN (\"Open\", \"To Do\", \"In Progress\")",
                "Open Items Filter"
        );

        List<String> statuses = filtersPage.getIssueStatuses();

        Assert.assertNotNull(statuses, "Status list is null");

        for (String status : statuses) {
            Assert.assertTrue(
                    status.equals("Open")
                            || status.equals("To Do")
                            || status.equals("In Progress"),
                    "Unexpected status found in Open filter: " + status
            );
        }
    }

    @Test
    public void validateClosedItemsFilter() {
        FiltersPage filtersPage = new FiltersPage(driver);

        filtersPage.createFilter(
                "status IN (\"Done\", \"Closed\")",
                "Closed Items Filter"
        );

        List<String> statuses = filtersPage.getIssueStatuses();

        if (statuses.isEmpty()) {
            Assert.assertTrue(true, "No closed items found – valid scenario");
            return;
        }

        for (String status : statuses) {
            Assert.assertTrue(
                    status.equals("Done") || status.equals("Closed"),
                    "Unexpected status found in Closed filter: " + status
            );
        }
    }
}