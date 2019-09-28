package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TwitterPage {

//    Login Elements
    @FindBy(linkText = "Log in")
    WebElement loginButton;
    @FindBy(xpath = "//input[@placeholder='Phone, email or username']")
    WebElement usernameTextBox;
    @FindBy(xpath = "//input[@class='js-password-field']")
    WebElement passwordTextBox;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButtonAfterEnteringCredentials;

//Sign Up elements
    @FindBy(linkText = "Sign up")
    WebElement signUpButton;
    @FindBy(xpath = "//input[@name='name']")
    WebElement nameTextBox;
    @FindBy(name = "phone_number")
    WebElement phoneNumberTextBox;
    @FindBy(xpath = "//select[@aria-label='Month']")
    WebElement dropDownMonth;
    @FindBy(xpath = "//select[contains(@aria-label,'Day')]")
    WebElement dropDownDay;
    @FindBy(xpath = "//select[@aria-label='Year']")
    WebElement dropDownYear;
    @FindBy(xpath = "//div[@role='button']")
    WebElement nextButtonToSignUp;

//    Sign Up Method
    public void signUpOnTwitter(String name, String phoneNumber, String month, String day, String year) throws InterruptedException {

        signUpButton.click();
        Thread.sleep(3000);
        nameTextBox.sendKeys(name);
        phoneNumberTextBox.sendKeys(phoneNumber);
        Select monthSelect = new Select(dropDownMonth);
        monthSelect.selectByValue(month);
        Select daySelect = new Select(dropDownDay);
        daySelect.selectByValue(day);
        Select yearSelect = new Select(dropDownYear);
        yearSelect.selectByValue(year);
        nextButtonToSignUp.click();
    }

//    Login Method
    public void logInToTwitter(String username, String password){
        loginButton.click();
        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        loginButtonAfterEnteringCredentials.click();
    }

}
