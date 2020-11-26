package Gun09;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertVsHardAssert {

    @Test
    public void hardAssert() {

        String s1 = "Merhaba";

        System.out.println("Hard Assert öncesi");

        Assert.assertEquals("Merhaba123",s1); // burada fail oldu

        System.out.println("Kod bitti."); // üst satırdaki hatadan dolayı bu satıra gelemiyor.
    }

    @Test
    public void softAssert(){

        String strHomePage = "www.facebook.com/homepage";
        String strCartPage = "www.facebook.com/cartpage";
        String strEditAccount = "www.facebook.com/editaccountpage";

        SoftAssert _softAssert = new SoftAssert();

        _softAssert.assertEquals("www.facebook.com/homepage",strHomePage);
        System.out.println("assert 1");

        _softAssert.assertEquals("www.facebook.com/profile",strCartPage); // Burda fail oluyor
        System.out.println("assert 2");

        _softAssert.assertEquals("www.facebook.com/setting",strEditAccount); //burda tekrar fail oluyor
        System.out.println("assert 3");

        _softAssert.assertAll(); // bütün assertleri aktif ediyor.

        System.out.println("kod bitişi"); // bu bölüm assertAll dan sonra olduğu için ve
                                         // assertlerinde fail olduğundan yukarıda program kesilir.

    }
}
