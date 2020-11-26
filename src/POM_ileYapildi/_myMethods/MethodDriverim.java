package POM_ileYapildi._myMethods;

import POM_ileYapildi.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class MethodDriverim {

    protected WebDriver driver;

    @BeforeClass
    public void BeforeClass(){
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        Elements elements = new Elements(driver);
        elements.email.sendKeys("asd@gmail.com");
        elements.password.sendKeys("123qweasd");
        elements.loginButton.click();
        elements.gelismisButton.click();
        elements.next.click();
    }

    @AfterClass
    public void AfterClass() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }
}
