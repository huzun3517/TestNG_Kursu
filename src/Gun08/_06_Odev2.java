package Gun08;

import Utils.MetodDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//  04_Task1   deki testi daha önce yapılan ContacUs için yapınız.Birden fazla mesaj için.

/*TODO
            Senaryo-1
            1- Siteye gidiniz
            2- contact Us tiklayiniz
            3- Mesaj bölümüne bir metin giriniz.
            4-Submit e tıklayınız
            3- Mesaja yazılan yazının kontrolünü yapınız... */


public class _06_Odev2 extends MetodDriver {

    @Test(dataProvider = "getData")
    public void contactUs(String enquiry) {

        //Contact Us Linkine tıklandı (En alltta)
        WebElement contactLink = driver.findElement(By.linkText("Contact Us"));
        contactLink.click();

        // Mesaj kısmına yazı yazıldı
        WebElement enquiryInput = driver.findElement(By.cssSelector("textarea#input-enquiry"));
        enquiryInput.clear();
        enquiryInput.sendKeys(enquiry);

        // Submit tıklandı
        WebElement submitButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        submitButton.click();

        // Ekrana çıkan yazı Assert ile kontrol edildi
        WebElement successMessage = driver.findElement(By.cssSelector("div#content>p"));

        Assert.assertTrue(successMessage.getText().toLowerCase().contains("successfully"));

    }

    @DataProvider
    public Object[] getData(){

        Object[] data = {"Genç hisseden yeni Tester lar geliyor...","Piyasa bizi bekliyor...","Ümidi yitirmek yok..."};
        return data;
    }
}
