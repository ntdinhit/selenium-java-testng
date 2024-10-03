package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_02_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_ID() {
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");

        driver.findElement(By.id("search")).sendKeys("Samsumg");
        driver.findElement(By.id("firstname")).sendKeys("Soda");
    }

    @Test
    public void TC_02_Class() {
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");

        driver.findElement(By.className("header-language-background"));
        driver.findElement(By.className("page-title"));
    }

    @Test
    public void TC_03_Name() {
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");

        driver.findElement(By.name("q"));
        driver.findElement(By.name("firstname"));
        driver.findElement(By.name("lastname"));
        driver.findElement(By.name("email"));
    }

    @Test
    public void TC_04_Link() {
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");
        driver.findElement(By.linkText("ABOUT US"));
        driver.findElement(By.linkText("ORDERS AND RETURNS"));
        driver.findElement(By.linkText("CUSTOMER SERVICE"));
    }

    @Test
    public void TC_05_Partial_Link() {
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");
        driver.findElement(By.partialLinkText("ORDERS"));
        driver.findElement(By.partialLinkText("AND"));
        driver.findElement(By.partialLinkText("SERVICE"));
    }

    @Test
    public void TC_06_Tag_Name() {
        driver.get("http://live.techpanda.org/index.php/customer/account/create/");

        //Tìm nhiều dùng .findElements()
        //.size() để lấy số lượng
        int linkNumber = driver.findElements(By.tagName("a")).size();
        System.out.println("Số lượng link là: "+ linkNumber);

        int divNumber = driver.findElements(By.tagName("div")).size();
        System.out.println("Số lượng div là: "+ divNumber);

    }

    @Test
    public void TC_07_Css() {
        driver.get("https://automationfc.github.io/multiple-fields/");

        //Tìm nhiều dùng .findElements()
        //.size() để lấy số lượng
        int checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        System.out.println("Số lượng checkbox là: "+ checkboxes);

        /////

        driver.get("http://live.techpanda.org/index.php/customer/account/create/");

        //CSS vs ID
        driver.findElement(By.cssSelector("input[id='firstname']"));
        driver.findElement(By.cssSelector("#firstname"));
        driver.findElement(By.cssSelector("input#firstname"));

        driver.findElement(By.cssSelector("input[id='search']"));
        driver.findElement(By.cssSelector("#search"));
        driver.findElement(By.cssSelector("input#search"));

        //CSS vs Class
        ///Lấy 1 class duy nhất
        driver.findElement(By.cssSelector("div[class='header-language-background']"));
        driver.findElement(By.cssSelector(".header-language-background"));
        driver.findElement(By.cssSelector("div.header-language-background"));

        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector(".page-title"));
        driver.findElement(By.cssSelector("div.page-title"));

        ///Lấy nhiều class
        driver.findElement(By.cssSelector("input[class='input-text validate-email required-entry']"));
        driver.findElements(By.cssSelector(".input-text.validate-email.required-entry"));
        driver.findElements(By.cssSelector("input.input-text.validate-email.required-entry"));

        //CSS vs Name
        driver.findElement(By.cssSelector("input[name='q']"));
        driver.findElement(By.cssSelector("input[name='firstname']"));
        driver.findElement(By.cssSelector("input[name='lastname']"));
        driver.findElement(By.cssSelector("input[name='email']"));

        //CSS vs Link
        driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/about-magento-demo-store/']"));

        //CSS vs Partial Link
        driver.findElement(By.cssSelector("a[href^='http://live.techpanda.org/']"));    //Lấy đoạn đầu
        driver.findElement(By.cssSelector("a[href*='/index.php/']"));                   //Lấy bất kì
        driver.findElement(By.cssSelector("a[href$='/about-magento-demo-store/']"));    //Lấy đoạn cuối

        //CSS vs Tag Name (y như .tagname())
        int linkNumber = driver.findElements(By.cssSelector("a")).size();
        System.out.println("Số lượng link là: "+ linkNumber);

    }

    @Test
    public void TC_08_Xpath() {
        driver.get("https://demo.nopcommerce.com/register");

        // XPath vs ID
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        // XPath vs Class
        driver.findElement(By.xpath("//div[@class='page-title']"));

        // XPath vs Name
        driver.findElement(By.xpath("//input[@name='FirstName']"));

        // XPath vs TagName
        driver.findElement(By.xpath("//input"));

        // XPath vs Link
        driver.findElement(By.xpath("//a[@href='/customer/addresses']"));
        driver.findElement(By.xpath("//a[text()='Addresses']"));

        // XPath vs Partial Link

        driver.findElements(By.xpath("//a[starts-with(@href,'/customer')]"));
        driver.findElement(By.xpath("//a[contains(@href,'addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));

        // Xpath không support với ends-with (Css có)
        //driver.findElements(By.xpath("//a[ends-with(@href,'/customer')]"));
    }

    @AfterClass
    public void beforeClase() {
        driver.quit();
    }
}
