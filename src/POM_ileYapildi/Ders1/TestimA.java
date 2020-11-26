package POM_ileYapildi.Ders1;

import POM_ileYapildi.Elements;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestimA extends POM_ileYapildi._myMethods.MethodDriverim {

    @Test
    public void Test1(){

        String title = driver.getTitle();

        Assert.assertEquals(title,"My Account","login yapılamadı...");

        System.out.println("Login başarı ile gerçekleşmiştir...");
    }


    @Test
    public  void Test2(){

        Elements elements = new Elements(driver);

        List<String> menuExpectedList=new ArrayList<>();

        menuExpectedList.add("Desktops");
        menuExpectedList.add("Laptops & Notebooks");
        menuExpectedList.add("Components");
        menuExpectedList.add("Tablets");
        menuExpectedList.add("Software");
        menuExpectedList.add("Phones & PDAs");
        menuExpectedList.add("Cameras");
        menuExpectedList.add("MP3 Players");

        int i =0;

        for (WebElement m: elements.menuActualList){

            Assert.assertEquals(m.getText(),menuExpectedList.get(i++));
        }

        System.out.println("Top menüdeki elemanlar doğrulandı...");
    }

    @Test
    public void Test3(){

        Elements elements = new Elements(driver);
        elements.subscribeButton.click();
        elements.yesRadioButton.click();
        elements.continueButton.click();

        Assert.assertTrue(elements.newsletterMessage.getText().contains("uccess"));
    }

    @Test
    public void Test4(){

        Elements elements = new Elements(driver);
        elements.subscribeButton.click();
        elements.noRadioButton.click();
        elements.continueButton.click();

        Assert.assertTrue(elements.newsletterMessage.getText().contains("uccess"));
    }

    @Test
    public void Test5(){

        Elements elements = new Elements(driver);
        elements.subscribeButton.click();

        if (elements.yesRadioButton.isSelected())
            elements.noRadioButton.click();

        else
            elements.yesRadioButton.click();

        elements.continueButton.click();

        Assert.assertTrue(elements.newsletterMessage.getText().contains("uccess"));
    }

    @Test
    public void Test6(){
        Elements elements = new Elements(driver);
        AccountEdit("Hüseyin","U");
        AccountEdit("Ömer Faruk","U");
    }

    String oldName = "";
    String oldLastName = "";
    String neuName = "";
    String neuLastName = "";

    void AccountEdit(String name, String lastName){
        Elements elements = new Elements(driver);
        elements.editAccount.click();
        oldName = elements.firstName.getAttribute("value");
        elements.firstName.clear();
        elements.firstName.sendKeys(name);
        neuName = elements.firstName.getAttribute("value");

        oldLastName = elements.lastName.getAttribute("value");
        elements.lastName.clear();
        elements.lastName.sendKeys(lastName);
        neuLastName = elements.lastName.getAttribute("value");
        elements.continueButton.click();

        Assert.assertFalse(oldName == neuName);
        System.out.println("Eski ismin değiştiği doğrulandı...");

        Assert.assertFalse(oldLastName == neuLastName);
        System.out.println("Eski soyismin değiştiği doğrulandı...");
    }
}