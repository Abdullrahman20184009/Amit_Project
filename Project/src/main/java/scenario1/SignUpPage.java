package scenario1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    // Constructor
    WebDriver driver;
    WebDriverWait wait ;
        public SignUpPage(WebDriver driver) {
            this.driver = driver;

    }

    // Locators
    private By signUpButton = By.id("signin2");
    private By userNameBox = By.id("sign-username");
    private By passwordBox = By.id("sign-password");
    private By submitButton = By.xpath("//button[contains(text(), 'Sign up')]");

    // Actions
    public void clickOnSignUp() {
        driver.findElement(signUpButton).click();
        //Wait so the Popup take its time to show up
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameBox));
    }

    public void insertUserName(String userName) {
        driver.findElement(userNameBox).sendKeys(userName);
    }

    public void insertPassword(String password) {
        driver.findElement(passwordBox).sendKeys(password);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
    public String getSuccessMessage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}
