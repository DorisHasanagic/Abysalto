package php.automationpractice.gui;

import org.openqa.selenium.By;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import php.automationpractice.core.randomgenerator.RandomGenerator;

public class RegistrationPage extends BasePage{
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

//    Metoda prima value od dropdown elementa (day,month,year).
//    Dohvati dropdown element s find().
//    Napravi Selenium Select objekt za taj dropdown.
//    Odaberi opciju prema atributu value (pretvoren u String).
//
//    public void selectDay(int day){
//        WebElement dayElement = find(dateOfBirthDayDDM);
//        Select select = new Select(dayElement);
//        select.selectByValue(String.valueOf(day));
//    }
//    public void selectMonth(int month){
//       WebElement monthElement = find(dateOfBirthMonthDDM);
//       Select select = new Select (monthElement);
//       select.selectByValue(String.valueOf(month));

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
    }

    public MyAccountPage clickRegisterButton(){
        click(registerButton);
        return new MyAccountPage(driver);
    }
}

