package base;

import php.automationpractice.core.commonmethods.PageActions;
import php.automationpractice.core.utility.UserDataStorage;
import php.automationpractice.gui.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected PageActions pageActions;
    protected HomePage homepage;
    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;
    protected MyAccountPage myAccountPage;
    protected ProductsPage productsPage;
    private String url = "http://www.automationpractice.pl/index.php";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        pageActions = new PageActions(driver);
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

