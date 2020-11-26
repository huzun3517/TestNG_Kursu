package Gun01;

import Utils.MetodDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/*    TODO
         1- http://opencart.abstracta.us/index.php?route=account/login  sitesini açınız.
         2- asd@gmail.com  ve 123qweasd   bilgileri ile login olan test metodunu yazınız.
         3- Login olup olmadığınızı assert ile kontrol ediniz.
         4- bir utils paketi açınız ve buraya beforeClass ve afterClass metdolarını yazarak
            genel kullanım için MetodWebDriver isimli test klasını tanımlayınız.*/

public class _05_Ornek extends MetodDriver {

    @Test
    void loginKontrol() throws InterruptedException {

/*     bu bölüm MetodDiver dan extends edildiği için yoruma aldım.

        // E-Mail
        WebElement email = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        email.sendKeys("asd@gmail.com");

        // Password
        WebElement pass = driver.findElement(By.id("input-password"));
        pass.sendKeys("123qweasd");

        //Login Butonu
        WebElement btnLogin = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        btnLogin.click();

        // Güvenlik uyarısı
        WebElement btnGelismis = driver.findElement(By.cssSelector("button#details-button"));
        btnGelismis.click();

        // opencart.abstracta.us sitesine ilerle (güvenli değil) yazısına tıklatma
        WebElement btnIlerle = driver.findElement(By.cssSelector(" #proceed-link"));
        btnIlerle.click();
 */

        // Loginden sonra açılan sayfanın title ını aldık
        String tittle = driver.getTitle();

        // Login olduğumuzun kontrolu
        Assert.assertEquals(tittle,"My Account");

        System.out.println("Login Başarı ile gerçekleşmiştir...");

    }
}
