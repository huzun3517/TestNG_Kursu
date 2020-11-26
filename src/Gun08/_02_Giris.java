package Gun08;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_Giris {

    @Test(dataProvider = "getData")
    public void LoginTest(String username, String password){

        System.out.println(username + " " + password);
    }


    @DataProvider
    public Object[][] getData(){

        Object[][] data = {
                {"ahmet","abc"},
                {"ayşe","xyz"},
                {"mehmet","bcd"}
        };
        return data;
    }
}
