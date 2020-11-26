package POM_ileYapildi.Ders5;

import POM_ileYapildi.Elements;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class pom extends POM_ileYapildi._myMethods.ParameterDriverim {

    @Test
    @Parameters("itemName")
    public void addToWishList(String itemName) {

        Elements elements = new Elements(driver);
        elements.searchInput.sendKeys(itemName);
        elements.searchButton.click();
        int rundNummer = RandomNumberGenerator(elements.itemNameList.size());
        String wischItemName = elements.itemNameList.get(rundNummer).getText();
        elements.addToWishList.get(rundNummer).click();
        elements.wischListLink.click();

        ListContainsString(elements.myWishList,wischItemName);


    }

    public static int RandomNumberGenerator(int max) {
        Random rnd = new Random();
        int RandomMumber = rnd.nextInt(max);
        return RandomMumber;
    }

    public static void ListContainsString(List<WebElement> menuActualList, String expectedString){
        boolean bulundu=false;
        for(WebElement el: menuActualList){
            if (el.getText().contains(expectedString)) {
                bulundu = true;
                break;
            }
        }

        Assert.assertTrue( bulundu, "aranan eleman bulunamadı");
    }
}
