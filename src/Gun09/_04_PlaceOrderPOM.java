package Gun09;

import Utils.MetodDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


/* TODO
          POM (Page Object Model) avantajları
       1- Bütün sayfalada isimleri aynı olan elemanlar için 1 tanımlama yeterli oluyor.
          Böylece tanımlanan elemanlar tekrar kullanılabilir yani Reusable oluyor.
       2- Kodun içerisinden HTML kodları ayrıldığından kod okunabilirliği artıyor.
       3- Developer locatorlarda bir değişiklik yaptığı zaman, asıl kodla hiç bir şekilde
          uğraşmak zorunda kalmıyoruz, sadece gidip locator ı değiştiriyoruz.*/

public class _04_PlaceOrderPOM extends MetodDriver {

    @Test
    public void ProceedToCheckout() {

        _03_PlaceOrderElements placeOrderElements=new _03_PlaceOrderElements(driver);

        placeOrderElements.searchInput.sendKeys("ipod");
        placeOrderElements.searchButton.click();
        placeOrderElements.item1.click();
        placeOrderElements.shoppingChart.click();
        placeOrderElements.checkOut.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(placeOrderElements.continu1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderElements.continu2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderElements.continu3)).click();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderElements.continu4)).click();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderElements.checkBox)).click();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderElements.continu5)).click();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderElements.confirmButton)).click();

        wait.until(ExpectedConditions.urlContains("success"));

        Assert.assertEquals(placeOrderElements.mesaj.getText(), "Your order has been placed!");
    }
}