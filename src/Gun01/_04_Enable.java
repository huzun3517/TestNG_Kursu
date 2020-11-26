package Gun01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*    TODO
         1- http://opencart.abstracta.us/index.php?route=account/login  sitesini açınız.
         2- Test1---> sayfanın url sini alınız
         3- Test2---> sayfanın title ını alınız.
         4- Test3---> sayfanın handle(ID) sini alınız*/

import java.util.concurrent.TimeUnit;

public class _04_Enable {

    public static WebDriver driver;

    @BeforeClass
    void BeforeClass() {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");// consola yazılan gereksiz bilgileri sessize aldı.
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe"); // hangi browseri kullanacağımı ve tarayıcının path ini verdim.
        driver = new ChromeDriver(); // çalıştıracağımız driveri kontrol edecek değişkeni tanımladım.
        driver.manage().window().maximize(); // Ekranı tam ekran yaptım.
        driver.manage().deleteAllCookies(); // Çerezleri temizledim.

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // sadece ana sayfa yüklenirken en başta
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); // bütün webElementler için geçerli

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
    }

    @AfterClass
    void AfterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


    @Test
    void Test1(){
        String url = driver.getCurrentUrl();
        System.out.println("url = " + url);
    }

    @Test(enabled = false)  // Test2 ye çalışma dedik. Yani enable yaptık
    void Test2(){
        String title = driver.getTitle();
        System.out.println("title = " + title);
    }

    @Test
    void Test3(){
        String handle = driver.getWindowHandle();
        System.out.println("handle = " + handle);
    }
}
