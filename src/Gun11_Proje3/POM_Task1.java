package Gun11_Proje3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class POM_Task1 extends Proje_MetodDriver {

    @Test
    public void contacUs(){

        ProjeElements projeElements = new ProjeElements(driver);

        projeElements.contactUsButton.click();
        projeElements.name.clear();
        projeElements.name.sendKeys("Grup5");
        projeElements.enquiry.sendKeys("Merhaba");
        projeElements.submitButton.click();
        Assert.assertTrue(projeElements.message.isDisplayed());

/*
        WebElement contactUsButton = driver.findElement(By.linkText("Contact us"));
        contactUsBtn.click();

        WebElement name = driver.findElement(By.id("FullName"));
        name.clear();
        name.sendKeys("Hüseyin");

        WebElement enquiry = driver.findElement(By.id("Enquiry"));
        enquiry.sendKeys("Merhaba");

        WebElement submitButton = driver.findElement(By.cssSelector("input.button-1.contact-us-button"));
        submitButton.click();

        WebElement message = driver.findElement(By.cssSelector("div.result"));

        Assert.assertTrue(message.isDisplayed());

 */


    }
}
