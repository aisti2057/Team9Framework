package pageObjects;

import common.CommonAPI;
import menu.DataSource;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;
import java.util.List;

public class UserHomePage extends CommonAPI {

    //To Tweet elements
    @FindBy(css = "div[aria-label='Tweet text']")
    WebElement tweetTextBox;

    @FindBy(xpath = "//div[@class='css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-1qd0xha r-a023e6 r-vw2c0b r-1777fci r-eljoum r-dnmrzs r-bcqeeo r-q4m81j r-qvutc0']")
    WebElement tweetTextButton;

    @FindBy(xpath = "//div[@class='css-18t94o4 css-1dbjc4n r-urgr8i r-42olwf r-sdzlij r-1phboty r-rs99b7 r-1w2pmg r-1n0xq6e r-1vuscfd r-1dhvaqw r-1fneopy r-o7ynqc r-6416eg r-lrvibr']")
    WebElement pushTweet;

    //To explore element
    @FindBy(linkText = "Explore")
    WebElement explore;

    //To Search element
    @FindBy(xpath = "//input[@aria-label='Search query']")
    WebElement searchBarTextBox;

    @FindBy(xpath = "//div[@data-testid='809273-follow']")
    WebElement followProfileButton;

    @FindBy(linkText = "Notifications")
    WebElement notificationsButton;

    @FindBy(xpath = "//div[@class='css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-1qd0xha r-n6v787 r-vw2c0b r-1777fci r-eljoum r-dnmrzs r-bcqeeo r-q4m81j r-qvutc0']")
    WebElement clear;

    @FindBy(linkText = "Messages")
    WebElement messageTabButton;

    @FindBy(linkText = "New message")
    WebElement newMessageButton;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-eqz5dr r-dnmrzs']")
    WebElement firstOptionAfterSearchingMSG;

    @FindBy(xpath = "//div[@data-testid='nextButton']")
    WebElement nextButtonMSG;

    @FindBy(xpath = "//div[@class='notranslate public-DraftEditor-content']")
    WebElement inputStartMessage;

    @FindBy(linkText = "Profile")
    WebElement profileButton;

    @FindBy(linkText = "Edit profile")
    WebElement ediProfileButton;

    @FindBy(xpath = "//*[text()[contains(., '#FilthyPieceToeRag')]]")
    WebElement trendingOne;

    @FindBy(xpath = "//*[text()[contains(., 'Nothing to see here — yet')]]")
    WebElement notificationsText;

    @FindBy(xpath = "//a[@class='css-4rbku5 css-18t94o4 css-901oao r-jwli3a r-1loqt21 r-1qd0xha r-a023e6 r-16dba41 r-ad9z0x r-bcqeeo r-qvutc0']")
    WebElement numOfFollowing;

    @FindBy(linkText = "For you")
    WebElement yourNews;

    @FindBy(linkText = "News")
    WebElement currentNewsButton;

    @FindBy(partialLinkText = "Hong Kong")
    WebElement firstNewsLink;

    @FindBy(xpath = "//*[text()[contains(., 'Chief Executive Carrie')]]")
    WebElement snippetFirstArticle;

    @FindBy(linkText = "Sports")
    WebElement sportsSection;

    public WebElement getPushTweet(){
        return this.pushTweet;
    }
    public WebElement getSearchBarTextBox(){
        return this.searchBarTextBox;
    }

    public WebElement getClear() {
       return this.clear;
    }

    public void clickTextBoxToClear(){
        getClear().click();
    }

    public void searchFor(String searchText) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        getSearchBarTextBox().sendKeys(searchText);
        getSearchBarTextBox().sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        getSearchBarTextBox().click();
    }

    public void searchList() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        explore.click();
        List<String> list = DataSource.getSearchList();
        for(int i=0; i<list.size(); i++) {
            searchFor(list.get(i));
            clickTextBoxToClear();
        }
    }

    public void searchListFromDB()throws Exception {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        List<String> list = DataSource.retrieveListFromDb();
        for(int i=0; i<list.size(); i++) {
            searchFor(list.get(i));
            clickTextBoxToClear();
        }
    }

    public void tweetATweet(String tweetText) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        tweetTextBox.sendKeys(tweetText);
        System.out.println(tweetTextButton.isEnabled());
        Thread.sleep(2000);
        pushTweet.click();
    }

    public void tweetAtSomeone(String atSymbolTwitterNameAndMessage) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        tweetTextBox.sendKeys(atSymbolTwitterNameAndMessage);
        System.out.println(tweetTextButton.isEnabled());
        Thread.sleep(2000);
        pushTweet.click();
    }

    public void searchTwitter(String textForSearching) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        explore.click();
        searchBarTextBox.sendKeys(textForSearching);
        searchBarTextBox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    public void searchTwitterAndFollow(String textForSearching) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        explore.click();
        searchBarTextBox.sendKeys(textForSearching);
        searchBarTextBox.sendKeys(Keys.ENTER);
        followProfileButton.click();
        Thread.sleep(2000);

    }

    public void tweetOverTheLimit() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        String tweetOverTheLimitText = "AaknjkadnjkenjkebnfsdAaknjkadnjkenjkebnfsdAaknjkadnjkenjkebnfsdAaknjkadnjkenjkebnfsdAaknjkadnjkenjkebnfsdAaknjkadnjkenjkebnfsdAaknjkadnjkenjkebnfsdAaknjkadnjkenjkebnfsdAaknjkadnjkenjkebnfsdAaknjkadnjkenjkebnfsd cvsd vkd cvdjcvnkdsm djjjjjjjjdscnldscmsd,c dmjjjjjmzdn cmndksmc dn cd ccnmd cmnsdcksanxkjdaaaaaaaaaaajjdscnldscmsd,c dmvhiufsdhjbfksebfjknjaaaaaaaaaaajjdscnldscmsd,c dmvhiufsdhjbfksebfjknj";
        tweetTextBox.sendKeys(tweetOverTheLimitText);
    }

    public void isTweetButtonEnabled(){
        System.out.println(getPushTweet().isEnabled());
    }

    public void messaging() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        messageTabButton.click();
        newMessageButton.click();
        searchBarTextBox.sendKeys("@MikeHaw39154018");
        System.out.println(firstOptionAfterSearchingMSG.isDisplayed());
        Thread.sleep(2000);
        firstOptionAfterSearchingMSG.click();
        nextButtonMSG.click();
        inputStartMessage.click();
        inputStartMessage.sendKeys("Hey there Partna', HowdyDoin'?", Keys.ENTER);
    }

    public void getProfileInfo() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        profileButton.click();
        ediProfileButton.click();
    }

    public void whatsTrending() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        trendingOne.click();
    }

    public void currentNews(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        explore.click();
    }

    public void viewNotifs(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        notificationsButton.click();
        System.out.println(notificationsText.getText());

    }

    public void checkFollowers() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        profileButton.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(numOfFollowing).click().build().perform();
    }

    public void getYourNews(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        explore.click();
        yourNews.click();
    }

    public void printFirstArticleToConsoleFromNews(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        explore.click();
        currentNewsButton.click();
        System.out.println(firstNewsLink.getText());
        firstNewsLink.click();
        System.out.println(snippetFirstArticle.getText());
    }

    public void getSports(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {}.getClass().getEnclosingMethod().getName()));
        currentNews();
        sportsSection.click();
    }

}
