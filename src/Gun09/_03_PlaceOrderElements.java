package Gun09;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//TODO
// Bu sayfadaki bütün elemenalrın driverlar bağlantısı gerekiyor
// bunun için aşağıdaki consructor eklendi ve için PageFatory ile
// driver üzerinden bu (this) sayfadaki bütün elemnalar ilşkilendirildi.
// Böylece Sayfada dan nesne türetildiği zaman değil, kullanıldığı
// anda elemanların bulunması aktif oluyor.Bu yöntemle bütün sayfalarda
// aynı isimde elemanlar var ise buradaki tanımlama hepsi için geçerli hale
// gelmiş oluyor. Bu yapıya Page Object Model (POM) adı veriliyor.

public class _03_PlaceOrderElements{

    public _03_PlaceOrderElements(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[name='search']")
    public WebElement searchInput;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    public WebElement searchButton;

    @FindBy(xpath = "(//span[text()='Add to Cart'])[1]")
    public WebElement item1;

    @FindBy(xpath = "//span[text()='Shopping Cart']")
    public WebElement shoppingChart;

    @FindBy(linkText = "Checkout")
    public WebElement checkOut;

    @FindBy(id ="button-payment-address")
    public WebElement continu1;

    @FindBy(id ="button-shipping-address")
    public WebElement continu2;

    @FindBy(id ="collapse-shipping-address")
    public WebElement continu3;

    @FindBy(id ="button-shipping-method")
    public WebElement continu4;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBox;

    @FindBy(id ="button-payment-method")
    public WebElement continu5;

    @FindBy(id ="button-confirm")
    public WebElement confirmButton;

    @FindBy(xpath = "//div[@id='content']/h1")
    public WebElement mesaj;

}
