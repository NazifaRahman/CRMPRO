package testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver; //public: to use in on other classes
    //public static Properties properties;

    public static String getPropertyValue(String propertyName) {
    //public testbase.TestBase() { //constructor
        String propertyValue="";

        try {

            InputStream inputStream = new FileInputStream("src/main/resources/info.properties"); //to know where to read this file
            Properties properties = new Properties();
            properties = new Properties();
            properties.load(inputStream);
            propertyValue = properties.getProperty(propertyName);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return propertyValue;
    }


    public static void initialization() {
        String BrowserName = getPropertyValue("browser");

        if(BrowserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (BrowserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(getPropertyValue("implicitWait"))));
        driver.get(getPropertyValue("url"));
    }

    public static WebDriver getDrive() {
        return driver;
    }

    public LoginPage startLoginPage() {
        return PageFactory.initElements(driver, LoginPage.class);
    }


}


