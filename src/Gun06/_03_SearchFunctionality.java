package Gun06;

import Utils.MetodDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

 /*TODO
        Senaryo
        1-Siteyi açınız
        2-mac kelimelerini göndererek aratınız
        3-Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız     */

public class _03_SearchFunctionality extends MetodDriver{ // browser --> sadece Chrome için olan Class

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
            Assert.assertTrue(itemName.getText().toLowerCase().contains(searchText));
        }
    }
}
