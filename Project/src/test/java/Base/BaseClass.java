package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class BaseClass {
    public WebDriver driver;

    @BeforeClass
    public void setUp (){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        goHome();
    }

    @BeforeMethod
    public void  goHome(){
        driver.get("https://www.demoblaze.com/");
    }
    @AfterClass
    public void quitBrowser(){
        driver.quit();

    }
}
