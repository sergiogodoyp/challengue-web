package challengue.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    public enum NavegadorWeb {CHROME};

    private DriverManager(){

    }

    public static WebDriver getInstancia(NavegadorWeb navegador){
        return getChromeDriver();
    }

    public static WebDriver getChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return aplicarConfiguracionEnComun(new ChromeDriver());
    }

    public static WebDriver aplicarConfiguracionEnComun(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
