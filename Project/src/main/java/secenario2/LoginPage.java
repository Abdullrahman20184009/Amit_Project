package secenario2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    //Locators

    //vaild Login
    private By loginButton = By.id("login2");
    private By userNameBox = By.id("loginusername");
    private By passwordBox = By.id("loginpassword");
    private By submitLogin = By.xpath("//button[contains(text(),'Log in')]");

    //assert that the same user entered
    private By welcomeMessage = By.id("nameofuser");

    //adding product to the cart (laptop I5 and I7)
    private By laptopButton = By.xpath("//a[@id='itemc' and text()='Laptops']");
    private By sonyVaioButton= By.xpath("//a[contains(text(), 'Sony vaio i5')]");
    private By addToCart = By.cssSelector(".btn.btn-success.btn-lg");
    private By homeButton = By.xpath("//a[contains(text(),'Home')]");
    private By sonyI7 = By.xpath("//a[contains(text(), 'Sony vaio i7')]");
    private By addToCartSonyI7 = By.cssSelector(".btn.btn-success.btn-lg");
    private By cartButton = By.xpath("//a[contains(text(),'Cart')]");
    private By totalPrice = By.id("totalp");
    private By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");

    //Data Fourm
    private By dataFourm = By.id("name");
    private By countryName = By.id("country");
    private By cityName = By.id("city");
    private By creditCard = By.id("card");
    private By monthOfBirth = By.id("month");
    private By yearOfBirth = By.id("year");
    private By submitFourm = By.xpath("//button[contains(text(),'Purchase')]");
    private By okButton = By.xpath("//button[contains(text(),'OK')]");
    private By confirmOrderMessage = By.xpath("//h2[text()='Thank you for your purchase!']");

    /// //////////////////////////////////////////////////////////////////////// //

    /// /////////////////////////////////////////////////////////////////////// //
    //Actions
    public void clickOnLoginButton(){

        driver.findElement(loginButton).click();
        //Wait so the Popup take its time to show up
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameBox));
    }
    public void clickOnUserNameBoxInLogin(String username){

        driver.findElement(userNameBox).sendKeys(username);
    }
    public void clickOnPasswordBox(String password){
        driver.findElement(passwordBox).sendKeys(password);
    }

    //Passed the login cridential
    public void clickOnSubmitLogin(){
        driver.findElement(submitLogin).click();
    }

    //Assert the login successfully
    public String getWelcomeMessage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage)).getText();
    }

    //Select the laptop
    public void clickOnLaptopsButton(){
        driver.findElement(laptopButton).click();
    }
    public void clickOnLaptopSonyA5(){
        wait.until(ExpectedConditions.elementToBeClickable(sonyVaioButton)).click();
    }
    public void clickOnAddToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
    }

    //Assert that we added the laptop
    public String getSuccessMessage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    //Back to home
    public void clickOnHomePage(){
        driver.findElement(homeButton).click();
    }

    //Product 2 Added
    public void clickOnSonyI7(){
        wait.until(ExpectedConditions.elementToBeClickable(sonyI7)).click();
    }
    public void ClickOnAddToCartSonyI7(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartSonyI7)).click();
    }
    public String getProductInCart(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice)).getText();
    }

    //Products In the Cart
    public void clickOnCartLink(){
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
    }

    //Place order
    public void ClickOnPlaceOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder)).click();
    }


    //Data Fourm
    public void clickOnName(String dataName){
        wait.until(ExpectedConditions.elementToBeClickable(dataFourm)).sendKeys(dataName);
    }
    public void clickOnCountry(String country){
        driver.findElement(countryName).sendKeys(country);
    }
    public void clickOnCity(String city){
        driver.findElement(cityName).sendKeys(city);
    }
    public void clickOnCredit(String credit){
        driver.findElement(creditCard).sendKeys(credit);
    }
    public void clickOnMonth(String month){
        driver.findElement(monthOfBirth).sendKeys(month);
    }
    public void clickOnYear(String year){
        driver.findElement(yearOfBirth).sendKeys(year);
    }

    //Submit Fourm
    public void clickOnSubmitFourmButton(){
        wait.until(ExpectedConditions.elementToBeClickable(submitFourm)).click();
    }

    //Confirming the message

    public void thankYouMessageAfterPlacingOrder(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderMessage));
    }
    //Ok button the end of the submition
    public void clickOnOkButton(){
        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
    }

    //Bonus TC_4
    public String getAlertMessage() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }



}