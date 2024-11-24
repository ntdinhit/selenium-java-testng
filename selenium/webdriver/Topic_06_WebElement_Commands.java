package webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_06_WebElement_Commands {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Element() {
        ///***Note***
        //Tương tác trực tiếp lên element 1 vài lần
        driver.findElement(By.cssSelector(""));

        //Thao tác nhiều lần lên 1 element -> thì nên khai báo bến
        WebElement firstNameTextbox =  driver.findElement(By.cssSelector("input#firstname"));
        firstNameTextbox.clear();
        firstNameTextbox.sendKeys("test send key");
        firstNameTextbox.isDisplayed();

        ///***Demo bài***

        WebElement element =  driver.findElement(By.cssSelector("input#firstname"));

        //Xoá dữ liệu ở 1 editable element (input)
        //Textbox - TextArea - Dropdown
        element.clear();

        //Nhập dũ liệu vào 1 editable element (input)
        element.sendKeys("Automation");

        //Cách 1 Element cha dùng 1 loại locator - Element con 1 loại locator khác
        element.findElement(By.cssSelector("div.form-fields"))
                .findElement(By.xpath("//input[@id='FirstName'"));

        //Cách 2 Cả cha và con đều dùng chung loại locator
        element.findElement(By.cssSelector("div.form-fields input#FirstName"));

        //Nhấn lên clickable element
        //Button - Checkbox - Radio - Link - Icon - Image - Dropdown
        element.click();

        //Tương đương với submit thông tin để gửi lên server (dùng nhiều cho form)
        //Giả lập nút enter của end-user
        //Register - Login - Form - Search
        element.submit();

        //Xác minh thông tin / dữ liệu đã action
        //Kiểm tra 1 element có hiện thị không? (Áp dụng cho tất cả các loại element)
        element.isDisplayed();

        //Kiểm tra 1 element đã được chọn hay chưa
        //Áp dụng: Checkbox - Radio - Dropdown
        element.isSelected();

        //Kiểm tra 1 element c cho phép thao lên hay không?
        //False: Read-only/ không được chỉnh sửa thông tin)
        //True: Được phép chỉnh sửa / thao tác
        //Thường ở test phân quyền
        element.isEnabled();

        //III - lấy dữ liệu

        //Lấy ra chiều rộng, chiều cao của element
        element.getSize();

        //Lấy ra text của 1 element
        element.getText();

        //Lấy ra value của Attribute
        element.getAttribute("placeholder");

        //Search store

        //Shadow DOM (có bài học riêng)
        element.getShadowRoot();

        //Sử dụng nhiều cho dev Front-end
        //F12 > tab Computed, ARIA attribute
        //Ít khi dùng
        element.getAriaRole();
        element.getDomAttribute("");
        element.getDomProperty("");
        element.getAccessibleName();

        //Font - Background - color - ...
        //Verify UI
        element.getCssValue("background-color");  //#DF280A
        element.getCssValue("font-size");   //13px
        element.getCssValue("font-family"); //arial

        //Lấy ra vị trí của element (góc trên bên trái) so với browser
        element.getLocation();

        //Lấy chiều dài/ chiều rộng của element
        element.getSize();

        //Lấy ra tên thẻ html của element
        //By id / class / name / css
        element.getTagName();

        //Take screen shot (Chụp hình lỗi)
        element.getScreenshotAs(OutputType.FILE);
        element.getScreenshotAs(OutputType.BYTES);
        element.getScreenshotAs(OutputType.BASE64);
        
    }

    @Test
    public void TC_02() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
