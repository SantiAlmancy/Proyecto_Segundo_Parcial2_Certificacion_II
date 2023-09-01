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
    
}
