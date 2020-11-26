package Gun06;

import Utils.MetodDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/*TODO
            Senaryo-2
            1- Siteye gidiniz
            2- Specials tiklayiniz
            3- Cikan urun sayisi ile indirimli urun sayisi ayni mi dogrulayiniz */

public class _02_Specials extends MetodDriver{

    @Test
    public void specials(){

        // Special Bölümü (en altta)
        WebElement specialsLink = driver.findElement(By.linkText("Specials"));
        specialsLink.click();

        // Fiyatların indirim yapıldığının kontrolünü yaptık
        List<WebElement> oldAmount = driver.findElements(By.cssSelector("span.price-old")); // fiyatlar List
        List<WebElement> items = driver.findElements(By.cssSelector("div.product-thumb"));  // ürünler List

        Assert.assertTrue(oldAmount.size() == items.size()); // ürün ve fiyatlar eşit olmalı

    }
}
