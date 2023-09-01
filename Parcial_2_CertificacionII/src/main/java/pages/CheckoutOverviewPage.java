package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutOverviewPage
{
    WebDriver driver;
    @FindBy (id = "finish")
    WebElement buttonFinish;
    @FindBy(className = "inventory_item_name")
    List<WebElement> productNames;
    @FindBy(id="cancel")
    WebElement buttonCancel;

    public CheckoutOverviewPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isButtonFinishDisplayed()
    {
        return buttonFinish.isDisplayed();
    }

    public boolean isProductDisplayed(String product)
    {
        for (WebElement element: productNames) {
            if(element.getText().equalsIgnoreCase(product)){
                return true;
            }
        }
        return false;
    }

    public void clickOnFinishButton()
    {
        buttonFinish.click();
    }
    public void clickOnCancelButton()
    {
        buttonCancel.click();
    }

}
