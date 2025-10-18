package php.automationpractice.gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends BasePage{
    private By myAccountHeader = By.cssSelector("h1.page-heading");
    private By womenSection = By.xpath("//a[@title='Women']");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductHeaderDisplayed(){
        WebElement h1 = find(myAccountHeader);
        return h1.isDisplayed() && h1.getText().trim().equalsIgnoreCase("My account");
    }
}
