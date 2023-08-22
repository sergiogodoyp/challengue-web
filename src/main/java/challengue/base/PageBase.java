package challengue.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver){
        this.driver = driver;
    }

    public WebElement findElement(By element) {
        return driver.findElement(element);
    }

    public List<WebElement> findElements(By element){
        return driver.findElements(element);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By element) {
        return driver.findElement(element).getText();
    }

    public void type(String inputText, By element) {
        driver.findElement(element).sendKeys(inputText);
    }

    public void click(By element) {
        driver.findElement(element).click();
    }

    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        }catch(org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void seleccionarOpcion(String opcion){
        driver.findElement(By.xpath("//a[normalize-space()='"+opcion+"']")).click();
    }


}
