// File: src/test/java/testsuite/LoginTest.java
package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private static final String BASE_URL = "https://www.saucedemo.com/";

    @Before
    public void beforeTest() {
        // Setup the WebDriver before each test
        setup();
    }

    @After
    public void afterTest() {
        // Tear down the WebDriver after each test
        tearDown();
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Navigate to the base URL
        driver.get(BASE_URL);

        // Enter "standard_user" username
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");

        // Enter "secret_sauce" password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");

        // Click on 'LOGIN' button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify the text "PRODUCTS"
        WebElement productsText = driver.findElement(By.xpath("//div[@class='product_label' and text()='Products']"));
        assertTrue("PRODUCTS text is not displayed", productsText.isDisplayed());
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Assuming the login is already done (reuse the login steps)

        // Verify that six products are displayed on the page
        int productCount = driver.findElements(By.className("inventory_item")).size();

        // You can perform further verifications/assertions on the productCount
        assertEquals("Number of products displayed is not six", 6, productCount);
    }
}
