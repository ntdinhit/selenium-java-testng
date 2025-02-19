package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_WebBrowser_Excercise {
    WebDriver driver;

    @BeforeClass
    public void initBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Verify_URL() {
        driver.get("https://live.techpanda.org/");

        //Click vào My Account ở footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        //Bắt đầu ở đâu, kết thúc ở đó
        //Không thừa/thiếu các kí tự (...), "...", '...'
        //Hàm được gọi ra đúng vị trí

        //Cách 1: Đặt biến nếu sử dụng lại biến nhiều lần
        String loginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginPageUrl, "https://live.techpanda.org/index.php/customer/account/login/");

        //Cách 2: Gôm chung, sử dụng 1 lần
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/login/");

        //Click để chuyển qua trang register
        driver.findElement(By.cssSelector("a[class='button']")).click();

        //Verify
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/create/");

    }

    @Test
    public void TC_02_Verify_Title() {
        //Step 1: truy cập
        driver.get("https://live.techpanda.org/");

        //Step 2: Click vào My Account ở footer
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        //Step 3: Verify title
        Assert.assertEquals(driver.getTitle(), "Customer Login");

        //Step 4: Click để chuyển qua trang register
        driver.findElement(By.cssSelector("a[class='button']")).click();

        //Step 5: Verify title
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
    }

    @Test
    public void TC_03_Navigate_Function(){
        //Step 1
        driver.get("https://live.techpanda.org/");
        //Step 2
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        //Step 3
        driver.findElement(By.cssSelector("a[class='button']")).click();
        //Step 4
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/create/");
        //Step 5
        driver.navigate().back();
        //Step 6
        Assert.assertEquals(driver.getCurrentUrl(),"https://live.techpanda.org/index.php/customer/account/login/");
        //Step 7
        driver.navigate().forward();
        //Step 8
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
    }

    @Test
    public void TC_04_Get_Page_Source_Code(){
        //Step 1
        driver.get("https://live.techpanda.org/");
        //Step 2
        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
        //Step 3
        Assert.assertEquals(driver.getPageSource().contains("Login or Create an Account"),Boolean.TRUE); //Cách 1
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account")); //Cách 2
        //Step 4
        driver.findElement(By.cssSelector("a[class='button']")).click();
        //Step 5
        Assert.assertEquals(driver.getPageSource().contains("Create an Account"),Boolean.TRUE);
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
    }

    @AfterClass
    public void clearBrowser() {
        driver.quit();
    }
}
