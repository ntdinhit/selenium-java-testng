package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Topic_01_DataType {
    //Primitive Data Types
    byte bMin = -128, bMax = 127;
    short sMin = -32768, sMax = 32767;
    int iMin = -2147483648, iMax = 2147483647;
    long lMin = -9223372036854775808L, lMax = 9223372036854775807L;
    float fNum1 = -0.00000000000001F, fNum2 = 999.999999999F;
    double dNum1 = 0.00000000000000000000000000000000000000000000001d, dNum2 = 99.99999999999999999999999999999999999999d;
    boolean bVal1 = true, bVal2 = false;
    char cVal1 = 'A', cVal2 = 'a', cVal3 = '1', cVal4 = '$';
    //Ref: https://www.lookuptables.com/text/ascii-table

    //Non-Primitive Data Types

    //String
    String sVal1 = "Hello world!", sVal2 = "0123456789";

    //Array
    String[] StrArray = {"Volvo", "BMW", "Ford", "Mazda"};
    int[] intArray = {10, 20, 30, 40};

    //Class
    FirefoxDriver ffdriver = new FirefoxDriver();

    //Interface
    WebDriver driver = new ChromeDriver();

    //Collection
    List<WebDriver> textboxes = driver.findElement(By.cssSelector(""));
    ArrayList<String> studentCity = new ArrayList<String>();

    //Enum
    enum Level {
        LOW,
        MEDIUM,
        HIGH
    }
    Level myVar = Level.MEDIUM;
}
