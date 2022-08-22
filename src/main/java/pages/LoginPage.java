package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.TestBase;

//import static testbase.TestBase.getDrive;
//import static testbase.TestBase.getPropertyValue;


public class LoginPage extends TestBase{

    //Page Factory - Object Repo
    @FindBy(name = "username")
    private WebElement username;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(css = "input[value = 'Login']")
    private WebElement logInButton;
    @FindBy(xpath = "//img[contains(@class, 'img-responsive')")
    private WebElement crmLogo;

    //Initialize page objects
    public LoginPage() {
        PageFactory.initElements(TestBase.getDrive(), this);
        //return PageFactory.initElements(TestBase.getDrive(), HomePage.class);
    }

    //Actions
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }
    public boolean validateCRMImage() {
        return crmLogo.isDisplayed();
    }
    public HomePage logIn(String name, String pass) {
        username.sendKeys(name);
        password.sendKeys(pass);
        logInButton.click();

        return PageFactory.initElements(TestBase.getDrive(), HomePage.class);

    }
}
