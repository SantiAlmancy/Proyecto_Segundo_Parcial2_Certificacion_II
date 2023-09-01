import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import utilities.DriverManager;

public class MenuTests extends BaseTest
{
    @Test
    public void aboutSwagLabs()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        MenuPage menuPage = new MenuPage(DriverManager.getDriver().driver);
        menuPage.clickOnMenuButton();
        menuPage.clickOnAboutButton();
        Assertions.assertEquals(DriverManager.getDriver().driver.getCurrentUrl(), "https://saucelabs.com/");
    }

    @Test
    public void logoutFromMenu()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        MenuPage menuPage = new MenuPage(DriverManager.getDriver().driver);
        menuPage.clickOnMenuButton();
        menuPage.clickOnLogoutButton();

        Assertions.assertEquals(DriverManager.getCurrentURL(), "https://www.saucedemo.com/");
    }

    @Test
    public void resetAppState()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");

        MenuPage menuPage = new MenuPage(DriverManager.getDriver().driver);
        menuPage.clickOnMenuButton();
        menuPage.clickOnResetStateButton();

        Assertions.assertTrue(homePage.areProductButtonsDefault());
        Assertions.assertTrue(homePage.correctAddedItems(0));
    }

    @Test
    public void allItemsFromMenu()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnShoppingCartButton();

        MenuPage menuPage = new MenuPage(DriverManager.getDriver().driver);
        menuPage.clickOnMenuButton();
        menuPage.clickOnAllItemsButton();

        Assertions.assertTrue(homePage.isComboBoxDisplayed());
    }
}
