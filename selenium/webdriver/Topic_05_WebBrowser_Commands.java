package webdriver;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.time.Duration;

public class Topic_05_WebBrowser_Commands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        //Tương tác với browser thông qua biến driver
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Browser() {
        //Mở ra 1 URL bất kì
        driver.get("https://live.techpanda.org/");
    }

    @Test
    public void TC_02() {

    }

    @AfterClass
    public void beforeClase() throws MalformedURLException {
        //Đóng browser - tất cả tab/window
        driver.quit();

        //Đóng browser - chị tab/window hiện tại
        driver.close();

        //Tìm 1 element với 1 locator là tham số truyền vào
        driver.findElement(By.cssSelector(""));

        //Tìm nhiều elements với 1 locator là tham só truyền vào
        driver.findElements(By.cssSelector(""));

        //Lấy ra chuỗi URL hiện tại của trang web
        driver.getCurrentUrl();
        //-> lấy sủ dụng luôn
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.easyfun.gg/");
        //-> Lưu vào biến để sử dụng sau
        String homePageURL = driver.getCurrentUrl();
        driver.get(homePageURL);

        //Lấy ra tiêu đề của trang hiện tại
        driver.getTitle();

        //Lấy ra Window ID của trang hiện tại
        driver.getWindowHandle();

        //Lấy ra tất cả Window ID của tab/window
        driver.getWindowHandles();

        //Lấy ra source code của trang hiện tại
        driver.getPageSource();

        //Switch to: Alert - frame/iframe - window/tab
        //Alert
        driver.switchTo().alert();
        //Switch vào frame bên trong
        driver.switchTo().frame("");
        //Switch từ frame con về trang cha
        driver.switchTo().defaultContent();
        //Switch từ frame con ra frame cha (trang có nhiều frames lồng nhau)
        driver.switchTo().parentFrame();
        //Switch tab, window
        driver.switchTo().window("");
        //New window -> selenium 4 mới có
        //Mở window mới -> đi tới url đã cung cấp
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://live.techpanda.org/");
        //Mở window mới -> mở tab mới -> đi tới url đã cung cấp
        driver.switchTo().newWindow(WindowType.TAB).get("https://live.techpanda.org/");

        //Set timeout để tìm element (áp dụng cho findElement và findElements)
        //Không tìm thấy sẽ chờ hết chừng đấy thời gian rồi hiện lỗi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(700));
        driver.manage().timeouts().implicitlyWait(Duration.ofNanos(90000));

        //Set timeout để chờ page load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        //Set timeout để chờ các tệp script JS thực thi thành công
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

        //Cookie
        driver.manage().getCookies();
        //driver.manage().addCookie();

        //Chỉnh kích thước browser: maximize / Minimize / fullscreen
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();

        //Set kích thước browser - px (responsive)
        driver.manage().window().setSize(new Dimension(1000, 500));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().getSize();
        //Set vị trí của browser sẽ bắt đầu ở vị trí toạ độ nào
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().getPosition();

        //Selenium log: Browser, Driver, Netwwork
        driver.manage().logs().get(LogType.BROWSER);
        driver.manage().logs().get(LogType.DRIVER);
        driver.manage().logs().get(LogType.CLIENT);
        driver.manage().logs().get(LogType.SERVER);
        driver.manage().logs().get(LogType.PERFORMANCE);
        driver.manage().logs().getAvailableLogTypes();

        //Các thao tác trên trang
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        //Mở 1 URL mới
        driver.navigate().to("https://live.techpanda.org/");
        driver.navigate().to(new URL("https://live.techpanda.org/"));
    }
}
