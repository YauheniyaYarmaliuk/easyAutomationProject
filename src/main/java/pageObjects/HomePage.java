package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
    private String loginCss = "#mailbox__login";
    private String passwordCss = "#mailbox__password";
    private String btnEnterCss = "#mailbox__auth__button";
    private String linkRegistrationCss = ".mailbox__register__link";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage navigateToRegistrationPage() {
        driver.findElement(By.cssSelector(linkRegistrationCss)).click();
        return new RegistrationPage(driver);
    };

    public MessagesPage fillLoginForm(String login, String password) {
        driver.findElement(By.cssSelector(loginCss)).sendKeys(login);
        driver.findElement(By.cssSelector(passwordCss)).sendKeys(password);
        driver.findElement(By.cssSelector(btnEnterCss)).click();
        return new MessagesPage(driver);
    }


}

