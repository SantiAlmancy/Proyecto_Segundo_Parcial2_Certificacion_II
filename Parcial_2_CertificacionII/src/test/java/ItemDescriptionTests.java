import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ItemDescriptionPage;
import pages.LoginPage;
import utilities.DriverManager;

public class ItemDescriptionTests extends BaseTest
{
    @Test
    public void clickOnItem()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        String productName = "Sauce Labs Backpack";
        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnItem(productName);

        ItemDescriptionPage itemPage = new ItemDescriptionPage(DriverManager.getDriver().driver);
        Assertions.assertTrue(itemPage.isItemDisplayed(productName));
    }
    @Test
    public void returnFromItemDescription()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        String productName = "Sauce Labs Backpack";
        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnItem(productName);

        ItemDescriptionPage itemPage = new ItemDescriptionPage(DriverManager.getDriver().driver);
        Assertions.assertTrue(itemPage.isItemDisplayed(productName));

        itemPage.clickOnReturnLink();
        Assertions.assertTrue(homePage.isComboBoxDisplayed());
    }
}
