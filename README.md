# Selenium Java Automation - SauceDemo

End-to-end UI automation framework for SauceDemo using Selenium WebDriver, Java, and TestNG.

## Tech Stack
- Java 17
- Selenium WebDriver
- TestNG
- Apache POI (Excel Data-Driven)
- ExtentReports (HTML Reporting)
- GitHub Actions (CI/CD)

## Features
- Page Object Model (POM) for maintainable test structure
- Data-driven testing using Excel
- Automated HTML reporting
- CI pipeline with GitHub Actions
- End-to-end test scenarios for SauceDemo

## Test Coverage
- Login functionality
- Product listing and selection
- Cart and checkout flow
- Basic validation scenarios

## Project Structure
- src/main/java -> Page objects & utilities  
- src/test/java -> Test classes  
- src/test/resources -> Test data (Excel)  
- .github/workflows -> CI pipeline  

## How to Run

- mvn clean test

## Notes

This project demonstrates a basic Selenium automation framework with:

- Separation between test logic and page objects
- Reusable components
- Integration with CI/CD pipeline
