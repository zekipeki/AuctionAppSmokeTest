package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Bid {

    WebDriver driver;
    By homePage = By.cssSelector("#root > div > div > section > div:nth-child(3) > section > a:nth-child(1)");
    By bidNow = By.cssSelector("#root > div > div.landing-page > div.row.landing-page-xl > div:nth-child(2) > div > div > button");

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
            System.out.print(e.getMessage());
        }
    }


    public void doBid(){
        this.goToHomePage();
        this.clickBidNow();
    }
}
