import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverManager;

public class FooterTests extends BaseTest
{
    @Test
    public void twitterRedirection()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnTwitterLink();

        DriverManager.switchToNextWindow();
        String expectedUrl = "https://twitter.com/saucelabs";
        String newUrl = DriverManager.getCurrentURL();
        Assertions.assertEquals(expectedUrl, newUrl);

        DriverManager.closeAndSwitchToPreviousWindow();
    }
    @Test
    public void facebookRedirection()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnFacebookLink();

        DriverManager.switchToNextWindow();
        String expectedUrl = "https://www.facebook.com/saucelabs";
        String newUrl = DriverManager.getCurrentURL();
        Assertions.assertEquals(expectedUrl, newUrl);

        DriverManager.closeAndSwitchToPreviousWindow();
    }
    @Test
    public void linkedinRedirection()
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnLinkedinLink();

        DriverManager.switchToNextWindow();
        String expectedUrl = "https://www.linkedin.com/company/sauce-labs/";
        String newUrl = DriverManager.getCurrentURL();
        Assertions.assertEquals(expectedUrl, newUrl);

        DriverManager.closeAndSwitchToPreviousWindow();
    }
}
