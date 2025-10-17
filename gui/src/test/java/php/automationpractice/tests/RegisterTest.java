package php.automationpractice.tests;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;
import php.automationpractice.core.randomgenerator.RandomGenerator;

public class RegisterTest extends BaseTest {
    @Test
    public void SuccessfulRegistration(){
      RandomGenerator random = new RandomGenerator();

      homepage.clicksignInButton();
      loginPage.enterEmail(random.getEmail());
      loginPage.clickCreateAccount();
      registrationPage.fillTheForm();
      registrationPage.clickRegisterButton();
      assertTrue("My Account section is displayed", myAccountPage.isProductHeaderDisplayed());
    }
}
