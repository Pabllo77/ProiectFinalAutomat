package locators;
import org.openqa.selenium.By;

public class Locatori {
    public static final By NUME_FIELD = By.name("Nume");
    public static final By EMAIL_FIELD = By.name("Fieldname"); // Verifică dacă este corect numele câmpului
    public static final By MESAJ_FIELD = By.name("Mesaj");
    public static final By TRIMITE_BUTTON = By.cssSelector("button.pagelayer-contact-submit-btn");
    public static final By SUCCESS_MESSAGE = By.xpath("//*[contains(text(),'Your message was sent successfully')]");

    // Locatori alternativi pentru ContactFormTest
    public static final By NUME_FIELD_ALT = By.cssSelector("input[placeholder='Nume'], input[name='Nume']");
    public static final By EMAIL_FIELD_ALT = By.cssSelector("input[placeholder='email'], input[name='email']");
    public static final By MESAJ_FIELD_ALT = By.cssSelector("textarea[placeholder='Mesaj'], textarea[name='Mesaj']");
    public static final By TRIMITE_BUTTON_ALT = By.xpath("//button/span[contains(text(), 'Trimite')]");

    // Locatori pentru butoane
    public static final By CURSURI_BUTTON = By.xpath("//a[span[@class='pagelayer-nav-menu-title' and text()='Cursuri']]");
    public static final By COMANDA_BUTTON = By.xpath("(//a[contains(text(), 'Comanda') and @href='https://pabllo.ro/wp/shop/'])[2]");

    // Locatori pentru Shop
    public static final By SHOP_BUTTON = By.xpath("//span[@class='pagelayer-nav-menu-title' and normalize-space()='Shop']");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//a[contains(@class, 'add_to_cart_button') and @data-product_id='381']");
    public static final By VIEW_CART_BUTTON = By.xpath("//a[@class='added_to_cart wc-forward']");
    public static final By QUANTITY_INPUT = By.xpath("//input[contains(@class, 'quantity-selector__input') and contains(@aria-label, 'Curs Basic')]");

    // Locatori pentru Cos
    public static final By COS_BUTTON = By.xpath("//a[.//span[normalize-space()='Cos']]");

    // Locatori pentru butonul de ștergere
    public static final By REMOVE_BUTTON = By.xpath("//button[@class='remove-item']");

    // Locatori noi pentru testul adăugat
    public static final By PRODUCT_NAME = By.xpath("//td[@class='wc-block-cart-item__product']//a[@class='wc-block-components-product-name']");
    public static final By INCREASE_QUANTITY_BUTTON = By.xpath("//button[contains(@aria-label, 'Increase quantity') and contains(@class, 'button--plus')]");
    public static final By ADD_TO_CART_BUTTON_NEW = By.xpath("(//a[contains(@class, 'add_to_cart_button') and contains(@aria-label, 'Curs Basic')])[1]");

    // stergere
    public static final By REMOVE_ITEM_BUTTON = By.xpath("//button[contains(@class, 'wc-block-cart-item__remove-link')]");

    // Locator pentru titlul "New in store" - doar selectorul
    public static final By NEW_IN_STORE_TITLE = By.xpath("//h2[@class='wp-block-heading has-text-align-center' and text()='New in store']");


    // Locator pentru butonul de acceptare a cookies
    public static final By ACCEPT_COOKIES_BUTTON = By.xpath("//button[.//span[text()='Accept']]");

    // Locator pentru butonul "Book Now"
    // Locator pentru butonul "Book Now"
    public static final By BOOK_NOW_BUTTON = By.xpath("//a[@id='Setmore_button_iframe']//img[@alt='Book an appointment with Personnel Calendar using SetMore']");

    public static final By CONTACT_MENU_BUTTON = By.xpath("//span[@class='pagelayer-nav-menu-title' and text()='Contact']");
    public static final By CONTACT_PAGE_FIELD_NAME = By.name("name");
    public static final By CONTACT_PAGE_FIELD_EMAIL = By.name("email");
    public static final By CONTACT_PAGE_FIELD_SUBJECT = By.name("subject");
    public static final By CONTACT_PAGE_FIELD_MESSAGE = By.name("message");
    public static final By CONTACT_SEND_BUTTON = By.xpath("//button[.//span[text()[contains(., 'Trimite')]]]");



}