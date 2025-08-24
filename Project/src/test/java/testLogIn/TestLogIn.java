package testLogIn;

import Base.BaseClass;
import com.beust.ah.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import secenario2.LoginPage;

public class TestLogIn extends BaseClass {
    private static final Logger log = LoggerFactory.getLogger(TestLogIn.class);

    @Test
    public void login() throws InterruptedException {

        //Click On login to insert the username/password
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLoginButton();
        loginPage.clickOnUserNameBoxInLogin("ahmed12344");
        loginPage.clickOnPasswordBox("123");

        //click on login to go inside the website
        loginPage.clickOnSubmitLogin();

        //assert that you passed the login
        String actualMessage = loginPage.getWelcomeMessage();
        Assert.assertEquals(actualMessage, "Welcome ahmed12344", "Welcome ahmed12344");

        //click on Sony Laptop
        loginPage.clickOnLaptopsButton();
        loginPage.clickOnLaptopSonyA5();


        //click on Add to cart button
        loginPage.clickOnAddToCart();


        //Assert that the product just added
        String alertMessage = loginPage.getSuccessMessage();
        Assert.assertEquals(alertMessage, "Product added.");


        //Back to home
        loginPage.clickOnHomePage();

        //Click on the 2nd Laptop Sony I7
        loginPage.clickOnSonyI7();
        loginPage.ClickOnAddToCartSonyI7();

        String alertMessageForSonyI7 = loginPage.getSuccessMessage();
        Assert.assertEquals(alertMessageForSonyI7, "Product added.");

        //Click on Cart Button
        loginPage.clickOnCartLink();


        //Assert on Product sony i7
        String cartProductSonyi7 = loginPage.getProductInCart();
        Assert.assertEquals(cartProductSonyi7, "1580", "1580");

        //Place order
        loginPage.ClickOnPlaceOrder();

        //DataFourm
        loginPage.clickOnName("Ahmed");
        loginPage.clickOnCountry("Egypt");
        loginPage.clickOnCity("New-Cairo");
        loginPage.clickOnCredit("123");
        loginPage.clickOnMonth("4");
        loginPage.clickOnYear("2018");

        //Submit Fourm
        loginPage.clickOnSubmitFourmButton();

        //Confrim message Appears
        loginPage.thankYouMessageAfterPlacingOrder();


        //Ok button the end of the submition

        loginPage.clickOnOkButton();

    }

    //Bonus TestCase-4 Invaild Credentional

    @Test
    public void invaildCredentials() throws InterruptedException {

        //Click On login to insert the Invaild username/password
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLoginButton();
        loginPage.clickOnUserNameBoxInLogin("Soliuman");
        loginPage.clickOnPasswordBox("123");

        //click on login
        loginPage.clickOnSubmitLogin();

        //assert invaild message
        String actualMessage = loginPage.getAlertMessage();
        Assert.assertEquals(actualMessage, "User does not exist.");
    }
}


















