package php.automationpractice.gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import php.automationpractice.core.commonmethods.PageActions;

public class HomePage extends PageActions {
    private By signInButton = By.xpath("//a[@title='Log in to your customer account']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public  LoginPage clicksignInButton(){
        click(signInButton);
        return new LoginPage(driver);
    }

}
