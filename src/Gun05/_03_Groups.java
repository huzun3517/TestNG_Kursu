package Gun05;

import org.testng.annotations.Test;

public class _03_Groups {

    @Test(groups = "Regression")
    public void Test1() {System.out.println("Test1 Regression");}

    @Test(groups = "Regression")
    public void Test2() {System.out.println("Test2 Regression");}

    @Test(groups = "Regression")
    public void Test7() {System.out.println("Test7 Regression");}

    @Test(groups = "Regression")
    public void Test5() {System.out.println("Test5 Regression");}

    //Smoke Test ise sistemin en genel haliyle çalışırlılığının testi
    @Test(groups = "SmokeTest")
    public void Test3() {System.out.println("Test3 SmokeTest");}

    @Test(groups = "SmokeTest")
    public void Test4() {System.out.println("Test4 SmokeTest");}

    @Test
    public void Test6() {System.out.println("Test6");}
    // Grup olarak çalıştırıldığında herhangi bir drubu olmayanlar çalışmazlar
}
