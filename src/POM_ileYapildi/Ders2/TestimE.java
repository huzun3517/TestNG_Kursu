package POM_ileYapildi.Ders2;

import POM_ileYapildi.Elements;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestimE extends POM_ileYapildi._myMethods.ParameterDriverim{

    @Test
    public void Test2(){
        Elements elements = new Elements(driver);
        elements.specialsLink.click();
        Assert.assertTrue(elements.oldAmount.size()==elements.itemNameList.size());
    }

    @Test
    @Parameters("arananKelime")
    public void Test3(String searchText){
        Elements elements = new Elements(driver);
        elements.searchInput.sendKeys(searchText);
        elements.searchButton.click();

        for (WebElement itemName: elements.itemNameList){
            System.out.println(itemName.getText());
            Assert.assertTrue(itemName.getText().toLowerCase().contains(searchText));
        }
    }
}