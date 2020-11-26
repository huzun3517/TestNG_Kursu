package Gun05;

import org.testng.annotations.*;

public class _01_Intro {

/*     @BeforeSuite
        @BeforeTest
            @BeforeGroups
                @BeforeClass
                    @BeforeMethod
                        @Test
                        @Test
                    @AfterMethod
                @AfterClass
            @AfterGroups
        @AfterTest
    @AfterSuite
*/

    @BeforeSuite
    public void bSuite(){System.out.println("Before Suit");}

    @BeforeTest
    public void bTest() {System.out.println("Before Test");}

    @BeforeGroups
    public void bGroups() {System.out.println("Before Groups");}

    @BeforeClass
    public void bClass() {System.out.println("Before Class");}

    @BeforeMethod
    public void bMethod() {System.out.println("Before Method");}

    @Test
    public void TestIntro1() {System.out.println("Test 1");}

    @Test
    public void TestIntro2() {System.out.println("Test 2");}

    @AfterMethod
    public void aMethod() {System.out.println("After Method");}

    @AfterClass
    public void aClass() {System.out.println("After Class");}

    @AfterGroups
    public void aGroups() {System.out.println("After Groups");}

    @AfterTest
    public void aTest() {System.out.println("After Test");}

    @AfterSuite
    public void aSuite(){System.out.println("After Suit");}
}

