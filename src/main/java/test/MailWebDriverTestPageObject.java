package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.MessagesPage;
import pageObjects.RegistrationPage;

import java.util.concurrent.TimeUnit;

public class MailWebDriverTestPageObject {
    WebDriver driver;
    private String homeUrl = "https://mail.ru";
    private String titlePage = "Регистрация - Почта Mail.Ru";
    private String name = "Ivan";
    private String surname = "Petrov";
    private String day = "5";
    private String month = "Июнь";
    private String year = "2005";
    private String city = "Москва, Россия";
    private String sex = "man";
    private String email = "auto-test-new";
    private String password = "auto-test-new1234567";
    private String topicCaptcha = "Введите код на картинке";
    private String login = "testUser";
    private String titleMessagesPage = "(1411) Входящие - Почта Mail.Ru";

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get(homeUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkTitle() {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage.navigateToRegistrationPage();
        Assert.assertTrue(registrationPage.getTitle().equals(titlePage));
    }

    @Test
    public void getRegistrationFormByKeyword() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = homePage
                .navigateToRegistrationPage()
                .fillRegistrationForm(name, surname, day, month, year, city, sex, email, password);
        Assert.assertTrue(registrationPage.getTopicCaptcha().equals(topicCaptcha));

    }

    @Test
    public void getNonexistentLoginAndPasswordByKeyword() {
        HomePage homePage = new HomePage(driver);
        MessagesPage messagesPage = homePage.fillLoginForm(login, password);
        Assert.assertFalse(messagesPage.getTitle().equals(titleMessagesPage));
    }
}
