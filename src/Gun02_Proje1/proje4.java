package Gun02_Proje1;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class proje4 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("http://www.e-shopland.ch/sellacious/index.php");

        String anaSayfaIDsi = driver.getWindowHandle();
        System.out.println("Ana Sayfa ID = " + anaSayfaIDsi);

        // ARA BUTONU TIKLANDI
        WebElement ara = driver.findElement(By.cssSelector("i.search-icon.fa.fa-search"));
        ara.click();

        // ARAMA BUTONUNA CANON YAZILDI
        WebElement canon = driver.findElement(By.cssSelector("input#finder125"));
        canon.sendKeys("Canon");

        // SEARCH BUTONU TIKLATILDI
        WebElement search = driver.findElement(By.cssSelector("button.btn.btn-primary.findersubmit.btn-right"));
        search.click();

        // // ADD TO CART BUTONU TIKLATILDI
        WebElement addToCart = driver.findElement(By.xpath(" (//button[@class='btn btn-default btn-add-cart add'])[1]"));
        addToCart.click();

        // CHECKOUT BUTONU TIKLATILDI
        WebElement checkout = driver.findElement(By.xpath("//button[@class='btn btn-small btn-primary']"));
        checkout.click();

        Thread.sleep(500);

        // MAİL ADRESİ YAZILDI
        WebElement mail = driver.findElement(By.cssSelector("input#login_email"));
        mail.sendKeys("technostudy@gmail.com");

        // PROCEED TIKLATILDI
        WebElement proceed = driver.findElement(By.cssSelector("button#login_email_submit"));
        proceed.click();

        // CHECKOUT AS GUEST TIKLATILDI
        WebElement checkoutAsGuest = driver.findElement(By.cssSelector("button#btn_guest_checkout"));
        checkoutAsGuest.click();

        // NAME YAZILDI
        WebElement name = driver.findElement(By.cssSelector("input#jform0_name"));
        name.sendKeys("Hüseyin");

        // COMPANY YAZILDI
        WebElement company = driver.findElement(By.cssSelector("input#jform0_company"));
        company.sendKeys("Techno Study");

        // POSTAKODU YAZILDI
        WebElement postaCodu = driver.findElement(By.cssSelector("input#jform0_po_box"));
        postaCodu.sendKeys("99089");

        // ADRESS YAZILDI
        WebElement adress = driver.findElement(By.cssSelector("#jform0_address"));
        adress.sendKeys("Erfurt");

        // LANDMARK YAZILDI
        WebElement landmark = driver.findElement(By.cssSelector("#jform0_landmark"));
        landmark.sendKeys("x5");

        //COUNTRY SEÇİLDİ
        driver.findElement(By.xpath("//div[@id='s2id_jform0_country']")).click();//ülke satırı tıklama

        List<WebElement> ulkeler = driver.findElements(By.cssSelector("div[class='select2-result-label']"));
        int max = ulkeler.size();
        ulkeler.get(random(max)).click();

        // SAVE BUTONU TIKLATILDI
        WebElement saveButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-save-address']"));
        saveButton.click();

        // BİLLHERE BUTONU TIKLATILDI
        WebElement billHere = driver.findElement(By.xpath("//button[@class='btn btn-small btn-default btn-bill-here']"));
        billHere.click();

        // DELİVER HERE BUTONU TIKLATILDI
        WebElement deliverHere = driver.findElement(By.xpath("//button[@class='btn btn-small btn-default btn-ship-here']"));
        deliverHere.click();

        // NEXT BUTONU TIKLATILDI
        WebElement nextButton = driver.findElement(By.xpath("(//a[@class='btn btn-small btn-default btn-next pull-right'])[1]"));
        nextButton.click();

        Thread.sleep(500);

        // NEXT BUTONU2 TIKLATILDI
        WebElement nextButton2 = driver.findElement(By.xpath("(//a[@class='btn btn-small btn-default btn-next pull-right'])[2]"));
        nextButton2.click();

        // PROCEED TO PAYMENT TIKLATILDI
        WebElement  ProceedToPayment = driver.findElement(By.xpath("//button[@class='btn-next btn btn-primary']"));
        ProceedToPayment.click();

        // PAY NOW TIKLATILDI
        WebElement  payNow = driver.findElement(By.xpath("(//button[@class='btn btn-primary btn-pay-now'])[1]"));
        payNow.click();

        // INFO BÖLÜMÜNDEKİ MESAJIN DOĞRULANMASI
        WebElement elementInfo = driver.findElement(By.cssSelector("div.alert.alert-info>div>p"));
        String infoText = elementInfo.getText();
        System.out.println("infoText = " + infoText);

        Assert.assertEquals("Payment via Cheque approved.",infoText);
        System.out.println("Ekrandaki yazı doğrulandı...");

        // SUCCESS BÖLÜMÜNDEKİ MESAJIN DOĞRULANMASI
        WebElement elementSuccess = driver.findElement(By.cssSelector("div.alert.alert-success>div>p"));
        String successText = elementSuccess.getText();
        System.out.println("successText = " + successText);

        Assert.assertEquals("Order placed successfully.",successText);
        System.out.println("Ekrandaki yazı doğrulandı...");

        Thread.sleep(2000);

        // ANASAYFADA SEÇİLEN ÜRÜN
        WebElement elementUrunSecilen = driver.findElement(By.xpath("//div[@class='orderinfos cart_product_info']"));
        String urunSecilen = elementUrunSecilen.getText();
        System.out.println("elementUrunSecilen = " + urunSecilen);

        // VIEW INVOICE BUTONUNA TIKLATILDI
        WebElement viewInvoice = driver.findElement(By.xpath("//span[text()='VIEW INVOICE']"));
        viewInvoice.click();

        //ID LERİ BULDUK. 2.WEBSAYFASINA GEÇTİK.
        Set<String> windowIdler = driver.getWindowHandles();

        for (String ID: windowIdler) {

            if (ID.equals(anaSayfaIDsi)) continue;

            System.out.println("dıger sayfa IDsi = " + ID);

            driver.switchTo().window(ID);
        }

        // 2.SAYFADAKİ(SEPETTEKİ) ÜRÜN İLE ANASAYFADA SEÇİLEN ÜRÜNÜN EŞİTLİĞİNİN DOĞRULANMASI
        WebElement elementUrunSepet = driver.findElement(By.xpath("//td[@class='v-top']"));
        String urunSepet = elementUrunSepet.getText();
        System.out.println("urunSepet = " + urunSepet);

        Assert.assertTrue(urunSecilen.contains(urunSepet.substring(0,10)));

        driver.close(); // 2.Sayfayı kapattık
        driver.switchTo().window(anaSayfaIDsi); // Anasayfaya geçtik.

        // VIEW RECEIPT BUTONUNA TIKLATTIK
        WebElement viewReceipt = driver.findElement(By.xpath("//span[text()='VIEW RECEIPT']"));
        viewReceipt.click();

        // YENİ AÇILAN 3.SAYFAYA GEÇİŞ YANİ FATURA BÖLÜMÜ
        Set<String> windowIdler2 = driver.getWindowHandles();

        for (String ID: windowIdler2) {

            if (ID.equals(anaSayfaIDsi)) continue;

            System.out.println("dıger sayfa IDsi = " + ID);

            driver.switchTo().window(ID);
        }

        // 3.SAYFADA YANİ MAKBUZDA E-MAİLİN DOĞRULUĞUNUN DOĞRULANMASI
        WebElement elementMail = driver.findElement(By.cssSelector("div.sub-title.text-center>strong"));
        String mailMakbuz = elementMail.getText();
        System.out.println("mailMakbuz = " + mailMakbuz);

        Assert.assertEquals("technostudy@gmail.com",mailMakbuz);
        System.out.println("Makbuzdaki mail adresi doğrulandı...");

        System.out.println("Test Başarılı....");
        Thread.sleep(2000);
        driver.quit();
    }

    public static int random(int max) {

        Random random = new Random();

        int uretilenSayi = random.nextInt(max);

        return uretilenSayi;
    }

}