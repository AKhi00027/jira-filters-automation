# jira-filters-automation
Automation – Jira Filters Workflow (Selenium + Java)
# Jira Filters Automation (Selenium + Java)

This project automates validation of Jira Filters workflows as part of QA automation
for external integrations.

## Scope
- Create Jira filters using JQL
- Validate Open and Closed issue filters
- Assert returned issue statuses match expected criteria
- Designed to be simple, readable, and extensible

## Tech Stack
- Java 11+
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager

## Setup
1. Install Java 11+
2. Install Maven
3. Clone the repository

```bash
Jira Cloud uses Atlassian SSO, which introduces non-deterministic redirects, CAPTCHA, and MFA.
UI login tests are intentionally limited to validation scenarios.
Authenticated flows rely on session reuse or pre-authenticated environments.

