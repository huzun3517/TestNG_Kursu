package Gun03;

import Utils.MetodDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*TODO
      1- Siteyi açınız.
      2- Edit Account a tıklatınız.
      3- Yeni isim ve soyisim göndererek Continue yapınız.
      4- İşlem sonucunu kontrol ediniz.
      5- Bu işlemi 2 kez çalıştırarak eski haline getiriniz.*/

public class _03_EditAccount extends MetodDriver {

        @Test
        void EditAccount() {
        AccountEdit("Hüseyin","U");
        AccountEdit("Ömer Faruk","U");
         }


     String oldName = "";
     String oldLastName = "";
     String neuName = "";
     String neuLastName = "";


    void AccountEdit(String name, String surName) {

        WebElement editAccount = driver.findElement(By.xpath("//a[text()='Edit Account']"));
        editAccount.click();

        WebElement firsName = driver.findElement(By.cssSelector("input#input-firstname"));
        oldName = firsName.getAttribute("value");
        firsName.clear();
        firsName.sendKeys(name);
        neuName = firsName.getAttribute("value");

        WebElement lastName = driver.findElement(By.cssSelector("input#input-lastname"));
        oldLastName = lastName.getAttribute("value");
        lastName.clear();
        lastName.sendKeys(surName);
        neuLastName = lastName.getAttribute("value");

        WebElement continueButton = driver.findElement(By.cssSelector(" input.btn.btn-primary"));
        continueButton.click();

//todo        İşlemin doğruğu çıkan mesajdan kontorl edildi.
 //       WebElement SuccessMessage = driver.findElement(By.cssSelector("div.alert.alert-success"));
 //       Assert.assertTrue(SuccessMessage.getText().contains("uccess"));

//        Tools.successMessageValidation(driver); --> yukardaki satırın method ile yapılmış hali

        Assert.assertFalse(oldName == neuName);
        System.out.println("Eski ismin değiştiği doğrulandı...");

        Assert.assertFalse(oldLastName == neuLastName);
        System.out.println("Eski soyismin değiştiği doğrulandı...");
    }
}
