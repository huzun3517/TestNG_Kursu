package Gun11_Proje3B;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class Proje_ParameterDriver {

    protected WebDriver driver;

    @BeforeClass
    @Parameters({"browser","username","password"})
    public void BeforeClass(String browser, String username, String password)
    {

        if (browser.equalsIgnoreCase("chrome")) {

            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            driver=new ChromeDriver();
        }

        else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
            driver=new FirefoxDriver();
        }


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://demowebshop.tricentis.com/register");

        // LoginLink Tıklandı
        WebElement logLink = driver.findElement(By.linkText("Log in"));
        logLink.click();

        // E-Mail girişi yapıldı
        WebElement email = driver.findElement(By.cssSelector("input#Email"));
        email.sendKeys(username);

        // Password girişi yapıldı
        WebElement pass = driver.findElement(By.cssSelector("input#Password"));
        pass.sendKeys(password);

        // Login Tıklatıldı
        WebElement loginButton = driver.findElement(By.cssSelector("input.button-1.login-button"));
        loginButton.click();

    }

    @AfterClass
    public void AfterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}