package Gun04;

import Utils.MetodDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

/*TODO
          Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son eklenen adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son eklenen adresi siliniz.*/

public class _02_AdressFunctionality extends MetodDriver {

    @Test
    void AddAddress() throws InterruptedException {

        WebElement adressBookButton = driver.findElement(By.xpath("//a[text()='Address Book']"));
        adressBookButton.click();

        WebElement newAdressButton = driver.findElement(By.cssSelector("a.btn.btn-primary"));
        newAdressButton.click();

        WebElement firstName = driver.findElement(By.cssSelector("input#input-firstname"));
        firstName.sendKeys("Hüseyin");

        WebElement lastName = driver.findElement(By.cssSelector("input#input-lastname"));
        lastName.sendKeys("U");

        WebElement company = driver.findElement(By.cssSelector("input#input-company"));
        company.sendKeys("TechnoStudy");

        WebElement adress1 = driver.findElement(By.cssSelector("input#input-address-1"));
        adress1.sendKeys("Kasseler Str");

        WebElement city = driver.findElement(By.cssSelector("input#input-city"));
        city.sendKeys("Erfurt");

        WebElement postCode = driver.findElement(By.cssSelector("input#input-postcode"));
        postCode.sendKeys("88089");

        //COUNTRY SEÇİMİ METHODLA RANDOM OLARAK YAPILDI. 0. İNDEX İN SEÇİLMEMESİ YAPILDI
        WebElement selectCountry = driver.findElement(By.cssSelector("select#input-country"));
        Tools.selectByIndex(selectCountry);

        // BEKLETME YAPTIK. ÇÜNKÜ COUNTRY SEÇİLDİKTEN SONRA STATE NİN OPTİONSLARI YUKLENENE KADAR BEKLETİYOR
        WebDriverWait bekle=new WebDriverWait(driver, 10);

        By stateOptions = By.cssSelector("select#input-zone>option");
        bekle.until(ExpectedConditions.numberOfElementsToBeMoreThan(stateOptions,1));

        Thread.sleep(1000);

        WebElement selectState = driver.findElement(By.cssSelector("select#input-zone"));
        Tools.selectByIndex(selectState);

        WebElement defaultAdress = driver.findElement(By.xpath("(//input[@name='default'])[2]"));
        defaultAdress.click();

        WebElement continueButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        continueButton.click();

        Tools.successMessageValidation(driver);
    }

    @Test(dependsOnMethods = {"AddAddress"})
    void EditAdress() {

        WebElement AdressBookButton = driver.findElement(By.linkText("Address Book"));
        AdressBookButton.click();

        //Bütün butonları
        List<WebElement> editBtns = driver.findElements(By.xpath("//a[text()='Edit']"));
        editBtns.get(editBtns.size()-1).click();

        WebElement firstName = driver.findElement(By.cssSelector("input#input-firstname"));
        firstName.clear();
        firstName.sendKeys("Senay");

        WebElement lastName = driver.findElement(By.cssSelector("input#input-lastname"));
        lastName.clear();
        lastName.sendKeys("U");

        WebElement defaultAdress = driver.findElement(By.xpath("(//input[@name='default'])[2]"));
        defaultAdress.click();

        WebElement continueButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        continueButton.click();

        Tools.successMessageValidation(driver);


    }

    @Test(dependsOnMethods = {"EditAdress"})
    void DeleteAdress() {

        WebElement AdressBookButton = driver.findElement(By.linkText("Address Book"));
        AdressBookButton.click();

        //Bütün delete butonları
        List<WebElement> deleteBtns = driver.findElements(By.xpath("//a[text()='Delete']"));
        deleteBtns.get(deleteBtns.size()-1).click(); // sunucuya tıklandı

        Tools.successMessageValidation(driver);
    }
}
