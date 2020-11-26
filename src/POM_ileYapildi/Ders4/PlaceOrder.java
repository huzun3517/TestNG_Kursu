package POM_ileYapildi.Ders4;
import POM_ileYapildi.Elements;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrder extends POM_ileYapildi._myMethods.MethodDriverim {

    @Test
    public void ProceedToCheckout(){
        Elements elements = new Elements(driver);
        elements.searchInput.sendKeys("ipod");
        elements.searchButton.click();
        elements.addToCartList.get(0).click();
        elements.shoppingCart.click();
        elements.checkoutButton.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(elements.continu1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continu2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continu3)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continu4)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.checkBox)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continu5)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.confirmButton)).click();
        wait.until(ExpectedConditions.urlContains("success"));
        Assert.assertEquals(elements.shoppingCartMessage.getText(),"Your order has been placed!");
    }
}