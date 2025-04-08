package tests;

import baseClass.BaseTest;
import locators.Locatori;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestRedirectionareShop extends BaseTest {

    @Test
    public void redirectionareCatreShop() {
        System.out.println("[START] Test de redirecționare către pagina Shop...");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        System.out.println("[INFO] Așteptăm butonul 'Shop' să fie clicabil...");
        WebElement shopButton = wait.until(ExpectedConditions.elementToBeClickable(Locatori.SHOP_BUTTON));

        System.out.println("[OK] Click pe butonul 'Shop'!");
        shopButton.click();

        System.out.println("[INFO] Așteptăm ca titlul paginii Shop să se încarce...");
        wait.until(ExpectedConditions.titleContains("Shop"));

        String expectedUrl = "https://pabllo.ro/wp/shop/";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("[VERIFY] URL actual: " + actualUrl);

        assert actualUrl.equals(expectedUrl) : "Redirecționarea către Shop a eșuat!";

        System.out.println("[SUCCESS] Am fost redirecționați corect către pagina Shop!");
    }
}
