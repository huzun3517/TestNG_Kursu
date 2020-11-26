package Gun07_Proje2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Set;

public class Task1 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://demowebshop.tricentis.com/register");

        // ANASAYFA ID Sİ
        String anaSayfaIDsi = driver.getWindowHandle();
        System.out.println("Ana Sayfa ID = " + anaSayfaIDsi);

        // LoginLink Tıklandı
        WebElement logLink = driver.findElement(By.linkText("Log in"));
        logLink.click();

        // E-Mail girişi yapıldı
        WebElement email = driver.findElement(By.cssSelector("input#Email"));
        email.sendKeys("suzun3545@gmail.com");

        // Password girişi yapıldı
        WebElement password = driver.findElement(By.cssSelector("input#Password"));
        password.sendKeys("08011985");

        // Login Tıklatıldı
        WebElement loginButton = driver.findElement(By.cssSelector("input.button-1.login-button"));
        loginButton.click();

        // FacebookLink Tıklatıldı
        WebElement facebook = driver.findElement(By.linkText("Facebook"));
        facebook.click();

        //ID LERİ BULDUK. 2.WEBSAYFASINA GEÇTİK.(FACEBOOK SAYFASI)
        Set<String> windowIdler = driver.getWindowHandles();

        for (String ID: windowIdler) {

            if (ID.equals(anaSayfaIDsi)) continue;

            System.out.println("diğer sayda IDsi = " + ID);

            driver.switchTo().window(ID);
        }

        // 2.SAYFA URL VE ASSERT İLE URL DOĞRULAMA
        String url = driver.getCurrentUrl();
        System.out.println("facebookUrl = " + url);

        Assert.assertTrue(url.toLowerCase().contains("facebook"));

        driver.close(); //2.Sayfayı kapattık

        // ANASAYFAYA GERİ DÖNDÜK
        driver.switchTo().window(anaSayfaIDsi);

        // Contact us Linki tıklatıldı.
        WebElement contactUs = driver.findElement(By.linkText("Contact us"));
        contactUs.click();

        // enquiry Mesaj ekleme
        WebElement enquiry = driver.findElement(By.cssSelector("textarea#Enquiry"));
        enquiry.sendKeys("Güz gülleri gibiyim hiç bahar görmedim");

        // Submit Button tıklandı
        WebElement submitButton = driver.findElement(By.cssSelector("input.button-1.contact-us-button"));
        submitButton.click();

        // Enquiry  Mesaj Doğrulama
        WebElement messageEnquiry = driver.findElement(By.cssSelector("div.result"));
        Assert.assertEquals("Your enquiry has been successfully sent to the store owner.",messageEnquiry.getText());
//      Assert.assertTrue(messageEnquiry.getText().contains("successfully "));

        System.out.println("Test Başarılı....");
        Thread.sleep(2000);
        driver.quit();
    }
}