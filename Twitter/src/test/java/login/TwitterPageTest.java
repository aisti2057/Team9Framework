package login;

import common.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.TwitterPage;

public class TwitterPageTest extends CommonAPI {

    @Test
    public void loginTwitterAndUploadTest () throws InterruptedException {
        //logging in
        clickByText("Log in");
        driver.findElement(By.xpath("//input[@placeholder='Phone, email or username']")).sendKeys("oofoofoofoof@aol.com");
        driver.findElement(By.xpath("//input[@class='js-password-field']")).sendKeys("foofoofoofoo");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //upload a picture
        driver.findElement(By.xpath("//input[@accept='image/jpeg,image/png,image/webp,image/gif,video/mp4,video/quicktime']")).sendKeys("/Users/isti/Desktop/JuleSelenium2019/Team9Framework/Twitter/src/main/java/imgs/noTestMeme.jpeg");
        driver.findElement(By.xpath("//div[@class='css-18t94o4 css-1dbjc4n r-urgr8i r-42olwf r-sdzlij r-1phboty r-rs99b7 r-1w2pmg r-1n0xq6e r-1vuscfd r-1dhvaqw r-1fneopy r-o7ynqc r-6416eg r-lrvibr']")).click();
    }

    @Test
    public void signUpUsingPOM() throws InterruptedException {
        TwitterPage twitterPage = PageFactory.initElements(driver, TwitterPage.class);
        twitterPage.signUpOnTwitter("Dimitri", "6463936406", "6", "21", "1940");
    }

    @Test
    public void logInToTwitterUsingPOM() throws InterruptedException {

        TwitterPage twitterPage = PageFactory.initElements(driver, TwitterPage.class);
        twitterPage.logInToTwitter("oofoofoofoof@aol.com", "foofoofoofoo");
        driver.findElement(By.xpath("//a[@href='/notifications']")).click();
        Thread.sleep(4000);
    }
}
