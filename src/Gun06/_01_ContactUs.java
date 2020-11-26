package Gun06;

import Utils.MetodDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

 /*TODO
            Senaryo-1
            1- Siteye gidiniz
            2- contact Us tiklayiniz
            3- Mesaj bölümüne bir metin giriniz.
            4-Submit e tıklayınız
            3- Mesaja yazılan yazının kontrolünü yapınız...     */

public class _01_ContactUs extends MetodDriver {

    @Test
    @Parameters("enquiry") // xml den alacağı parametrenin adı buraya yazıldı.
    public void contactUs(String enquiry) { // parametre alabilir hale getirildi

        //Contact Us Linkine tıklandı (En alltta)
        WebElement contactLink = driver.findElement(By.linkText("Contact Us"));
        contactLink.click();

        // Mesaj kısmına yazı yazıldı
        WebElement enquiryInput = driver.findElement(By.cssSelector("textarea#input-enquiry"));
//        enquiryInput.sendKeys("Hello Marketing, We are comming");
        enquiryInput.sendKeys(enquiry); // mesaj kısmına yazdığımız metni parametre ile aldık

        // Submit tıklandı
        WebElement submitButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        submitButton.click();

        // Ekrana çıkan yazı Assert ile kontrol edildi
        WebElement successMessage = driver.findElement(By.cssSelector("div#content>p"));

        Assert.assertTrue(successMessage.getText().toLowerCase().contains("successfully"));

    }
}
