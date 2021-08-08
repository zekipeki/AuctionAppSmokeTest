package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Login;
import pages.Bid;

import java.util.concurrent.TimeUnit;

public class SmokeTest {

    WebDriver driver;
    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "res/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin(){

        Login objLogin =new Login(driver);
        objLogin.LoginUser("pllp@example.com", "123456");

        Bid objBid = new Bid(driver);
        objBid.doBid();



    }

   /* @AfterTest
    public void afterTest() {

        driver.quit();
    }*/
}
