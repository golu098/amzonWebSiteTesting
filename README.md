# **Amazon E-commerce Automation Testing**

## **Project Overview**
This project automates testing scenarios for the **Amazon** e-commerce website using the **BDD approach**. The automation framework leverages **Selenium**, **TestNG**, **Cucumber**, and additional tools to perform cross-browser testing, parallel execution, and reporting with **Allure** and TestNG.

The project also includes advanced test scenarios such as handling dropdowns, performing actions (e.g., mouse hover, drag-and-drop), executing JavaScript commands, verifying broken links, handling checkboxes, and capturing screenshots for failed tests.

---

## **Technologies Used**
- **Programming Language**: Java
- **Automation Tools**:
   - Selenium WebDriver
   - Cucumber (for BDD)
   - TestNG (for test execution)
   - Allure (for detailed reporting)
- **Build Tool**: Maven
- **Browser Support**: Chrome, Firefox, Edge, Safari
- **Dependency Manager**: Maven
- **Reporting Tools**:
   - Allure Reports
   - TestNG Reports
- **Other Features**:
   - Parallel execution
   - Cross-browser testing
   - Screenshots for failed tests

---

## **Tested Features**
The following features of the Amazon website are tested in this project:

### **Basic Functionalities**
1. **Home Page** 
   - Verify homepage load successfully.
   - Validate the presence of critical elements like the search bar, cart icon, and account menu.

2. **Search Functionality** 
   - Search for specific products (e.g., "laptop", "mobile").
   - Validate that search results are displayed correctly.
   - Verify sorting and filtering options.

3. **Product Details Page** 
   - Click on a product and verify the product details page.
   - Validate details like product name, price, availability, and reviews.

4. **Add to Cart**
   - Add products to the cart.
   - Verify cart count and details.
   - Validate product persistence in the cart.

5. **Login Functionality**
   - Test login with valid credentials.
   - Validate error messages for incorrect login.

6. **Dropdowns and Select**
   - Verify dropdowns (e.g., category filters).
   - Use Selenium’s `Select` class for validation.

### **Advanced Functionalities**
1. **Actions Class** 
   - Perform mouse hover over menus.
   - Test drag-and-drop functionality.

2. **JavaScript Executor**
   - Scroll to specific elements.
   - Perform clicks on hidden elements using JS Executor.

3. **Checkbox and Radio Button** 
   - Verify selection and de-selection of checkboxes and radio buttons.

4. **Broken Links**
   - Detect and validate broken links on pages.

5. **Parallel Testing** 
   - Run tests simultaneously across multiple browsers to save execution time.

6. **Cross-Browser Testing** 
   - Validate compatibility across Chrome, Firefox, Edge, and Safari.

7. **Screenshots for Failed Tests**  
   - Capture screenshots for failed tests automatically for debugging purposes.

---

## **Project Structure**


├── src/


│   ├── main/


│   │   ├── java/


│   │   │   └── com/


│   │   │       └── package/


│   │   │           ├── api/


│   │   │           ├── db/


│   │   │           ├── driver/


│   │   │           ├── models/


│   │   │           ├── pages/


│   │   │           ├── utils/


│   │   └── resources/


│   │       ├── config/


│   │       └── data/


│   └── test/


│       ├── java/


│       │   └── com/


│       │       └── package/


│       │           ├── stepdefinitions/


│       │           ├── runners/


│       │           └── hooks/


│       └── resources/


│           ├── features/


│           ├── testdata/


│           └── config/


└── build/


---

## **How to Run the Tests**

### Prerequisites
- Java JDK 8+ installed
- Maven installed
- ChromeDriver, GeckoDriver, or other browser drivers installed

### Steps
1. Clone this repository:
   ```bash
   git clone <repository-url>
2. Navigate to the project directory and install dependencies:
   ```bash
   mvn clean install

3. Run tests with TestNG:
   ```bash
   mvn test
4. Generate Allure Report:
   ```bash
   allure serve allure-results