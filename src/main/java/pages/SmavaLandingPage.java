package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.components.Amount;
import pages.components.Category;
import pages.components.Duration;

import static org.openqa.selenium.By.cssSelector;

public class SmavaLandingPage extends BasePage {
    public SmavaLandingPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[text() ='Verwendung']/../following-sibling::*//div[@class = 'Select-value']")
    private WebElement categoryDropDownInCalulator;

    @FindBy(xpath = "//*[text() ='Nettokreditbetrag']/../following-sibling::*//div[@class = 'Select-value']")
    private WebElement amountDropDownInCalulator;

    @FindBy(xpath = "//*[text() ='Laufzeit']/../following-sibling::*//div[@class = 'Select-value']")
    private WebElement durationDropDownInCalulator;

    @FindBy(css = "a.Button__button")
    private WebElement nextButtonInCalculator;

    @FindBy(xpath = "//span[text() = 'Anmelden']")
    private WebElement loginButtonTopMenu;

    @FindBy(css = ".Popup__content input[name='email']")
    private WebElement loginInputPopupContent;

    @FindBy(css = ".Popup__content input[name='password']")
    private WebElement passwordInputPopupContent;

    @FindBy(css = ".Popup__content *[type='submit']")
    private WebElement submitButtonLoginPopupContent;

    public SmavaLandingPage openSmavaLandingPage(){
        driver.get("https://www.smava.de");
        return this;
    }

    public SmavaLandingPage selectCategoryInLoanCalculator(Category category){
        waitVisibilityAndClickOn(categoryDropDownInCalulator);
        waitVisibilityAndClickOn(locateCategoryInDropdown(category));
        return this;
    }

    private By locateCategoryInDropdown(Category category){
        return cssSelector(".Select-option[aria-label = '" + category.getValue() + "']");
    }

    public SmavaLandingPage selectAmountInLoanCalculator(Amount amount){
        waitVisibilityAndClickOn(amountDropDownInCalulator);
        waitVisibilityAndClickOn(locateAmountInDropdown(amount));
        return this;
    }

    private By locateAmountInDropdown(Amount amount){
        return cssSelector(".Select-option[aria-label *= '" + amount.getValue() + "']");
    }

    public SmavaLandingPage selectDurationInLoanCalculator(Duration duration){
        waitVisibilityAndClickOn(durationDropDownInCalulator);
        waitVisibilityAndClickOn(duration.getLocator());
        return this;
    }

    public ContactInfoLoanApplicationPage clickNextButtonInLoanCalculator(){
        waitVisibilityAndClickOn(nextButtonInCalculator);
        return new ContactInfoLoanApplicationPage(driver);
    }

    public SmavaLandingPage clickOnLoginButtonOnTopMenu(){
        waitVisibilityAndClickOn(loginButtonTopMenu);
        return this;
    }

    public SmavaLandingPage typeEmailInLoginPopupContent(String email){
        waitVisibilityAndType(loginInputPopupContent, email);
        return this;
    }

    public SmavaLandingPage typePasswordInLoginPopupContent(String password){
        waitVisibilityAndType(passwordInputPopupContent, password);
        return this;
    }

    public SmavaLandingPage clickOnLoginButtonLoginPopup(){
        waitVisibilityAndClickOn(submitButtonLoginPopupContent);
        return this;
    }

    public boolean isSmavaLandingPage() {
        return getTitle().equals("SMAVA Online-Kreditvergleich | unabhängig und kundenorientiert");
    }

    public boolean isLoginButtonOnTopMenuDisplayed() {
        return waitVisibilityOf(loginButtonTopMenu).isDisplayed();
    }
}
