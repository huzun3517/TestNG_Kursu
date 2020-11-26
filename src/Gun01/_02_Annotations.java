package Gun01;

import org.testng.annotations.*;

public class _02_Annotations {

/*TODO
            @BeforeClass        --> Her Class dan önce çalışacaklar buraya yazılıyor
                @BeforeMethod   --> Her method çalışmadan önce yapılacakları buraya yazıyoruz.
                    @Test       --> testimiz
                    @Test       --> testimiz2
                @AfterMethod    --> Her method çalıştıktan sonra yapılacakları buraya yazıyoruz
            @AfterClass         --> Her Class dan sonra yapılacaklar buraya yazılıyor.
*/

    @BeforeClass
    void beforeClass() {
        System.out.println("Class dan önce çalışacak : Before Class");
    }

    @AfterClass
    void afterClass() {
        System.out.println("Class dan sonra çalışacak : After Class");
    }

    @BeforeMethod
    void beforeMetod() {
        System.out.println("Her methoddan önce çalışacak : Before Method");
    }

    @AfterMethod
    void afterMetod() {
        System.out.println("Her methoddan sonra çalışacak : After Method");
    }

    @Test
    void Test1(){
        System.out.println("Burası Birinci Test");
    }

    @Test
    void Test2(){
        System.out.println("Burası İkinci Test");
    }
}