package POM_ileYapildi.Ders2;

import POM_ileYapildi.Elements;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestimD extends POM_ileYapildi._myMethods.ParameterDriverim{

    @Test
    @Parameters("enquiry")
    public void Test1(String enquiry){  // ----> ÖNEMLİ NOT!!! Test1  xml ile çalıştırabiliriz
        Elements elements = new Elements(driver);
        elements.contactUsLink.click();
        elements.enquiryInput.sendKeys(enquiry);
        elements.submitButton.click();
        Assert.assertTrue(elements.contactUsMessage.getText().toLowerCase().contains("successfully"));
    }

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