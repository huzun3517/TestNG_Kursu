package POM_ileYapildi._myMethods;

import POM_ileYapildi.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class ParameterDriverim {

    protected WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void BeforeClass(String browser){

        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
            System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
            driver = new ChromeDriver();
        }

        else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
            System.setProperty("webdriver.gecko.driver","C:/Users/Faruk_PC/Selenium/FirefoxDriver/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        //Login
        Elements elements = new Elements(driver);
        elements.email.sendKeys("asd@gmail.com");
        elements.password.sendKeys("123qweasd");
        elements.loginButton.click();

        //Güvenlik işlemlerini aşmak için
        if (!browser.equalsIgnoreCase("firefox")){

            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button[id='details-button']")));

            elements.gelismisButton.click();
            elements.next.click();
        }
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
