package Gun06;

import Utils.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*TODO
        Senaryo
        1-Siteyi açınız
        2-mac kelimelerini göndererek aratınız
        3-Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız
        NOT: bu testi firefox driver ile yapınız....     */

import java.util.List;

public class _04_SearchFunctionality extends ParameterDriver {  // browser --> Chrome ve Frifox ikisi içinde kullanılabilir Method

    @Test
    @Parameters("arananKelime")
    public void SearchFunction(String searchText){

//        String searchText = "mac";

        WebElement searchInput = driver.findElement(By.cssSelector("input.form-control.input-lg"));
        searchInput.sendKeys(searchText);

        WebElement searchButton = driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg"));
        searchButton.click();

        List<WebElement> itemNameList = driver.findElements(By.cssSelector("div.caption>h4"));

        for (WebElement itemName: itemNameList) {

            System.out.println(itemName.getText());
            Assert.assertTrue(itemName.getText().toLowerCase().contains(searchText.toLowerCase()));
        }

    }
}
