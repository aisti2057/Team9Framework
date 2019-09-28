package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.Text;

public class HomePageObject {

    @FindBy(xpath = "//a[@id='-322400938']")
    WebElement logInButton;


    @FindBy(xpath = "//a[@id='-1214480643']")
    WebElement switchToEspanol;

    @FindBy(linkText = "/individuals-families/find-a-doctor.html")
    WebElement findDoctorsButton;

    @FindBy(linkText = "https://www.aetnacareers.com")
    WebElement careersButton;

    @FindBy(linkText = "/faqs-health-insurance.html")
    WebElement fAQButton;

    @FindBy(linkText = "Get to know us")
    WebElement AboutusButton;


    public void testLoginButton() {
        this.logInButton.click();
    }
    public void switchLangToSpanish() {
        this.switchToEspanol.click();
    }
}





