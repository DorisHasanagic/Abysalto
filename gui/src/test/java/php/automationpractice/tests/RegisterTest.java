package php.automationpractice.tests;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;
import php.automationpractice.core.randomgenerator.RandomGenerator;
import php.automationpractice.core.utility.UserDataStorage;

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

      for (RandomGenerator user : UserDataStorage.getUsers()){
          System.out.println("User's data:" + " "+ user.getFirstName() + " " + user.getLastName() + " " + user.getEmail() + " " + user.getPassword() + " " + user.getDay() + " " + user.getMonth() + " " + user.getYear());
      }
    }
}
