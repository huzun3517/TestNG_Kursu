package POM_ileYapildi.Ders3;

import POM_ileYapildi.Elements;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task extends POM_ileYapildi._myMethods.MethodDriverim {

    @Test(dataProvider = "searc")
    public void searchFunctionality(String searchItem){

        Elements elements = new Elements(driver);
        elements.searchInput.clear();
        elements.searchInput.sendKeys(searchItem);
        elements.searchButton.click();

        for (WebElement eachElement: elements.itemNameList){
            System.out.println(eachElement.getText());
            Assert.assertTrue(eachElement.getText().toLowerCase().contains(searchItem.toLowerCase()));
        }
    }

    @DataProvider(name = "searc")
    public Object[] getData(){

        Object[] data = {"Mac","Samsung"};

        return data;
    }
}