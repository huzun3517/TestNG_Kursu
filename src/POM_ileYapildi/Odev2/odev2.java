package POM_ileYapildi.Odev2;

import POM_ileYapildi.Elements;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class odev2 extends POM_ileYapildi._myMethods.MethodDriverim {

    @Test(dataProvider = "getData")
    public void contactUs(String enquiry){

        Elements elements = new Elements(driver);
        elements.contactUsLink.click();
        elements.enquiryInput.clear();
        elements.enquiryInput.sendKeys(enquiry);
        elements.submitButton.click();
        Assert.assertTrue(elements.contactUsMessage.getText().toLowerCase().contains("successfully"));
    }

    @DataProvider
    public Object[] getData(){

        Object[] data = {"Yeni Tester lar geliyor...","Piyasa bizi bekliyor...","Ümidi yitirmek yok..."};

        return data;
    }
}