package testcases;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;

public class LoginPageTest extends TestBase {
   // WebDriver driver =TestBase.getDrive();
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @Test
    public void setUp() {
//        startLoginPage()
//                .logIn(TestBase.getPropertyValue("username"), TestBase.getPropertyValue("password"));
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority=1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support.");

    }
    @Test(priority=2)
    public void crmLogoTest() {
        boolean logoImage = loginPage.validateCRMImage();
        Assert.assertTrue(logoImage);
    }
    @Test(priority=3)
    public void loginTest() {
        //loginPage.logIn(properties.getProperty("username"), properties.getProperty("password")); orr
        homePage = loginPage.logIn(TestBase.getPropertyValue("username"), TestBase.getPropertyValue("password"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
