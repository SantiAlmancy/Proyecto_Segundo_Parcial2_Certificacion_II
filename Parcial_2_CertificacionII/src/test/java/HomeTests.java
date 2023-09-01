import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverManager;

public class HomeTests extends BaseTest
{

    @Test
    public void orderingFromZToA()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.selectSortComboBox("Name (Z to A)");

        Assertions.assertTrue(homePage.areProductsInDescendantOrderByName());
    }

    @Test
    public void orderingFromAtoZ()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.selectSortComboBox("Name (A to Z)");

        Assertions.assertTrue(homePage.areProductsInAscendantOrderByName());
    }
    @Test
    public void orderingFromLowerToHigherPrice()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.selectSortComboBox("Price (low to high)");

        Assertions.assertTrue((homePage.areProductsInAscendantOrderByPrice()));
    }
    @Test
    public void orderingFromHigherToLowerPrice()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.selectSortComboBox("Price (high to low)");

        Assertions.assertTrue((homePage.areProductsInDescendantOrderByPrice()));
    }
    @Test
    public void buttonModifiedToRemoveWhenAddedProduct()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");

        Assertions.assertTrue(homePage.doesButtonRemoveExistForProduct("Sauce Labs Fleece Jacket"));
        Assertions.assertTrue(homePage.doesButtonRemoveExistForProduct("Sauce Labs Bike Light"));
    }

    @Test
    public void buttonModifiedToAddToCartWhenDeletedProduct()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");

        homePage.removeProduct("Sauce Labs Fleece Jacket");
        homePage.removeProduct("Sauce Labs Bike Light");

        Assertions.assertTrue(homePage.doesButtonAddExistForProduct("Sauce Labs Fleece Jacket"));
        Assertions.assertTrue(homePage.doesButtonAddExistForProduct("Sauce Labs Bike Light"));
    }
    @Test
    public void incrementedCartWhenAddedProduct()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");

        Assertions.assertTrue(homePage.correctAddedItems(2));
    }

    @Test
    public void decreasedCartWhenDeletedProduct()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");
        homePage.addProductToCart("Sauce Labs Onesie");

        homePage.removeProduct("Sauce Labs Fleece Jacket");
        homePage.removeProduct("Sauce Labs Bike Light");

        Assertions.assertTrue(homePage.correctAddedItems(1));
    }
}
