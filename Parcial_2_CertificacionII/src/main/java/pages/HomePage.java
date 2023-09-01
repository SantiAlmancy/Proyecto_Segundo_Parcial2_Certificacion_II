package pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;

    @FindBy(className = "app_logo")
    WebElement pageTitle;
    @FindBy(className = "product_sort_container")
    WebElement sortComboBox;
    @FindBy(css = "a[href='https://twitter.com/saucelabs']")
    WebElement twitterLink;
    @FindBy(css = "a[href='https://www.facebook.com/saucelabs']")
    WebElement facebookLink;
    @FindBy(css = "a[href='https://www.linkedin.com/company/sauce-labs/']")
    WebElement linkedinLink;
    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCartButton;
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean pageTitleIsDisplayed()
    {
        return pageTitle.isDisplayed();
    }
    public void selectSortComboBox(String option)
    {
        Select selectObject = new Select(sortComboBox);
        selectObject.selectByVisibleText(option);
    }
    public boolean areProductsInDescendantOrderByName()
    {
        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        List<String> actualProductNames = new ArrayList<>();

        for( WebElement element: products){
            actualProductNames.add(element.getText());
        }

        return Ordering.natural().reverse().isOrdered(actualProductNames);
    }
    public boolean areProductsInAscendantOrderByName()
    {
        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        List<String> actualProductNames = new ArrayList<>();

        for( WebElement element: products){
            actualProductNames.add(element.getText());
        }

        return Ordering.natural().isOrdered(actualProductNames);
    }
    public boolean areProductsInDescendantOrderByPrice()
    {
        List<WebElement> products = driver.findElements(By.className("inventory_item_price"));
        List<Double> actualProductPrices = new ArrayList<>();

        for(WebElement element: products)
        {
            String priceText = element.getText().replaceAll("[^0-9.]", "");
            double price = Double.parseDouble(priceText);
            actualProductPrices.add(price);
        }

        return Ordering.natural().reverse().isOrdered(actualProductPrices);
    }
    public boolean areProductsInAscendantOrderByPrice()
    {
        List<WebElement> products = driver.findElements(By.className("inventory_item_price"));
        List<Double> actualProductPrices = new ArrayList<>();

        for(WebElement element: products)
        {
            String priceText = element.getText().replaceAll("[^0-9.]", "");
            double price = Double.parseDouble(priceText);
            actualProductPrices.add(price);
        }

        return Ordering.natural().isOrdered(actualProductPrices);
    }
    public void addProductToCart(String productName){
        String productNameLowerCase = productName.toLowerCase();
        productNameLowerCase = productNameLowerCase.replace(" ","-");
        String addToCartId = "add-to-cart-";
        addToCartId = addToCartId + productNameLowerCase;

        WebElement addToCartButton = driver.findElement(By.id(addToCartId));
        addToCartButton.click();
    }

    public boolean areProductButtonsDefault()
    {
        List<WebElement> buttonsProduct = driver.findElements(By.cssSelector("button[class='btn btn_secondary btn_small btn_inventory']"));
        for (WebElement button : buttonsProduct)
        {
            if (button.getText().equals("Remove"))
            {
                return false;
            }
        }
        return true;
    }

    public void clickOnItem(String productName)
    {
        WebElement productDiv = driver.findElement(By.xpath("//div[contains(text(), '" + productName + "')]"));
        WebElement productLink = productDiv.findElement(By.xpath("ancestor::a"));
        productLink.click();
    }
    public void clickOnShoppingCartButton()
    {
        shoppingCartButton.click();
    }
    public void clickOnTwitterLink()
    {
        twitterLink.click();
    }
    public void clickOnFacebookLink()
    {
        facebookLink.click();
    }
    public void clickOnLinkedinLink()
    {
        linkedinLink.click();
    }
    public boolean isComboBoxDisplayed()
    {
        return sortComboBox.isDisplayed();
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
    public double getPriceAddedProduct(String product)
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

        WebElement descriptionElement = button.findElement(By.xpath("../preceding-sibling::div[@class='inventory_item_label']/div[@class='inventory_item_desc']"));
        return descriptionElement.getText();
    }

    public boolean doesButtonAddExistForProduct(String product)
    {
        String productLowerCase = product.toLowerCase();
        productLowerCase = productLowerCase.replace(" ", "-");
        String removeProductId = "add-to-cart-"+productLowerCase;
        List<WebElement> button = driver.findElements(By.id(removeProductId));

        return (!button.isEmpty());
    }

    public boolean doesButtonRemoveExistForProduct(String product)
    {
        String productLowerCase = product.toLowerCase();
        productLowerCase = productLowerCase.replace(" ", "-");
        String removeProductId = "remove-"+productLowerCase;
        List<WebElement> button = driver.findElements(By.id(removeProductId));

        return (!button.isEmpty());
    }

    public void removeProduct(String product){
        String productLowerCase = product.toLowerCase();
        productLowerCase = productLowerCase.replace(" ", "-");
        String removeProductId = "remove-"+productLowerCase;
        WebElement removeButton = driver.findElement(By.id(removeProductId));
        removeButton.click();
    }
}