package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends AbstractPage {
    private String nameCss = ".qc-firstname-row input";
    private String surnameCss = ".qc-lastname-row input";
    private String dayCss = ".days";
    private String monthCss = ".months";
    private String yearCss = ".qc-select-year";
    private String cityCss = "#your_town";
    private String manCss = "#man1";
    private String womanCss = "#man2";
    private String emailCss = "#loginField input";
    private String passwordCss = ".qc-pass-row input";
    private String passverifyCss = ".qc-passverify-row input";
    private String btnSubmitCss = ".js-submit";
    private String topicCaptchaCss = ".is-signup-captcha_in div > .popup__head";

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    private By checkBoxFilter(String text) {
        return By.xpath("//*[text()='" + text + "']");
    }

    public String getTopicCaptcha(){
        return driver.findElement(By.cssSelector(topicCaptchaCss)).getText();
    };
    public RegistrationPage fillRegistrationForm(String name, String surname, String day, String month, String year, String city, String sex, String email, String password) throws InterruptedException {
        driver.findElement(By.cssSelector(nameCss)).sendKeys(name);
        driver.findElement(By.cssSelector(surnameCss)).sendKeys(surname);
        driver.findElement(By.cssSelector(dayCss)).click();
        driver.findElement(By.cssSelector(yearCss)).click();
        driver.findElement(checkBoxFilter(year)).click();
        driver.findElement(checkBoxFilter(month)).click();
        driver.findElement(By.cssSelector(yearCss)).click();
        driver.findElement(checkBoxFilter(day)).click();
        driver.findElement(By.cssSelector(monthCss)).click();
        driver.findElement(checkBoxFilter(year)).click();
        driver.findElement(By.cssSelector(cityCss)).click();
        driver.findElement(checkBoxFilter(city)).click();
        switch (sex) {
            case "man":
                driver.findElement(By.cssSelector(manCss)).click();
                break;
            case "woman":
                driver.findElement(By.cssSelector(womanCss)).click();
                break;
        };

        driver.findElement(By.cssSelector(emailCss)).sendKeys(email);
        driver.findElement(By.cssSelector(passwordCss)).sendKeys(password);
        driver.findElement(By.cssSelector(passverifyCss)).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(btnSubmitCss)).click();
        Thread.sleep(3000);
        return this;
    }
}
