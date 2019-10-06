package pageObjects;

import common.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

public class AccountPage extends CommonAPI {

    @FindBy(xpath = "//div[@aria-label='More menu items']")
    WebElement moreButton;

    @FindBy(linkText = "Settings and privacy")
    WebElement settingsTab;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-13awgt0 r-18u37iz r-1wtj0ep']")
    WebElement usernameButton;

    @FindBy(linkText = "Account")
    WebElement accountButton;

    @FindBy(linkText = "Content preferences")
    WebElement contentButton;

    @FindBy(linkText = "Search settings")
    WebElement searchSettingsButton;

    @FindBy(linkText = "Phone")
    WebElement setPhone;

    @FindBy(xpath = "//input[@name='phone']")
    WebElement inputPhoneNumberBox;

    public void accountSecurity() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        moreButton.click();
        settingsTab.click();
        usernameButton.click();
        Thread.sleep(3000);
    }

    public void changeName(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        moreButton.click();
        settingsTab.click();
        accountButton.click();
        usernameButton.click();
    }

    public void contentPreferences() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        moreButton.click();
        settingsTab.click();
        contentButton.click();
        searchSettingsButton.click();
    }

    public void addRemovePhone(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        moreButton.click();
        settingsTab.click();
        setPhone.click();
        inputPhoneNumberBox.sendKeys("101010101");
    }




}
