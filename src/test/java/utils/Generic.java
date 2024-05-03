package utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Locale;
import java.util.Properties;

public class Generic
{


    public static String firstName() {
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.name().firstName();
    }

    public static String lastName() {
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.name().lastName();
    }

    public static String fullName() {
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.name().fullName();
    }

    public static String email() {
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.name().lastName() + "@testmail.com";
    }


    public static String mobile() {
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.number().digits(10);
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static String getValue(String key){
        String path = System.getProperty("user.dir")+ File.separator+"config.properties";
        String value =  null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(fis);
            value = prop.getProperty(key);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void dropByText (WebElement element, String VisibleText)
    {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(VisibleText);

    }

    public static void dropByValue (WebElement element, String Value)
    {
        Select dropdown = new Select(element);
        dropdown.selectByValue(Value);
    }

    public static void dropByIndex (WebElement element, int Index)
    {

        Select dropdown = new Select(element);
        dropdown.selectByIndex(Index);

    }

    public static  void waitforElementToLoad(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void takeScreenshot(WebDriver driver){
        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        Files.copy(f, new File("./screenshots.png").toPath());
    }



    public static void mouserHover(WebDriver driver, WebElement element){
        Actions act = new Actions(driver);
        act.moveToElement(element).build().perform();
    }

    public static void contextClick(WebDriver driver, WebElement element){
        Actions act = new Actions(driver);
        act.contextClick(element).build().perform();
    }

    public static void dragandDrop(WebDriver driver, WebElement src, WebElement dst){
        Actions act = new Actions(driver);
        act.dragAndDrop(src,dst).build().perform();
    }

    public static void click(WebDriver driver, WebElement element){
        Actions act = new Actions(driver);
        act.click(element).build().perform();
    }


    public static String randomDate() {
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.date().birthday(1,40).toString();
    }

    public static void verifyTitle(WebElement element, String title){
        String actual = element.getText();
        Assert.assertEquals(actual, title,"Title Not Match");
    }

    public static void  verifyElementEnable(WebElement element){
        Assert.assertTrue(element.isEnabled(),"Button is Not Enabled");
    }

    public static void  verifyElementDisble(WebElement element){
        Assert.assertFalse(element.isEnabled(),"Button is Enabled");
    }


    public static void verifyPageTitle(WebDriver pgtitle, String title){
        String actual = pgtitle.getTitle();
        Assert.assertEquals(actual, title,"Title Not Match");
    }
}
