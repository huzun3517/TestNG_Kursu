package Gun04;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {

    @Test
    void startCar() {

        System.out.println("Car started");
        Assert.fail(); // hata oluşur

    }

    @Test(dependsOnMethods ={"startCar"}) // bu testin çalışması, startCar ın hatasız çalışmasına bağımlı
    void driveCar() {

        System.out.println("Car drive");

    }

    @Test(dependsOnMethods ={"driveCar"})// bu testin çalışması, driveCar ın hatasız çalışmasına bağımlı
    void stopCar() {

        System.out.println("Car stop");

    }

    @Test(dependsOnMethods ={"stopCar","driveCar"}, alwaysRun = true) // alwaysRun = true --> bağımlılıkları var ama hata çıkarsa da yine çalıştır
    void parkCar() {

        System.out.println("Car parkCar");

    }
}
