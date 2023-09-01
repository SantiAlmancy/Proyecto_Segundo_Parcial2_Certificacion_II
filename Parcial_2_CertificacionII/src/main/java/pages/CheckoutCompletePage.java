package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage
{
    WebDriver driver;
    @FindBy (id = "back-to-products")
    WebElement buttonBackToProducts;
    @FindBy (className = "complete-header")
    WebElement completeCheckoutMessage;
    public CheckoutCompletePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickOnBackToProductsButton()
    {
        buttonBackToProducts.click();
    }
    public boolean isCompleteCheckoutTextDisplayed(String message)
    {
        String actualErrorMessage = completeCheckoutMessage.getText();
        return message.equalsIgnoreCase(actualErrorMessage);
    }
}
