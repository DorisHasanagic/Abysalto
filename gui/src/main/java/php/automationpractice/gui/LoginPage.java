package php.automationpractice.gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import php.automationpractice.core.commonmethods.PageActions;

public class LoginPage extends PageActions {
    private By emailInput = By.id("email_create");
    private By createAccount = By.id("SubmitCreate");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email){
        set(emailInput, email);
    }

    public RegistrationPage clickCreateAccount(){
        click(createAccount);
        return new RegistrationPage(driver);
    }
}
