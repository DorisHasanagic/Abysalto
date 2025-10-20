package php.automationpractice.gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import php.automationpractice.core.commonmethods.PageActions;

import static php.automationpractice.core.constants.Constants.*;

public class ProductsPage extends PageActions {
    private By sortByWrapper = By.id("uniform-selectProductSort");
    private By sortByDDM = By.id("selectProductSort");
    private By filterOptionBlack = By.id("layered_id_attribute_group_11");
    private By sliderContainer = By.id("#"); //TODO
    private By leftSlider = By.cssSelector(""); //TODO
    private By rightSlider = By.cssSelector(""); //TODO

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void sortByProductName(){
        selectFromDropdown(sortByWrapper, sortByDDM, SORT_A_TO_Z);
    }

    public void filterByColorBlack(){
        click(filterOptionBlack);
    }

    public void setPriceRange20to30(){
        //TODO
    }
}
