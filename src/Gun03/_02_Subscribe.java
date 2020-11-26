package Gun03;

import Utils.MetodDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*TODO
          Senaryo
          1- Siteyi açınız.
          2- Newsletter  Subscribe ve UnSubscribe işlemlerini ayrı ayı testlerde yapınız.
          3- Newsletter  üyelik işlemini, üye ise , üyelikten çıkma, değilse ekleme şeklinde yapınız */

public class _02_Subscribe extends MetodDriver {

/*TODO
        Bu bölgede değişken tanımlayabilirsiniz.
        Ama kendi başına kod çalıştıramazsınız.*/

    @Test()
    void SubscribeFunctionYes() {

        //Üyelik linkine tıklandı
        WebElement SubscribeButton = driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter"));
        SubscribeButton.click();

        // Evet seçildi, seçili olsa da farketmez
        WebElement yesRadioButton = driver.findElement(By.xpath("//input[@name='newsletter']"));
        yesRadioButton.click();

        //Continue (Tamam) butonuna basıldı.
        WebElement continueButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        continueButton.click();

//todo      İşlemin doğruğu çıkan mesajdan kontorl edildi.

//        WebElement SuccessMessage = driver.findElement(By.cssSelector("div.alert.alert-success"));
//        Assert.assertTrue(SuccessMessage.getText().contains("uccess"));

        Tools.successMessageValidation(driver);  // --> YENI YOL METHODLA YAPILDI. Üst satırdaki eski hali



    }

    @Test()
    void SubscribeFunctionNo() {

        //Üyelik linkine tıklandı
        WebElement SubscribeButton = driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter"));
        SubscribeButton.click();

        // Hayır seçildi, seçili olsa da farketmez
        WebElement noRadioButton = driver.findElement(By.xpath("(//input[@name='newsletter'])[2]"));
        noRadioButton.click();

        //Continue (Tamam) butonuna basıldı.
        WebElement continueButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        continueButton.click();

        //İşlemin doğruğu çıkan mesajdan kontorl edildi.
        Tools.successMessageValidation(driver);

    }

    @Test()
    void SubscribeFunctionForBoth() throws InterruptedException {

        //Üyelik linkine tıklandı
        WebElement SubscribeButton = driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter"));
        SubscribeButton.click();

        // seçili olanın teersini al
        WebElement noRadioButton = driver.findElement(By.xpath("(//input[@name='newsletter'])[2]"));
        WebElement yesRadioButton = driver.findElement(By.xpath("//input[@name='newsletter']"));

        Thread.sleep(3000);

        if (yesRadioButton.isSelected())
            noRadioButton.click();
        else
            yesRadioButton.click();

        //Continue (Tamam) butonuna basıldı.
        WebElement continueButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        continueButton.click();

        //İşlemin doğruğu çıkan mesajdan kontorl edildi.
        Tools.successMessageValidation(driver);
    }
}
