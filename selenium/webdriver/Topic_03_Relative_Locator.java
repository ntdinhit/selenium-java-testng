package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_Relative_Locator {
    WebDriver driver;

    @BeforeClass
    public void initBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_00(){
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");
        //1. Khai báo biến
        //Khi dữ liệu được sử dụng nhiều lần -> khai báo dễ tái sử dụng

        String emailAddress = "dinhnt@yopmail.com";
        By emailTextboxBy = By.cssSelector("input#email_address");
        WebElement emailTextboxElement = driver.findElement(emailTextboxBy);

        emailTextboxElement.clear();
        emailTextboxElement.isDisplayed();
        emailTextboxElement.sendKeys(emailAddress);

        //2. Không cần khai báo biến
        //Khi dữ liệu chỉ dùng 1 lần, khai báo biến tốn bộ nhớ

        driver.findElement(emailTextboxBy).sendKeys(emailAddress);
    }

    @Test
    public void TC_01_Relative_Locator() {
        driver.get("http://live.techpanda.org/index.php/catalogsearch/advanced/");

        WebElement priceFromElement = driver.findElement(RelativeLocator.with(By.tagName("input"))
                .toLeftOf(By.name("price[to]"))
                .below(By.id("sku"))
                .above(By.id("tax_class_id")));
        priceFromElement.sendKeys("100");

        By customServiceBy = By.xpath("//a[contains[@href,\"custom-service/\")]");
    }

    @Test
    public void TC_02_Class() {
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");

        driver.findElement(By.className("header-language-background"));
        driver.findElement(By.className("page-title"));
    }


    @AfterClass
    public void clearBrowser() {
        driver.quit();
    }
}
