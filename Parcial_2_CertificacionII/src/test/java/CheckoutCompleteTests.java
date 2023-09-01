import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;
import utilities.DriverManager;

public class CheckoutCompleteTests extends BaseTest
{
    @Test
    public void checkOutCompletedSuccessfully()
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
        checkoutPage.setFistNameTextBox("All");
        checkoutPage.setLastNameTextBox("Might");
        checkoutPage.setPostalCodeTextBox("1233");
        checkoutPage.clickOnContinueButton();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(DriverManager.getDriver().driver);
        checkoutOverviewPage.clickOnFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(DriverManager.getDriver().driver);
        Assertions.assertTrue(checkoutCompletePage.isCompleteCheckoutTextDisplayed("Thank you for your order!"));
    }

    @Test
    public void emptyCartAfterCheckoutFinalization()
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
        checkoutPage.setFistNameTextBox("All");
        checkoutPage.setLastNameTextBox("Might");
        checkoutPage.setPostalCodeTextBox("1233");
        checkoutPage.clickOnContinueButton();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(DriverManager.getDriver().driver);
        checkoutOverviewPage.clickOnFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(DriverManager.getDriver().driver);
        checkoutCompletePage.clickOnBackToProductsButton();

        Assertions.assertTrue(homePage.correctAddedItems(0));
        Assertions.assertTrue(homePage.areProductButtonsDefault());
    }

}
