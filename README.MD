# Selenium TestNG Automation Framework

## Project Overview

This project is an end-to-end test automation framework developed using Selenium WebDriver, Java, TestNG, Maven, and Page Object Model (POM).

The framework automates the complete purchase flow on the SauceDemo application, including product selection, cart validation, checkout process, order completion, and logout functionality.

The project was created to practice real-world automation framework design and demonstrate Selenium automation skills.

---

## Technologies Used

* Java
* Selenium WebDriver
* TestNG
* Maven
* Git & GitHub
* Page Object Model (POM)
* Apache POI (Excel Utility)

---

## Framework Features

### Login Functionality

* Login using valid credentials
* Login validation

### Product Page

* Add products to cart
* Remove products from cart
* Cart badge verification
* Dynamic product handling using reusable methods

### Cart Page

* Verify cart page navigation
* Verify selected products are displayed correctly
* Compare expected products with actual products

### Checkout Page

* Enter customer information
* Continue checkout process
* Validate successful navigation

### Checkout Overview Page

* Verify selected products
* Verify product count
* Validate item total calculation
* Validate tax and final total

### Checkout Complete Page

* Complete order
* Verify successful order placement
* Logout verification

### Additional Features

* Regression Test Suite
* Exploratory Test Suite
* Screenshot Utility
* Screenshot Listener
* Config Reader Utility
* Excel Utility

---

## Project Structure

src

├── base

│   └── BaseClass.java

├── pages

│   ├── LoginPage.java

│   ├── ProductPage.java

│   ├── CartPage.java

│   ├── CheckoutPage.java

│   ├── CheckoutOverviewPage.java

│   └── CheckoutCompletePage.java

├── tests

│   ├── LoginTest.java

│   ├── ProductTest.java

│   ├── ExploratoryProductTest.java

│   ├── CartTest.java

│   ├── CheckoutTest.java

│   ├── CheckoutOverviewTest.java

│   └── CheckoutCompleteTest.java

├── utilities

│   ├── ConfigReader.java

│   ├── ExcelUtility.java

│   ├── ScreenshotUtility.java

│   └── ScreenshotListener.java

---

## Test Scenarios Covered

### Regression Tests

* Login
* Add all products
* Verify cart badge
* Verify cart contents
* Checkout flow
* Verify totals
* Complete order
* Logout

### Exploratory Tests

* Random product selection
* Random product removal
* Cart validation for selected products

---

## How To Run

1. Clone the repository

git clone <repository-url>

2. Open project in Eclipse / IntelliJ

3. Update configuration if required

4. Run testng.xml

or

Run individual TestNG test classes.

---

## Design Patterns Used

* Page Object Model (POM)
* Reusable Utility Classes
* TestNG Framework Structure
* Data-Driven Support using Excel

---

## Author

Gitanjali Harkare

Automation Testing Framework created as part of Selenium WebDriver with Java learning and interview preparation.
