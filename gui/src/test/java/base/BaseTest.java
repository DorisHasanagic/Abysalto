package base;

import php.automationpractice.core.utility.UserDataStorage;
import php.automationpractice.gui.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected HomePage homepage;
    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;
    protected MyAccountPage myAccountPage;
    protected ProductsPage productsPage;
    private String url = "http://www.automationpractice.pl/index.php";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();          // inicijalizacija lokalnog WebDriver objekta za test
        driver.manage().window().maximize();
        driver.get(url);                    //loadanje aplikacije

        basePage = new BasePage(driver);          
        homepage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        myAccountPage = new MyAccountPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @AfterClass
    public void cleanUp() {
        UserDataStorage.clear();
        driver.quit();
    }

}

