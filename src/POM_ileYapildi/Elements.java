package POM_ileYapildi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Elements {

    public Elements(WebDriver driver) {

        PageFactory.initElements(driver,this);
    }

    //TestimA

    @FindBy(css = "input#input-email")
    public WebElement email;

    @FindBy(css = "input#input-password")
    public WebElement password;

    @FindBy(css = "input.btn.btn-primary")
    public  WebElement loginButton;

    @FindBy(css = "button#details-button")
    public WebElement gelismisButton;

    @FindBy(css = "a#proceed-link")
    public WebElement next;

    @FindAll( {
              @FindBy(css = "ul.nav.navbar-nav>li>a")
              }
    )
    public List<WebElement> menuActualList;

    @FindBy(linkText = "Subscribe / unsubscribe to newsletter")
    public WebElement subscribeButton;

    @FindBy(xpath = "//input[@name='newsletter']")
    public WebElement yesRadioButton;

    @FindBy(xpath = "(//input[@name='newsletter'])[2]")
    public WebElement noRadioButton;

    @FindBy(css = "input.btn.btn-primary")
    public WebElement continueButton;

    @FindBy(css = "div.alert.alert-success")
    public WebElement newsletterMessage;

    @FindBy(css = "div.alert.alert-success")
    public WebElement addressBookMessage;

    @FindBy(xpath = "//a[text()='Edit Account']")
    public WebElement editAccount;

    @FindBy(css = "input#input-firstname")
    public WebElement firstName;

    @FindBy(css = "input#input-lastname")
    public WebElement lastName;

    /*************************************************************************/
     //TestimB

     @FindBy(xpath = "//a[text()='Address Book']")
     public WebElement adressBookButton;

    @FindBy(css = "a.btn.btn-primary")
    public WebElement newAdressButton;

    @FindBy(css = "input#input-company")
    public WebElement company;

    @FindBy(css = "input#input-address-1")
    public WebElement adress1;

    @FindBy(css = "input#input-city")
    public WebElement city;

    @FindBy(css = "input#input-postcode")
    public WebElement postCode;

    @FindBy(css = "select#input-country")
    public WebElement selectCountry;

    @FindBy(css = "select#input-zone>option")
    public WebElement stateOptions;

    @FindBy(css = "select#input-zone")
    public WebElement selectState;

    @FindBy(xpath = "(//input[@name='default'])[2]")
    public WebElement defaultAdress;

    @FindAll({
            @FindBy(xpath = "//a[text()='Edit']")
    })
    public List<WebElement>editButtons;

    @FindAll({
            @FindBy(xpath = "//a[text()='Delete']")
    })
    public List<WebElement>deleteButtons;

    /*************************************************************************/
    //Testim C-D-E

    @FindBy(linkText = "Contact Us")
    public WebElement contactUsLink;

    @FindBy(css = "textarea#input-enquiry")
    public WebElement enquiryInput;

    @FindBy(css = "input.btn.btn-primary")
    public WebElement submitButton;

    @FindBy(css = "div#content>p")
    public WebElement contactUsMessage;

    @FindBy(linkText = "Specials")
    public WebElement specialsLink;

    @FindAll({
            @FindBy(css = "span.price-old")
    })
    public List<WebElement>oldAmount;

    @FindAll({
            @FindBy(css = "div.caption>h4")
    })
    public List<WebElement>itemNameList;

    @FindBy(css = "input.form-control.input-lg")
    public WebElement searchInput;

    @FindBy(css = "button.btn.btn-default.btn-lg")
    public WebElement searchButton;

    @FindAll({
            @FindBy(xpath = "//span[text()='Add to Cart']")
    })
    public List<WebElement>addToCartList;

    @FindBy(xpath = "//span[text()='Shopping Cart']")
    public WebElement shoppingCart;

    @FindBy(linkText = "Checkout")
    public WebElement checkoutButton;

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
    public WebElement shoppingCartMessage;

    @FindAll({
            @FindBy(css = "button[data-original-title='Add to Wish List']")
    })
    public List<WebElement>addToWishList;

    @FindBy(id = "wishlist-total")
    public WebElement wischListLink;

    @FindAll({
            @FindBy(xpath = "//table[@class='table table-bordered table-hover']//tbody//td[2]")
    })
    public List<WebElement> myWishList;










}
