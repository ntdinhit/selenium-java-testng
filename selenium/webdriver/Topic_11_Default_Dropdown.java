package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Topic_11_Default_Dropdown {
    WebDriver driver;
    Select select;
    @BeforeClass
    public void initBrowser() {
//      EdgeOptions edgeOptions = new EdgeOptions();
//      edgeOptions.addArguments("--user-data-dir=C:/Users/thanh/AppData/Local/Microsoft/Edge/User Data/");
//      edgeOptions.addArguments("--profile-directory=Profile 3");
//      driver = new EdgeDriver(edgeOptions);

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Egov_DaNang() throws InterruptedException {
        driver.get("https://egov.danang.gov.vn/reg/");
        select = new Select(driver.findElement(By.cssSelector("select#thuongtru_tinhthanh")));
        //Chạy fail khó track + update lại giá trị trong dropdown -> index thay đổi
        //select.selectByIndex(4);
        //Chạy fail khó track + Khó nhớ value + thuộc tính value không phải là bắt buộc
        //select.selectByValue("9806");
        //Chạy fail nhhìn text để manual lại được + tường minh + dễ nhìn dễ nhớ
        select.selectByVisibleText("tỉnh Bình Thuận");
        Thread.sleep(4000);
        //Lấy ra được item vừa chọn và verify
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "tỉnh Bình Thuận");
        //Kiểm tra 1 dropdown là single hay multiple
        Assert.assertFalse(select.isMultiple());
        //Lấy ra tất cả các item bên trong dropdown Quận Huyện
//        select = new Select(driver.findElement(By.cssSelector("select#thuongtru_quanhuyen")));
//        List<WebElement> districtElements = select.getOptions();
//        List<String> districtText = new ArrayList<String>();
//
//        for(WebElement district : districtElements){
//            districtText.add(district.getText());
//        }
//
//        Assert.assertTrue(districtText.contains("thành phố Phan Thiết"));
//        Assert.assertTrue(districtText.contains("thị xã La Gi"));
//        Assert.assertTrue(districtText.contains("huyện Bắc Bình"));
    }

    @Test
    public void TC_02_Demo_Ecommerce() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/register");
        String firstName = "Zeref";
        String lastName = "Dragoneel";
        String email = "Zeref" + new Random().nextInt(9999)+"@yopmail.com";
        String company = "Automation Academy";
        String password = "P@ssword123";
        String day = "8";
        String month = "May";
        String year = "1999";
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).selectByVisibleText(day);
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).selectByVisibleText(month);
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).selectByVisibleText(year);
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Company")).sendKeys(company);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");
        driver.findElement(By.cssSelector("a.ico-account")).click();
        //Verify lại thông tin đã nhập ở trên
        Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), email);
        Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"), company);
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).getFirstSelectedOption().getText(), day);
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).getFirstSelectedOption().getText(), month);
        Assert.assertEquals(new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).getFirstSelectedOption().getText(), year);
        Thread.sleep(4000);
    }

    @Test
    public void TC_03_Rode() throws InterruptedException {
        String country = "Vietnam";
        String city = "HO CHI MINH";

        driver.get("https://rode.com/en/support/where-to-buy");
        Thread.sleep(10000);

        Assert.assertFalse(new Select(driver.findElement(By.cssSelector("select#country"))).isMultiple());

        new Select(driver.findElement(By.cssSelector("select#country"))).selectByVisibleText(country);
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input#map_search_query")).sendKeys(city);
        driver.findElement(By.xpath("//button[text()='Search']")).click();
        Thread.sleep(10000);

        List<WebElement> dealersBranches = driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div//h4"));
        Assert.assertEquals(dealersBranches.size(), 16);

        for(WebElement dealersName : dealersBranches){
            System.out.println(dealersName.getText());
        }
    }

    @AfterClass
    public void clearBrowser() {
        driver.quit();
    }
}