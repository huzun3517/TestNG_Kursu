package Gun10;

import Gun09._03_PlaceOrderElements;
import Utils.ParameterDriver;
import Utils.Tools;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _03_WishListPOM extends ParameterDriver {

    @Test
            @Parameters("itemName")
            public void addToWishList(String itemName) {


        Gun09._03_PlaceOrderElements pacePlaceOrderElements = new _03_PlaceOrderElements(driver);
        _02_WishListElements wishListElements = new _02_WishListElements(driver);

        pacePlaceOrderElements.searchInput.sendKeys(itemName);
        pacePlaceOrderElements.searchButton.click();

        int Rundnummer = Tools.RandomNumberGenerator(wishListElements.pruductList.size()); // random bir numara oluşturduk

        String wishItemName = wishListElements.pruductList.get(Rundnummer).getText(); // bu oluşan numaradaki ürünün adını aldık.
        wishListElements.searchResultWishList.get(Rundnummer).click(); // çıkan bu listedekki WishListlerin aynı random numarakini tıklattım.
        wishListElements.wishListLink.click();
        Tools.ListContainsString(wishListElements.tableNames,wishItemName);
    }

/*
    @Test
    public void Test1(){
        System.out.println("Merhaba Dünya");
        Assert.fail();
    }

 */
}
