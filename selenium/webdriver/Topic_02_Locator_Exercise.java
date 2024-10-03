package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_02_Locator_Exercise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public void TC_01_Search_Bar() {
        //ID
        driver.findElement(By.id("txtSearch"));

        //Class
        driver.findElement(By.className("inputsearch2"));

        //Name
        driver.findElement(By.name("txtSearch"));

        //Tag Name
        driver.findElements(By.tagName("input"));

        //CSS
        driver.findElement(By.cssSelector("#txtSearch"));
        driver.findElement(By.cssSelector("input#txtSearch"));
        driver.findElement(By.cssSelector("input[id='txtSearch']"));
        driver.findElement(By.cssSelector("input[placeholder='Tìm khóa học']"));

        //Xpath
        driver.findElement(By.xpath("//input[@id='txtSearch']"));
        driver.findElement(By.xpath("//div[@class='box-search'] //input"));
    }

    @Test
    public void TC_02_Text_Link_Dang_Ky() {
        //Css
        driver.findElement(By.cssSelector("span:first-child .btn-anis-effect"));
        driver.findElement(By.cssSelector("a[href='https://alada.vn/tai-khoan/dang-ky.html']"));

        //Link
        driver.findElement(By.linkText("Đăng Ký"));

        //Partial Link
        driver.findElement(By.partialLinkText("Ký"));

        //Xpath
        driver.findElement(By.xpath("//a[@href='https://alada.vn/tai-khoan/dang-ky.html']"));

    }

    @Test
    public void TC_03_Text_Link_Dang_Nhap() {
        //Css
        driver.findElement(By.cssSelector(".box-item-login.bor"));
        driver.findElement(By.cssSelector("a[href='https://alada.vn/tai-khoan/dang-nhap.html']"));

        //Link
        driver.findElement(By.linkText("Đăng Nhập"));

        //Partial Link
        driver.findElement(By.partialLinkText("Nhập"));

        //Xpath
        driver.findElement(By.xpath("//a[@href='https://alada.vn/tai-khoan/dang-nhap.html']"));
    }

    @Test
    public void TC_04_Form_Inputs() {
        //ID
        driver.findElement(By.id("txtFirstname"));
        driver.findElements(By.id("btndknfooter"));

        //Class
        driver.findElements(By.className("form-control"));
        driver.findElement(By.className("marleft0"));

        //Name
        driver.findElement(By.name("txtCEmail"));
        driver.findElement(By.name("chkRight"));

        //Tag name
        driver.findElements(By.tagName("input"));

        //Css
        driver.findElement(By.cssSelector("input[type='number'"));
        driver.findElement(By.cssSelector("button[style='width:120px']"));
        driver.findElement(By.cssSelector("input[checked='checked']"));


        //Xpath
        driver.findElement(By.xpath("//input[@type='number']"));
        driver.findElement(By.xpath("//button[contains(text(),'NGAY')]"));

    }

    @AfterClass
    public void beforeClase() {
        driver.quit();
    }
}
