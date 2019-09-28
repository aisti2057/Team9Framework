package mainwebsite;

import base.HomePageObject;
import common.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class HomePageTest extends CommonAPI {

    @Test
    public void testLogin() {

        clickByText("Login");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        typeOnElementNEnter("username", "tomtom2020@gmail.com");
        typeOnElementNEnter("password", "123456");
        clickOnElement("loginbutton");
    }

    @Test
    public void spanishVersion(){
        HomePageObject homePageObject = PageFactory.initElements(driver, HomePageObject.class);
        homePageObject.switchLangToSpanish();
    }

    @Test
    public void businessReg() throws InterruptedException {
        driver.findElement(By.xpath("//a[@id='-1236640864']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'an Aetna® rep')]")).click();
        Select select = new Select(driver.findElement(By.xpath("//select[@id='cb-business']")));
        select.selectByValue("aetna-student-health");
        Select select2 = new Select(driver.findElement(By.xpath("//select[@id='cb-state']")));
        select2.selectByValue("new-business");
        System.out.println(driver.findElement(By.id("section-aetna-student-health-new-business")).getText());
    }

    @Test
    public void getAQuoteForSmallBiz () {
        clickOnElement("//button[contains(text(),'Employers')]");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'For small businesses')]"))).build().perform();
        clickOnElement("//a[@id='-1938640504']");
    }
}
