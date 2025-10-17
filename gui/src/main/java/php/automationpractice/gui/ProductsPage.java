package php.automationpractice.gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{
    private By productsHeader = By.xpath("//span[text()='Products']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


}
