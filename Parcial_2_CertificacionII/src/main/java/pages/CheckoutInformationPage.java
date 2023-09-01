package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPage
{
    WebDriver driver;
    @FindBy (id = "first-name")
    WebElement firstNameField;
    @FindBy (id = "last-name")
    WebElement lastNameField;
    @FindBy (id = "postal-code")
    WebElement postalCodeField;
    @FindBy (id = "continue")
    WebElement buttonContinue;
    @FindBy (xpath = "//h3[@data-test='error']")
    WebElement errorMessage;
    @FindBy(id="cancel")
    WebElement buttonCancel;
    public CheckoutInformationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void setFistNameTextBox(String firstName)
    {
        firstNameField.sendKeys(firstName);
    }
    public void setLastNameTextBox(String lastName)
    {
        lastNameField.sendKeys(lastName);
    }
    public void setPostalCodeTextBox(String postalCode)
    {
        postalCodeField.sendKeys(postalCode);
    }
    public void clickOnContinueButton()
    {
        buttonContinue.click();
    }
    public boolean isErrorTextDisplayed(String error)
    {
        String actualErrorMessage = errorMessage.getText();
        return error.equalsIgnoreCase(actualErrorMessage);
    }
    public boolean isContinueButtonVisible()
    {
        return buttonContinue.isDisplayed();
    }
    public void clickOnCancelButton()
    {
        buttonCancel.click();
    }
}
