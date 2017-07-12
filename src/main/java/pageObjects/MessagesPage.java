package pageObjects;

import org.openqa.selenium.WebDriver;

public class MessagesPage extends AbstractPage {

    public MessagesPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
