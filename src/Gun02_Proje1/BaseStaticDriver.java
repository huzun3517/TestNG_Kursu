package Gun02_Proje1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import java.util.concurrent.TimeUnit;

public class BaseStaticDriver {

    public static WebDriver driver;

    // direk bu class çağrıldığı anda canlı olması için static blok içine alındı
    static {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // consola yazılan gereksiz bilgileri sessize aldı.

        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        // hangi browseri kullanacağımı ve tarayıcının path ini verdim.

        driver = new ChromeDriver(); // çalıştıracağımız driveri kontrol edecek değişkeni tanımladım.

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS); // sadece ana sayfa yüklenirken en başta
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // bütün webElementler için geçerli
    }
}