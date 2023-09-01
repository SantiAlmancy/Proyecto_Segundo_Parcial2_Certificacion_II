package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;

import java.time.Duration;

public class MenuPage
{
    WebDriver driver;
    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;

    public MenuPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickOnMenuButton()
    {
        menuButton.click();
    }
    public void clickOnAboutButton()
    {
        WebElement logoutLink = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("about_sidebar_link")));
        logoutLink.click();
    }
    public void clickOnLogoutButton()
    {
        WebElement logoutLink = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        logoutLink.click();
    }

    public void clickOnResetStateButton()
    {
        WebElement logoutLink = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("reset_sidebar_link")));
        logoutLink.click();
    }


}
