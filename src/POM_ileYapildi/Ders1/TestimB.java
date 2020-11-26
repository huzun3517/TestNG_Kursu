package POM_ileYapildi.Ders1;

import POM_ileYapildi.Elements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class TestimB extends POM_ileYapildi._myMethods.MethodDriverim {

    @Test
    public void Test1() throws InterruptedException {

        Elements elements = new Elements(driver);
        elements.adressBookButton.click();
        elements.newAdressButton.click();
        elements.firstName.sendKeys("Senay");
        elements.lastName.sendKeys("Sen");
        elements.company.sendKeys("TechnoStudy");
        elements.adress1.sendKeys("Kasseler Str");
        elements.city.sendKeys("Erfurt");
        elements.postCode.sendKeys("88089");
        selectByIndex(elements.selectCountry);

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeSelected(elements.stateOptions));
        Thread.sleep(3000);

        selectByIndex(elements.selectState);
        elements.defaultAdress.click();
        elements.continueButton.click();
        Assert.assertTrue(elements.addressBookMessage.getText().contains("uccess"));
    }

    @Test
    public void Test2(){
    Elements elements = new Elements(driver);
    elements.adressBookButton.click();
    elements.editButtons.get(elements.editButtons.size()-1).click();
    elements.firstName.clear();
    elements.firstName.sendKeys("Faruk");
    elements.lastName.clear();
    elements.lastName.sendKeys("U");
    elements.defaultAdress.click();
    elements.continueButton.click();
    Assert.assertTrue(elements.addressBookMessage.getText().contains("uccess"));
    }

    @Test
    public void Test3(){
    Elements elements = new Elements(driver);
    elements.adressBookButton.click();
    elements.deleteButtons.get(elements.deleteButtons.size()-1).click();
    Assert.assertTrue(elements.addressBookMessage.getText().contains("uccess"));
    }



    public static int RandomNummer(int max){
        Random rnd = new Random();

        int randomNumber = rnd.nextInt(max-1) +1;
        return randomNumber;
    }

    public static void selectByIndex(WebElement dropDownName) {

        Select dropDownListSelect = new Select(dropDownName);
        dropDownListSelect.selectByIndex(RandomNummer(dropDownListSelect.getOptions().size()));

    }
}
