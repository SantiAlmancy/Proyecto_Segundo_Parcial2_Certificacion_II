package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemDescriptionPage
{
    WebDriver driver;
    @FindBy(css = "div[class='inventory_details_name large_size']")
    WebElement itemName;
    @FindBy (id = "back-to-products")
    WebElement returnLink;

    public ItemDescriptionPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isItemDisplayed(String productName)
    {
        return (productName.equals(itemName.getText()));
    }
    public void clickOnReturnLink()
    {
        returnLink.click();
    }
}
