import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;
import utilities.DriverManager;

public class CheckoutOverviewTests extends BaseTest
{
    @Test
    public void verifyCheckoutOverviewProducts()
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
        checkoutPage.setFistNameTextBox("FirstName");
        checkoutPage.setLastNameTextBox("LastName");
        checkoutPage.setPostalCodeTextBox("1233");
        checkoutPage.clickOnContinueButton();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(DriverManager.getDriver().driver);
        Assertions.assertTrue(checkoutOverviewPage.isProductDisplayed("Sauce Labs Fleece Jacket"));
        Assertions.assertTrue(checkoutOverviewPage.isProductDisplayed("Sauce Labs Bike Light"));
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
        checkoutPage.setFistNameTextBox("FirstName");
        checkoutPage.setLastNameTextBox("LastName");
        checkoutPage.setPostalCodeTextBox("1233");
        checkoutPage.clickOnContinueButton();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(DriverManager.getDriver().driver);
        checkoutOverviewPage.clickOnCancelButton();

        Assertions.assertTrue(homePage.isComboBoxDisplayed());
    }
    @Test
    public void verifyCheckOutWithCorrectValuesAndSelectedProducts()
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
        checkoutPage.setFistNameTextBox("FirstName");
        checkoutPage.setLastNameTextBox("LastName");
        checkoutPage.setPostalCodeTextBox("1233");
        checkoutPage.clickOnContinueButton();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(DriverManager.getDriver().driver);
        Assertions.assertTrue(checkoutOverviewPage.isButtonFinishDisplayed());
    }
}
