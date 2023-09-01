package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YourCartPage
{
    WebDriver driver;
    @FindBy(className = "inventory_item_name")
    List<WebElement> productNames;
    @FindBy(id = "checkout")
    WebElement buttonCheckout;
    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;

    public YourCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductDisplayed(String product){
        for (WebElement element: productNames) {
            if(element.getText().equalsIgnoreCase(product)){
                return true;
            }
        }
        return false;
    }

    public void removeProduct(String product){
        //sauce-labs-bike-bight
        //remove-
        String productLowerCase = product.toLowerCase();
        productLowerCase = productLowerCase.replace(" ", "-");
        String removeProductId = "remove-"+productLowerCase;
        WebElement removeButton = driver.findElement(By.id(removeProductId));
        removeButton.click();
    }

    public double getPriceProduct(String product)
    {
        String productLowerCase = product.toLowerCase();
        productLowerCase = productLowerCase.replace(" ", "-");
        String removeProductId = "remove-"+productLowerCase;
        WebElement button = driver.findElement(By.id(removeProductId));

        WebElement priceElement = button.findElement(By.xpath("../div[@class='inventory_item_price']"));
        String price = priceElement.getText().replaceAll("[^0-9.]", "");
        return Double.parseDouble(price);
    }
    public String getAddedProductDescription(String product)
    {
        String productLowerCase = product.toLowerCase();
        productLowerCase = productLowerCase.replace(" ", "-");
        String removeProductId = "remove-"+productLowerCase;
        WebElement button = driver.findElement(By.id(removeProductId));

        WebElement descriptionElement = button.findElement(By.xpath("../preceding-sibling::div[@class='inventory_item_desc']"));
        return descriptionElement.getText();
    }
    public void clickOnCheckoutButton()
    {
        buttonCheckout.click();
    }
    public void clickOnContinueShoppingButton()
    {
        continueShoppingButton.click();
    }
    public boolean correctAddedItems(int quantity)
    {
        List<WebElement> badgeElements = driver.findElements(By.className("shopping_cart_badge"));
        if (!badgeElements.isEmpty())
        {
            WebElement badgeElement = badgeElements.get(0);
            String badgeValue = badgeElement.getText();
            int actualQuantity = Integer.parseInt(badgeValue);
            return (quantity == actualQuantity);
        }
        else
        {
            return (quantity == 0);
        }
    }
    public boolean isCheckOutButtonDisplayed()
    {
        return buttonCheckout.isDisplayed();
    }
}
