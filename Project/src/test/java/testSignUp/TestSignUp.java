package testSignUp;

import Base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import scenario1.SignUpPage;

import java.util.UUID;

public class TestSignUp extends BaseClass {

    @Test
    public void signUp() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickOnSignUp();

        // Generate unique username and password
        String uniqueUsername = "user_" + UUID.randomUUID().toString().substring(0, 8);
        String uniquePassword = "pass_" + UUID.randomUUID().toString().substring(0, 8);
        signUpPage.insertUserName(uniqueUsername);
        signUpPage.insertPassword(uniquePassword);
        signUpPage.clickSubmitButton();

        //Assret success message
        String alertMessage = signUpPage.getSuccessMessage();
        Assert.assertEquals(alertMessage, "Sign up successful.");
    }

    //Bonus Task 1
    @Test
    public void signUpExistingUser() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickOnSignUp();

        // Using an already existing username
        String existingUser = "ahmed12344";
        String password = "123";
        signUpPage.insertUserName(existingUser);
        signUpPage.insertPassword(password);
        signUpPage.clickSubmitButton();

        //Assret  message
        String alertMessage = signUpPage.getSuccessMessage();
        Assert.assertEquals(alertMessage, "This user already exist.","This user already exist.");
    }

}
