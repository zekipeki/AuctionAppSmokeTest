package pages;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login {
    WebDriver driver;
    // Login
    private By buttonLogin = By.className("nav-link");
    private By labelEmail = By.cssSelector("#root > div > div.reg-login > form > div:nth-child(2) > input");
    private By labelPassword =By.cssSelector("#root > div > div.reg-login > form > div:nth-child(3) > input");
    private By loginButton = By.cssSelector("#root > div > div.reg-login > form > button");


    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton(){
        try {
            driver.findElement(buttonLogin).click();
        } catch (NoSuchElementException e){
            System.out.print(e.getMessage());
            }
        }

    public void populateEmail(String EmailAddress){
        try {
            driver.findElement(labelEmail).sendKeys(EmailAddress);
        } catch (NoSuchElementException e){
            System.out.print(e.getMessage());
        }
    }

    public void populatePassword(String Password){
        try {
            driver.findElement(labelPassword).sendKeys(Password);
        }catch (NoSuchElementException e){
            System.out.print(e.getMessage());
        }
    }

    public void clickLogin(){
        try {
            driver.findElement(loginButton).click();
        }catch (NoSuchElementException e){
            System.out.print(e.getMessage());
        }
    }

    public void MyAccountPage(){
        try {
            String message = driver.findElement(By.cssSelector("#common-nav-brand")).getText();
            Assert.assertEquals(message, "LOGIN");
            System.out.print("User is Logged in and redirected to MY ACCOUNT page.\n \n");
        }catch (NoSuchElementException e){
            System.out.print(e.getMessage());
        }
    }


    public void LoginUser(String EmailAddress, String Password){
        this.clickLoginButton();
        this.populateEmail(EmailAddress);
        this.populatePassword(Password);
        this.clickLogin();
        this.MyAccountPage();
    }
}
