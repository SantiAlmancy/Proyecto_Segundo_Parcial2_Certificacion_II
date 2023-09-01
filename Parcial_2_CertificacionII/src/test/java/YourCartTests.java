import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.YourCartPage;
import utilities.DriverManager;

public class YourCartTests extends BaseTest
{
    @Test
    public void verifyYourCartProductNameWhenAProductIsAdded()
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
    }

    @Test
    public void verifyProductIsRemovedFromYourCartPage()
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
        yourCartPage.removeProduct("Sauce Labs Fleece Jacket");

        Assertions.assertFalse((yourCartPage.isProductDisplayed("Sauce Labs Fleece Jacket")));
    }

    @Test
    public void verifyPricesOfAddedProducts()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");
        homePage.addProductToCart("Sauce Labs Onesie");

        double price1i = homePage.getPriceAddedProduct("Sauce Labs Fleece Jacket");
        double price2i= homePage.getPriceAddedProduct("Sauce Labs Bike Light");
        double price3i= homePage.getPriceAddedProduct("Sauce Labs Onesie");

        homePage.clickOnShoppingCartButton();

        YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver().driver);

        double price1f = yourCartPage.getPriceProduct("Sauce Labs Fleece Jacket");
        double price2f = yourCartPage.getPriceProduct("Sauce Labs Bike Light");
        double price3f = yourCartPage.getPriceProduct("Sauce Labs Onesie");

        Assertions.assertEquals(price1i, price1f);
        Assertions.assertEquals(price2i, price2f);
        Assertions.assertEquals(price3i, price3f);
    }

    @Test
    public void verifyDescriptionOfAddedProducts()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");
        homePage.addProductToCart("Sauce Labs Onesie");

        String desc1i = homePage.getAddedProductDescription("Sauce Labs Fleece Jacket");
        String desc2i = homePage.getAddedProductDescription("Sauce Labs Bike Light");
        String desc3i = homePage.getAddedProductDescription("Sauce Labs Onesie");

        homePage.clickOnShoppingCartButton();

        YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver().driver);

        String desc1f = yourCartPage.getAddedProductDescription("Sauce Labs Fleece Jacket");
        String desc2f = yourCartPage.getAddedProductDescription("Sauce Labs Bike Light");
        String desc3f = yourCartPage.getAddedProductDescription("Sauce Labs Onesie");

        Assertions.assertEquals(desc1i, desc1f);
        Assertions.assertEquals(desc2i, desc2f);
        Assertions.assertEquals(desc3i, desc3f);
    }

    
}
