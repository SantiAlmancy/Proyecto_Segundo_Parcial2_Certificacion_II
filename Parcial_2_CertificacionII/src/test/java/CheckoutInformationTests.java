import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CheckoutInformationPage;
import pages.HomePage;
import pages.LoginPage;
import pages.YourCartPage;
import utilities.DriverManager;

public class CheckoutInformationTests extends BaseTest
{
    @Test
    public void verifyCheckOutFromCartIfProductsSelected()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");

        homePage.clickOnShoppingCartButton();

        YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver().driver);

        yourCartPage.clickOnCheckoutButton();

        CheckoutInformationPage checkoutPage = new CheckoutInformationPage(DriverManager.getDriver().driver);
        Assertions.assertTrue(checkoutPage.isContinueButtonVisible());
    }
    @Test
    public void verifyCheckOutFromCartIfProductsNotSelected()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);

        homePage.clickOnShoppingCartButton();

        YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver().driver);

        yourCartPage.clickOnCheckoutButton();

        CheckoutInformationPage checkoutPage = new CheckoutInformationPage(DriverManager.getDriver().driver);
        Assertions.assertFalse(checkoutPage.isContinueButtonVisible());
    }

    @Test
    public void cancelCheckOut()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");

        homePage.clickOnShoppingCartButton();

        YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver().driver);
        yourCartPage.clickOnCheckoutButton();

        CheckoutInformationPage checkoutPage = new CheckoutInformationPage(DriverManager.getDriver().driver);
        checkoutPage.clickOnCancelButton();

        Assertions.assertTrue(yourCartPage.isCheckOutButtonDisplayed());
    }
    @Test
    public void verifyCheckOutWithEmptyFirstName()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");

        homePage.clickOnShoppingCartButton();

        YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver().driver);
        yourCartPage.clickOnCheckoutButton();

        CheckoutInformationPage checkoutPage = new CheckoutInformationPage(DriverManager.getDriver().driver);
        checkoutPage.setFistNameTextBox("");
        checkoutPage.setLastNameTextBox("Lastname");
        checkoutPage.setPostalCodeTextBox("1233");
        checkoutPage.clickOnContinueButton();

        Assertions.assertTrue(checkoutPage.isErrorTextDisplayed("Error: First Name is required"));
    }

    @Test
    public void verifyCheckOutWithEmptyLastName()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");

        homePage.clickOnShoppingCartButton();

        YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver().driver);
        yourCartPage.clickOnCheckoutButton();

        CheckoutInformationPage checkoutPage = new CheckoutInformationPage(DriverManager.getDriver().driver);
        checkoutPage.setFistNameTextBox("Firstname");
        checkoutPage.setLastNameTextBox("");
        checkoutPage.setPostalCodeTextBox("1233");
        checkoutPage.clickOnContinueButton();

        Assertions.assertTrue(checkoutPage.isErrorTextDisplayed("Error: Last Name is required"));
    }

    @Test
    public void verifyCheckOutWithEmptyPostalCodeAndSelectedProducts()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");

        homePage.clickOnShoppingCartButton();

        YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver().driver);
        Assertions.assertTrue(yourCartPage.isProductDisplayed("Sauce Labs Fleece Jacket"));
        Assertions.assertTrue(yourCartPage.isProductDisplayed("Sauce Labs Bike Light"));

        yourCartPage.clickOnCheckoutButton();

        CheckoutInformationPage checkoutPage = new CheckoutInformationPage(DriverManager.getDriver().driver);
        checkoutPage.setFistNameTextBox("Firstname");
        checkoutPage.setLastNameTextBox("Lastname");
        checkoutPage.setPostalCodeTextBox("");
        checkoutPage.clickOnContinueButton();

        Assertions.assertTrue(checkoutPage.isErrorTextDisplayed("Error: Postal Code is required"));
    }

    @Test
    public void verifyCheckOutWithInvalidPostalCodeAndSelectedProducts()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");

        homePage.clickOnShoppingCartButton();

        YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver().driver);
        Assertions.assertTrue(yourCartPage.isProductDisplayed("Sauce Labs Fleece Jacket"));
        Assertions.assertTrue(yourCartPage.isProductDisplayed("Sauce Labs Bike Light"));

        yourCartPage.clickOnCheckoutButton();

        CheckoutInformationPage checkoutPage = new CheckoutInformationPage(DriverManager.getDriver().driver);
        checkoutPage.setFistNameTextBox("Firstname");
        checkoutPage.setLastNameTextBox("Lastname");
        checkoutPage.setPostalCodeTextBox("aabcd");
        checkoutPage.clickOnContinueButton();

        Assertions.assertTrue(checkoutPage.isErrorTextDisplayed("Error: Postal Code is not valid"));
    }
}
