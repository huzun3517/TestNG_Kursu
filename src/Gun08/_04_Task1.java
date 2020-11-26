package Gun08;

import Utils.MetodDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*  Senaryo
    Daha önceki derslerde yaptığımız Search fonksiyonunu Mac ve Samsung için Dataprovider ile yapınız
    Fonksiyonu aynen kopyalayabilirsiniz. */

/*TODO
        Senaryo
        1-Siteyi açınız
        2-Mac ve Samsung için Dataprovider ile yapınız.
        3-Çıkan sonuçlarda Mac ve Samsung kelimelerinin geçtiğini doğrulayınız*/

import java.util.List;

public class _04_Task1 extends MetodDriver {

    @Test (dataProvider = "getData")
    public void searchFunctionality(String searchItem){

        WebElement searchInput = driver.findElement(By.cssSelector("input[name='search']"));
        searchInput.clear();
        searchInput.sendKeys(searchItem);

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> itemNamesList = driver.findElements(By.tagName("h4"));

        for(WebElement eachElement:itemNamesList){

            System.out.println(eachElement.getText());

            Assert.assertTrue(eachElement.getText().toLowerCase().contains(searchItem.toLowerCase()));
        }
    }

    @DataProvider
    public Object[] getData()
    {
        Object[] data={
                "Mac",
                "Samsung"
        };

        return data;
    }


}