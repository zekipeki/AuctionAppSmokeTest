package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class Bid {

    WebDriver driver;
    private By homePage = By.cssSelector("#root > div > div > section > div:nth-child(3) > section > a:nth-child(1)");
    private By bidNow = By.cssSelector("#root > div > div.landing-page > div.row.landing-page-xl > div:nth-child(2) > div > div > button");
    private By bidValueLabel = By.cssSelector("#root > div > div.shop-page > div.item-container > div.item-info > div.bid-container > input[type=text]");
    private By bidValue = By.cssSelector("#root > div > div.shop-page > div.item-container > div.item-info > h5:nth-child(2)");
    private By placeBid = By.cssSelector("#root > div > div.shop-page > div.item-container > div.item-info > div.bid-container > button");
    private By message1 =By.cssSelector("#highest-bid > span");
    private By message2 = By.cssSelector("#low-bid > span");
    private By noOfBids = By.cssSelector("#root > div > div.shop-page > div.item-container > div.item-info > h6:nth-child(6)");
    private By highestPrice = By.cssSelector("#root > div > div.shop-page > div.item-container > div.item-info > h6:nth-child(5)");
    private By timeLeft = By.cssSelector("#root > div > div.shop-page > div.item-container > div.item-info > h6:nth-child(7)");

    public Bid(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHomePage(){
        try {
            driver.findElement(homePage).click();
        }catch (NoSuchElementException e){
            System.out.print(e.getMessage());
        }
    }

    public void clickBidNow(){
        try {
            driver.findElement(bidNow).click();
        }catch (NoSuchElementException e){

        }
    }
    public void getBidValue(String myBid) {

            String text = driver.findElement(bidValue).getText();
            String currentBid = text.replaceAll("[^0-9]", "");
            System.out.println("Start from -$"+currentBid);
            populateBidValue(currentBid, myBid);
    }

    public void populateBidValue(String currentBid, String myBid){
        try {
            int mybid =Integer.parseInt(myBid);
            int currentbid=Integer.parseInt(currentBid);
            if(mybid > currentbid) {
                driver.findElement(bidValueLabel).sendKeys(myBid);
                succcessfullBidMessage();
            }
            else{
                unsucccessfullBidMessage();
            }
        }catch (NoSuchElementException e){
            System.out.print(e.getMessage());
            }
        }


    public void clickPlaceBid(){
        try {
            driver.findElement(placeBid).click();
        }catch (NoSuchElementException e){
            System.out.print(e.getMessage());
        }
    }

    public void succcessfullBidMessage() {
        try {
            String Message_1 = driver.findElement(message1).getText();
            Assert.assertEquals(Message_1, "Congrats! You are the highest bidder!");
            System.out.print(Message_1);

            //samo printam
            System.out.print("\n" + driver.findElement(highestPrice).getText());
            System.out.print("\n" + driver.findElement(noOfBids).getText());
            System.out.print("\n" + driver.findElement(timeLeft).getText());

        } catch (NoSuchElementException e) {
            System.out.print(e.getMessage());
        }
    }

    public void unsucccessfullBidMessage(){
        try {
            String Message_2 = driver.findElement(message2).getText();
            Assert.assertEquals(Message_2, "There are higher bids than yours! Give it another try!");
            System.out.print(Message_2);
        }catch (NoSuchElementException e) {
            System.out.print(e.getMessage());
        }
    }



    public void doBid(String myBid){
        this.goToHomePage();
        this.clickBidNow();
        this.getBidValue(myBid);
        this.clickPlaceBid();
    }
}
