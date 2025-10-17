package php.automationpractice.gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//LoginPage predstavlja login stranicu s metodama specifičnim za login (setUsername, setPassword, clickLoginbutton).
public class LoginPage extends BasePage{
    private By emailInput = By.id("email_create");
    private By createAccount = By.id("SubmitCreate");          // By predstavlja tip, isto kao da pise int x;

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
