package Gun11_Proje3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProjeElements {

    public ProjeElements(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
    // Task1
    @FindBy(linkText = "Contact us")
    public WebElement contactUsButton;

    @FindBy(id = "FullName")
    public WebElement name;

    @FindBy(id = "Enquiry")
    public WebElement enquiry;

    @FindBy(css = "input.button-1.contact-us-button")
    public WebElement submitButton;

    @FindBy(css = "div.result")
    public WebElement message;

    //***********************************************************************************

    //Task2
    @FindBy(linkText = "Apparel & Shoes")
    public WebElement apparelShoesLink;

    @FindBy(xpath = "//a[text()='Blue and green Sneaker']")
    public WebElement bluAndGreenLink;

    @FindBy(css = "div.product-name>h1")
    public WebElement bluAndGreenText;

    @FindBy(css = "input.button-2.add-to-wishlist-button")
    public WebElement wishlistAdd;

    @FindBy(xpath = "(//h2[@class='product-title']/a)[1]")
    public WebElement rockabillyLink;

    @FindBy(css = "div.product-name>h1")
    public WebElement rockabillyText;

    @FindBy(css = "input.button-2.add-to-wishlist-button")
    public WebElement wishlistAdd2;

    @FindBy(linkText = "Wishlist")
    public WebElement wishList;

    @FindAll(
            {
                    @FindBy(css = "td.product>a")

            }
    )
    public List<WebElement> wishListurunler;

}
