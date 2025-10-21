package php.automationpractice.gui;

import org.openqa.selenium.By;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import php.automationpractice.core.commonmethods.PageActions;
import php.automationpractice.core.randomgenerator.RandomGenerator;
import php.automationpractice.core.utility.UserDataStorage;

public class RegistrationPage extends PageActions {
    private By titleRadioButtonMr = By.id("id_gender1");
    private By titleRadioButtonMrs = By.id("id_gender2");
    private By firstNameField = By.id("customer_firstname");
    private By lastNameField = By.id("customer_lastname");
    private By passwordField = By.id("passwd");
    private By dayWrapper = By.id("uniform-days");
    private By monthWrapper = By.id("uniform-months");
    private By yearWrapper = By.id("uniform-years");
    private By dateOfBirthDayDDM = By.id("uniform-days");
    private By dateOfBirthMonthDDM = By.id("months");
    private By dateOfBirthYearDDM = By.id("years");
    private By registerButton = By.id("submitAccount");
    RandomGenerator random = new RandomGenerator();

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void selectRadioButton(){
        List<By> titles = Arrays.asList(titleRadioButtonMr, titleRadioButtonMrs);
        click(titles.get(new Random().nextInt(titles.size())));
    }

    public void setFirstName (String firstName){
        set(firstNameField, firstName);
    }
    public void setLastName (String lastName){
        set(lastNameField, lastName);
    }
    public void setPassword (String password){
        set(passwordField, password);
    }

    public void selectDay(int day){
        selectFromDropdown(dayWrapper, dateOfBirthDayDDM, String.valueOf(day));
    }
    public void selectMonth(int month) {
        selectFromDropdown(monthWrapper, dateOfBirthMonthDDM, String.valueOf(month));
    }
    public void selectYear(int year) {
        selectFromDropdown(yearWrapper, dateOfBirthYearDDM, String.valueOf(year));
    }

    public void fillTheForm(){
        selectRadioButton();
        setFirstName(random.getFirstName());
        setLastName(random.getLastName());
        setPassword(random.getPassword());
        selectDay(random.getDay());
        selectMonth(random.getMonth());
        selectYear(random.getYear());

        UserDataStorage.addUser(random);
    }

    public MyAccountPage clickRegisterButton(){
        click(registerButton);
        return new MyAccountPage(driver);
    }
}

