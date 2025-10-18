package php.automationpractice.gui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.NoSuchElementException;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){       //Svi Page Objecti koji nasljede BasePage imaju konstruktor koji prima WebDriver
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitToBeClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    protected WebElement waitToBeVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void scrollToElement(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = find(locator);  //Locating element and store in variable "element"
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected WebElement find(By locator){    // WebElement je tip koji se returna, jer findElement iz Selenium WebDriver vraca WebElement
        return driver.findElement(locator);
    }

    protected void set(By locator, String text){
        WebElement element = waitToBeClickable(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    protected void click(By locator){
        waitToBeClickable(locator).click();
    }

    protected void selectFromDropdown(By wrapper, By locator, String value){
        try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(wrapper));
        click(wrapper);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        scrollToElement(locator);
        WebElement element = waitToBeVisible(locator);
        Select select = new Select(element);
        select.selectByValue(value);
        } catch (NoSuchElementException e){
            System.out.println("Element not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error during scroll: " + e.getMessage());
        }
    }
}
