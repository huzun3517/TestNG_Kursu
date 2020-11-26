package Gun08;

import Utils.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//    Ödev1- _04_Task1   deki testi ParameterDriver ile yapınız.

 /*TODO
        Senaryo
        1-Siteyi açınız
        2-Mac ve Samsung için Dataprovider ile yapınız.
        3-Çıkan sonuçlarda Mac ve Samsung kelimelerinin geçtiğini doğrulayınız
        NOT: bu testi firefox driver ile yapınız.... */

import java.util.List;

public class _05_Odev1 extends ParameterDriver {  // browser --> Chrome ve Frifox ikisi içinde kullanılabilir Method

    @Test(dataProvider = "getData")
    public void SearchFunction(String searchText){

        WebElement searchInput = driver.findElement(By.cssSelector("input.form-control.input-lg"));
        searchInput.clear();
        searchInput.sendKeys(searchText);

        WebElement searchButton = driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg"));
        searchButton.click();

        List<WebElement> itemNameList = driver.findElements(By.cssSelector("div.caption>h4"));

        for (WebElement itemName: itemNameList) {

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
