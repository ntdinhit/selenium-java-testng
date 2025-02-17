package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Struct;
import java.time.Duration;
import java.util.Random;

public class Topic_10_Textbox_TextArea {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_TechPanda() {
        driver.get("http://live.techpanda.org/index.php/");

        driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

        String firstName = "Dinh";
        String lastName = "Seven";
        String fullName = firstName + " " + lastName;
        String emailAddress = "dinhnt" + new Random().nextInt(9999) + "@yopmail.com";
        String password = "Abc@123";
        String thoughtReview = "Best phone\nGood Product\nNice Look";
        String summaryReview = "Excellent";
        String nickName = "Seven";

        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("email_address")).sendKeys(emailAddress);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmation")).sendKeys(password);

        driver.findElement(By.cssSelector("button[title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li>span")).getText(),
                "Thank you for registering with Main Website Store.");

        String contactInformation = driver.findElement(By.xpath(
                "//h3[text()='Contact Information']/parent::div/following-sibling::div")).getText();

        Assert.assertTrue(contactInformation.contains(fullName));
        Assert.assertTrue(contactInformation.contains(emailAddress));

        //Chuyển tab Mobile
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();

        driver.findElement(By.cssSelector("input[id='Quality 1_5']")).click();
        driver.findElement(By.id("review_field")).sendKeys(thoughtReview);
        driver.findElement(By.id("summary_field")).sendKeys(summaryReview);
        driver.findElement(By.id("nickname_field")).clear();
        driver.findElement(By.id("nickname_field")).sendKeys(nickName);

        driver.findElement(By.cssSelector("button[title='Submit Review']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),
                "Your review has been accepted for moderation.");
    }

    @Test
    public void TC_02_OrangeHRM() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String firstName = "Zeref";
        String lastName = "Ragna";
        String username = "donald" + new Random().nextInt(9999);
        String password = "@bcD0123";
        String passpostNumber = "555-6646-7747-3535";
        String passpostComment = "Automation\nHello";

        //Step 1: Login
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Thread.sleep(4000);

        //Step 2
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[text()='Add Employee']")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(lastName);

        String employeeID = driver.findElement(
                By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input"))
                .getAttribute("value");

        driver.findElement(By.xpath("//p[text()='Create Login Details']/following-sibling::div/label")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//p[text()='Username']/parent::div/following-sibling::div/input")).sendKeys(username);
        driver.findElement(By.xpath("//p[text()='Password']/parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//p[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys(password);

        driver.findElement(By.xpath("//button[contains[string(),'Save']")).click();
        Thread.sleep(8000);

        //Verify ---
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstname']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastname']")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Create Login Details']/following-sibling::div/input']"))
                .getAttribute("value"), employeeID);

        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//h6[text()=Assigned Immigration Records']/following-sibling::button[contains(string(),'Add')]")).click();

        driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(passpostNumber);
        driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).sendKeys(passpostComment);

        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("//label[text()='Number']/parent::div/following-sibling::div/input]")).getAttribute("value"), passpostNumber);
        Assert.assertEquals(driver.findElement(By.cssSelector("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"), passpostComment);

        //logout
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        Thread.sleep(2000);

        //login
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[text()='My Info']")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstname']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastname']")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Create Login Details']/following-sibling::div/input']"))
                .getAttribute("value"), employeeID);
        Assert.assertFalse(driver.findElement(By.xpath("//p[text()='Create Login Details']/following-sibling::div/input']")).isEnabled());

        //
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("//label[text()='Number']/parent::div/following-sibling::div/input]")).getAttribute("value"), passpostNumber);
        Assert.assertEquals(driver.findElement(By.cssSelector("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"), passpostComment);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
