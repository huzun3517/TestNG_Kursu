package POM_ileYapildi.Odev1;

import POM_ileYapildi.Elements;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class odev1 extends POM_ileYapildi._myMethods.ParameterDriverim {

    @Test(dataProvider = "getData")
    public void SearchFunction(String searchText){

        Elements elements = new Elements(driver);
        elements.searchInput.clear();
        elements.searchInput.sendKeys(searchText);
        elements.searchButton.click();

        for (WebElement itemName: elements.itemNameList){
            System.out.println(itemName.getText());
            Assert.assertTrue(itemName.getText().toLowerCase().contains(searchText.toLowerCase()));
        }
    }

    @DataProvider
    public Object[] getData(){

        Object[] data = {"Mac","Samsung"};

        return data;
    }
}