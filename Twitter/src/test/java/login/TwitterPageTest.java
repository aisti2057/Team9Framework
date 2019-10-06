package login;

import com.aventstack.extentreports.reporter.configuration.Theme;
import common.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.TwitterPage;
import pageObjects.UserHomePage;
import reporting.TestLogger;

public class TwitterPageTest extends CommonAPI {
    TwitterPage twitterPage;
    UserHomePage userHomePage;
    AccountPage accountPage;

    public void logInTwitter() {
        accessTwitterPage();
        twitterPage.logInToTwitter("oofoofoofoof@aol.com", "foofoofoofoo");
    }
    public void accessTwitterPage() {
        this.twitterPage =  PageFactory.initElements(driver, TwitterPage.class);
    }

    public void accessUserHP() { this.userHomePage = PageFactory.initElements(driver, UserHomePage.class);}

    public void accessAccPage(){ this.accountPage = PageFactory.initElements(driver, AccountPage.class);}

    @Test
    public void loginTwitterAndUploadTest() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        //logging in
        logInTwitter();
        //upload a picture
        driver.findElement(By.xpath("//input[@accept='image/jpeg,image/png,image/webp,image/gif,video/mp4,video/quicktime']")).sendKeys("/Users/isti/Desktop/JuleSelenium2019/Team9Framework/Twitter/src/main/java/imgs/noTestMeme.jpeg");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='css-18t94o4 css-1dbjc4n r-urgr8i r-42olwf r-sdzlij r-1phboty r-rs99b7 r-1w2pmg r-1n0xq6e r-1vuscfd r-1dhvaqw r-1fneopy r-o7ynqc r-6416eg r-lrvibr']")).click();
    }

    @Test
    public void signUpUsingPOM() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        accessTwitterPage();
        twitterPage.signUpOnTwitter("Dimitri", "6463936406", "6", "21", "1940");
    }

    @Test
    public void loginUsingWrongCreds(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        accessTwitterPage();
        twitterPage.logInToTwitter("abracadabra", "babadook");
    }

    @Test
    public void loginWithoutPassword () {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        accessTwitterPage();
        twitterPage.logInToTwitter("abracadabra", "");
    }

    @Test
    public void signUpUsingWrongCredentials() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        accessTwitterPage();
        twitterPage.signUpOnTwitter("Massi", "0000000", "January", "21", "2025");
    }

    @Test
    public void logInToTwitterUsingPOM() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        logInTwitter();
    }

    @Test
    public void tweet() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessUserHP();
        userHomePage.tweetATweet("This is an Automated tweet");
    }

    @Test
    public void searchTwitterTest() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessUserHP();
        userHomePage.searchTwitter("Donald Trump");
    }

    @Test
    public void searchAndFollow() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessTwitterPage();
        accessUserHP();
        userHomePage.searchTwitterAndFollow("@Oracle");

    }

    @Test
    public void searchHashtag() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessUserHP();
        userHomePage.searchTwitter("#PresidentialDebate2016");
    }



    @Test
    public void followSomeoneAndTweet() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessTwitterPage();
        accessUserHP();
        userHomePage.searchTwitterAndFollow("@Vice");
    }

    @Test
    public void followUnrecognizedUser() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessTwitterPage();
        accessUserHP();
        userHomePage.searchTwitterAndFollow("@abracadabraoobrafoobra");
    }

    @Test
    public void searchListTwitter() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessUserHP();
        userHomePage.searchList();
    }

    @Test
    public void searchListTwitterFromDb() throws Exception {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessUserHP();
        userHomePage.searchListFromDB();
    }

    @Test
    public void toTweetAtSomething () throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessUserHP();
        userHomePage.tweetAtSomeone("@NYGovCuomo FIX THE SUBWAY!!");
    }

    @Test
    public void tweetAtUnrecognizedUser() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessUserHP();
        userHomePage.tweetAtSomeone("@abracadabrsdhbcvubabababa WHY WHY WHY!!");
    }


    @Test
    public void testingCharacterLimit() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessUserHP();
        userHomePage.tweetOverTheLimit();
        userHomePage.isTweetButtonEnabled();
    }

    @Test
    public void testMessage() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessUserHP();
        userHomePage.messaging();
        Thread.sleep(2000);

    }

    @Test
    public void getInfo() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessUserHP();
        userHomePage.getProfileInfo();
    }

    @Test
    public void getTrending() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessUserHP();
        userHomePage.whatsTrending();
    }

    @Test
    public void currentNews(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessUserHP();
        userHomePage.currentNews();
    }

    @Test
    public void checkNotifications() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessUserHP();
        userHomePage.viewNotifs();
    }

    @Test
    public void checkFollowers() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessUserHP();
        userHomePage.checkFollowers();
        Thread.sleep(3000);
    }

    @Test
    public void checkYourNews(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessUserHP();
        userHomePage.getYourNews();
    }

    @Test
    public void checkCurrentNews(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessUserHP();
        userHomePage.printFirstArticleToConsoleFromNews();
    }

    @Test
    public void checkSports(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessUserHP();
        userHomePage.getSports();
    }

    @Test
    public void accountCheckUp() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessAccPage();
        accountPage.accountSecurity();
    }

    @Test
    public void switchName() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessAccPage();
        accountPage.changeName();
    }

    @Test
    public void changePreferences() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessAccPage();
        accountPage.contentPreferences();
    }

    @Test
    public void checkUpPhone(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        logInTwitter();
        accessAccPage();
        accountPage.addRemovePhone();
    }

}
