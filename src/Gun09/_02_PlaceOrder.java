package Gun09;

import Utils.MetodDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

/*TODO
    Senaryo :
    1- Siteyi açınız.
    2- Sitede "ipod" kelimesini aratınız
    3- Çıkan sonuclardan ilkini sepete atınız.
    4- Shopping Chart a tıklatınız.
    5- Checkout yapınız.
    6- Continue butonalarına tıklatıp bilgileri giriniz.
    7- En confirm ile siparişi verdiğinizi doğrulayınız.
       doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.*/

public class _02_PlaceOrder extends MetodDriver {

    @Test
    public void ProceedToCheckout()
    {
        WebElement searchInput=driver.findElement(By.cssSelector("input[name='search']"));
        searchInput.sendKeys("ipod");

        WebElement searchButton=driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> itemNameList = driver.findElements(By.xpath("//span[text()='Add to Cart']"));
        itemNameList.get(0).click();

        WebElement shoppingCart=driver.findElement(By.xpath("//span[text()='Shopping Cart']"));
        shoppingCart.click();

        WebElement CheckoutButton=driver.findElement(By.linkText("Checkout"));
        CheckoutButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement continu1 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-payment-address")));
        continu1.click();

        WebElement continu2 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-address")));
        continu2.click();

        WebElement continu3 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("collapse-shipping-address")));
        continu3.click();

        WebElement continu4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-shipping-method")));
        continu4.click();

        WebElement checkBox =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
        checkBox.click();

        WebElement continue5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-payment-method")));
        continue5.click();

        WebElement confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-confirm")));
        confirmButton.click();

        wait.until(ExpectedConditions.urlContains("success"));

        WebElement mesaj = driver.findElement(By.xpath("//div[@id='content']/h1"));
        String ekranMesaji = mesaj.getText();

        Assert.assertEquals(ekranMesaji, "Your order has been placed!");

    }
}