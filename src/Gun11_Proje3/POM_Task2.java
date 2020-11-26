package Gun11_Proje3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class POM_Task2 extends Proje_MetodDriver {

    @Test
    public void ApparelShoes() {

        ProjeElements projeElements = new ProjeElements(driver);

        List<String> ilkUrunler = new ArrayList<>();

        projeElements.apparelShoesLink.click();
        projeElements.bluAndGreenLink.click();
        ilkUrunler.add(projeElements.bluAndGreenText.getText());
        projeElements.wishlistAdd.click();
        driver.navigate().back();
        projeElements.rockabillyLink.click();
        ilkUrunler.add(projeElements.rockabillyText.getText());
        projeElements.wishlistAdd2.click();
        projeElements.wishList.click();

        List<WebElement> wishListurunler = projeElements.wishListurunler;

        int i =0;

        for (WebElement w: wishListurunler){

            Assert.assertEquals(w.getText(),ilkUrunler.get(i++));

        }

/*      for (int j = 0; j < wishListurunler.size(); j++) {
            Assert.assertEquals(wishListurunler.get(j).getText(), ilkUrunler.get(j));
            System.out.println(wishListurunler.get(j).getText() + " = " + ilkUrunler.get(j));
        }
*/






/*
        @Test
        public void ApparelShoes() {


            List<String> ilkUrunler = new ArrayList<>();

            WebElement apparelShoesLink = driver.findElement(By.linkText("Apparel & Shoes"));
            apparelShoesLink.click();

            WebElement bluAndGreenLink = driver.findElement(By.linkText("Blue and green Sneaker"));
            bluUndGreen.click();

            WebElement bluAndGreenText = driver.findElement(By.cssSelector("div.product-name>h1"));
            ilkUrunler.add(bluText.getText());

            WebElement wishlistAdd = driver.findElement(By.cssSelector("input.button-2.add-to-wishlist-button"));
            wishlistAdd.click();

            driver.navigate().back();  //aynı pencerede geri gitmek için kullanılır

            WebElement rockabillyLink = driver.findElement(By.xpath("(//h2[@class='product-title'])[1]"));
            rockabillyLink.click();

            WebElement rockabillyText = driver.findElement(By.cssSelector("div.product-name>h1"));

            ilkUrunler.add(rockabillyText.getText());

            WebElement wishlistAdd2 = driver.findElement(By.cssSelector("input.button-2.add-to-wishlist-button"));
            wishlistAdd2.click();

            WebElement wishList = driver.findElement(By.linkText("Wishlist"));
            wishList.click();

            List<WebElement> wishListurunler = driver.findElements(By.cssSelector("td.product>a"));

            for (int j = 0; j < wishListurunler.size(); j++) {
                Assert.assertEquals(wishListurunler.get(j).getText(), ilkUrunler.get(j));
                System.out.println(wishListurunler.get(j).getText() + " = " + ilkUrunler.get(j));
            }
        }
 */
    }
}