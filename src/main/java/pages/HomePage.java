package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testbase.TestBase;

public class HomePage extends TestBase {
    @FindBy(linkText = "Contacts") private WebElement openContacts;

    public void clickOpenContacts() {
        openContacts.click();
    }
}
