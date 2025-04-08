package tests;

import baseClass.BaseTest;
import locators.Locatori;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAdaugareShopInCos extends BaseTest {

    @Test
    public void testAdaugareShopInCos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 0. Pagina principală încărcată din BaseTest
        System.out.println("✅ Pagina principală încărcată.");
        sleep();

        // Scroll vizibil pe homepage
        js.executeScript("window.scrollBy(0, 300);");
        System.out.println("👀 Scroll ușor pe pagina principală.");
        sleep();

        // 1. Click pe Shop
        WebElement shopButton = wait.until(ExpectedConditions.elementToBeClickable(Locatori.SHOP_BUTTON));
        shopButton.click();
        System.out.println("🛍️ Am intrat în Shop.");
        sleep();

        // 2. Scroll până la butonul Add to Cart
        try {
            WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(Locatori.ADD_TO_CART_BUTTON));
            sleep(); // așteptăm puțin înainte de scroll
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", addToCartButton);
            System.out.println("🔽 Scroll până la butonul Add to cart.");
        } catch (Exception e) {
            System.out.println("⚠️ Nu am putut face scroll până la Add to Cart. Continuăm oricum...");
        }

        sleep();

        // 3. Click pe Add to cart
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(Locatori.ADD_TO_CART_BUTTON));
        addToCartButton.click();
        System.out.println("🛒 Am dat click pe 'Add to cart'.");
        sleep();

        // 4. Click pe View Cart
        WebElement viewCartButton = wait.until(ExpectedConditions.elementToBeClickable(Locatori.VIEW_CART_BUTTON));
        viewCartButton.click();
        System.out.println("➡️ Am dat click pe 'View Cart'.");
        sleep();

        // 5. Verificare cantitate în coș
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Locatori.QUANTITY_INPUT));
        String valoare = quantityInput.getAttribute("value");
        System.out.println("🔍 Cantitate în coș: " + valoare);
        sleep();

        // 6. Scroll până la produsul din coș
        WebElement productName = wait.until(ExpectedConditions.visibilityOfElementLocated(Locatori.PRODUCT_NAME));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", productName);
        System.out.println("👁️ Am scrollat până la produsul din coș.");
        sleep();

        System.out.println("✅ Testul s-a încheiat cu succes.");
    }

    private void sleep() {
        try {
            Thread.sleep(3000); // Pauză pentru vizualizare
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}