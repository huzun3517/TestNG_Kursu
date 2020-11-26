package Gun07_Proje2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Task2 extends BaseStaticDriver {

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

       // categories --> Computers  tıklandı
        WebElement computerLink = driver.findElement(By.linkText("Computers"));
        computerLink.click();

        // Desktops tıklatıldı
        WebElement desktops = driver.findElement(By.linkText("Desktops"));
        desktops.click();

        // add To Cart tıklatıldı
        WebElement addToCart = driver.findElement(By.linkText("Build your own expensive computer"));
        addToCart.click();

        // fast tıklatıldı
        WebElement fast = driver.findElement(By.cssSelector("input#product_attribute_74_5_26_82"));
        fast.click();

        // ram 8GB tıklatıldı
        WebElement ram = driver.findElement(By.cssSelector("input#product_attribute_74_6_27_85"));
        ram.click();

        // hdd 400 tıklatıldı
        WebElement hdd = driver.findElement(By.cssSelector("input#product_attribute_74_3_28_87"));
        hdd.click();

        // Software --> Other Office Suite'i seçildi
        WebElement sofware = driver.findElement(By.cssSelector("input#product_attribute_74_8_29_90"));
        sofware.click();

        // add To Cart tıklatıldı
        WebElement addToCart2 = driver.findElement(By.cssSelector("input#add-to-cart-button-74"));
        addToCart2.click();

        //Shopping Cart'a tıklayınız.
        WebElement shoppingCart = driver.findElement(By.linkText("Shopping cart"));
        shoppingCart.click();

        //I agree tıklatıldı
        WebElement agreeButton = driver.findElement(By.cssSelector("input#termsofservice"));
        agreeButton.click();

        // Checkout buttonuna tıklayınız.
        WebElement checkout = driver.findElement(By.cssSelector("button#checkout"));
        checkout.click();

        // Address Formu Dolduruldu
        WebElement country = driver.findElement(By.cssSelector("select#BillingNewAddress_CountryId"));
        Select menu = new Select(country);
        menu.selectByValue("77");

        // City
        WebElement city = driver.findElement(By.cssSelector("input#BillingNewAddress_City"));
        city.sendKeys("İzmir");

        // Adress
        WebElement adress = driver.findElement(By.cssSelector("input#BillingNewAddress_Address1"));
        adress.sendKeys("Karşıyaka");

        // Postakodu
        WebElement postakodu = driver.findElement(By.cssSelector("input#BillingNewAddress_ZipPostalCode"));
        postakodu.sendKeys("35520");

        // Telefon
        WebElement telefon = driver.findElement(By.cssSelector("input#BillingNewAddress_PhoneNumber"));
        telefon.sendKeys("02323670562");

        // Continue butonu tıklatıldı
        WebElement continueButton = driver.findElement(By.cssSelector("input.button-1.new-address-next-step-button"));
        continueButton.click();

        // Continue2 butonu tıklatıldı
        WebElement continueButton2 = driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[2]"));
        continueButton2.click();

        // shipMethodContinue
        WebElement shipMethodContinue = driver.findElement(By.xpath("(//input[@class='button-1 shipping-method-next-step-button'])"));
        shipMethodContinue.click();

        // cashContinue
        WebElement cashContinue = driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']"));
        cashContinue.click();

        // paymentContinue
        WebElement paymentContinue = driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']"));

        // Bekletme
        WebDriverWait wait=new WebDriverWait(driver, 15);// sadece süre tanımlandı henüz aktif değil.
        wait.until(ExpectedConditions.elementToBeClickable(paymentContinue));

        paymentContinue.click();

        // confirmContinue
        WebElement confirmContinue = driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']"));
        confirmContinue.click();

        // Message doğrulama
        WebElement message = driver.findElement(By.cssSelector("div.title"));
        Assert.assertEquals("Your order has been successfully processed!",message.getText());

        // Adres Kısmının temizlenmesi için aşağıdaki kodları yazdık...
        // myAccount
        WebElement myAccount = driver.findElement(By.linkText("My account"));
        myAccount.click();

        // Addresses
        WebElement addresses = driver.findElement(By.linkText("Addresses"));
        addresses.click();

        WebElement delete = driver.findElement(By.cssSelector("input.button-2.delete-address-button"));
        delete.click();

        driver.switchTo().alert().accept(); // hata mesajı kabul edildi.

        System.out.println("Test Başarılı....");
        Thread.sleep(2000);
        driver.quit();
    }
}