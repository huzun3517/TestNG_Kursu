package Gun08;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _03_Giris {

    @Test(dataProvider = "getData")
    public void LoginTest(String username){

        System.out.println(username);
    }


    @DataProvider
    public Iterator<Object> getData(){

        List<Object> data = new ArrayList<>();
        data.add("Ahmet");
        data.add("Ayşe");
        data.add("Ali");
        data.add("Fatma");

        return data.iterator();
    }

    /********************************** 2 Boyutlu *************************************/

    @Test(dataProvider = "getData2")
    public void LoginTest2(String username,String password){

        System.out.println(username + " " + password);
    }


    @DataProvider
    public Iterator<Object[]> getData2(){

        List<Object[]> data = new ArrayList<>(); // List in her bir elemanı Object dizi olduğu için Object dizisi eklendi
        data.add(new Object[]{"Ali","xyz"});
        data.add(new Object[]{"Mehmet","abc"});
        data.add(new Object[]{"Ayşe","bcd"});

        return data.iterator();
    }
}
