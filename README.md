# SauceDemo Automation Project

This repository contains end-to-end automated tests for SauceDemo using the following technologies:
- Java 17
- Selenium WebDriver (Page Object Model)
- TestNG (Unit & Data-Driven Testing)
- Apache POI (Excel-Driven Data Provider)
- ExtentReports (HTML Reporting)
- GitHub Actions (CI/CD Pipeline)

## Key Features
1. Page Object Model: Clean separation of pages/, tests/, and utils/ for maintainable code.
2. Data-Driven Tests: Read test credentials from Excel (src/test/resources/LoginData.xlsx).
3. HTML Reports: Automatically generate interactive test reports (target/ExtentReport.html).
4. Continuous Integration: Tests run on every push to master branch via GitHub Actions.

## Local Setup & Execution
Prerequisites
- Java 17 installed
- Maven 3.6+
- Google Chrome browser

## Steps
1. Clone the repository
git clone https://github.com/mib03/saucedemo-automation.git
cd saucedemo-automation

2. Run tests
mvn clean test

3. View report
open target/ExtentReport.html

## CI/CD with GitHub Actions

The build status badge above reflects the latest test run on GitHub Actions.

## Pipeline Overview
1. Checkout code from repository
2. Set up JDK 17
3. Cache Maven dependencies
4. Execute mvn clean test to run TestNG suite
5. Generate ExtentReport.html
6. Upload report as an artifact (accessible via Actions tab)

## Viewing Test Reports

1. Navigate to your repository on GitHub
2. Click on the Actions tab
3. Select the Run Test Automation with Maven workflow
4. Scroll down to Artifacts and download ExtentReport
5. Open the HTML file in your browser to see detailed results

## Project Structure

├── src
│   ├── main/java
│   └── test/java
│       ├── pages      # Page Object classes
│       ├── tests      # TestNG test classes
│       ├── utils      # Utility classes (DriverFactory, ExcelUtils)
│       └── testdata   # DataProvider configurations
├── src/test/resources
│   └── LoginData.xlsx  # Excel test data
├── .github/workflows    # GitHub Actions pipeline
├── pom.xml              # Maven configuration
└── README.md

## Further Reading

- Explore utils/DriverFactory.java for ChromeOptions setup in CI
- Check reports/ package for ExtentReports integration
- Review .github/workflows/maven-ci.yml for CI pipeline details
