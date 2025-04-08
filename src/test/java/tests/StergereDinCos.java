package tests;

import baseClass.BaseTest;
import locators.Locatori;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class StergereDinCos extends BaseTest {

    @Test
    public void testStergereProdusDinCos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        System.out.println("✅ Pagina principală încărcată.");
        sleep();

        // Click pe Cos
        WebElement cosButton = wait.until(ExpectedConditions.elementToBeClickable(Locatori.COS_BUTTON));
        cosButton.click();
        System.out.println("🛒 Am dat click pe 'Cos'.");
        sleep();

        // Scroll la 'New in store'
        WebElement newInStore = wait.until(ExpectedConditions.visibilityOfElementLocated(Locatori.NEW_IN_STORE_TITLE));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", newInStore);
        System.out.println("🔽 Scroll la 'New in store'.");
        sleep();

        // Adăugare produs în coș
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(Locatori.ADD_TO_CART_BUTTON_NEW));
        addToCartButton.click();
        System.out.println("🧺 Am adăugat produsul în coș.");
        sleep();

        // Creștem cantitatea până la 5
        for (int i = 0; i < 4; i++) {
            WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(Locatori.INCREASE_QUANTITY_BUTTON));
            plusButton.click();
            System.out.println("➕ Cantitatea crescută la " + (i + 2));
            sleep();
        }

        // Verificăm că e 5
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Locatori.QUANTITY_INPUT));
        String valoare = quantityInput.getAttribute("value");
        System.out.println("🔍 Cantitate în coș înainte de ștergere: " + valoare);
        Assert.assertEquals(valoare, "5");

        // Scroll la butonul de ștergere și dăm click
        WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(Locatori.REMOVE_ITEM_BUTTON));
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", removeButton);
        removeButton.click();
        System.out.println("❌ Am șters produsul din coș.");
        sleep();

        // Verificăm că produsul nu mai e în coș
        List<WebElement> produseRamase = driver.findElements(Locatori.PRODUCT_NAME);
        Assert.assertTrue(produseRamase.isEmpty(), "❗ Produsul este încă în coș!");
        System.out.println("✅ Produsul a fost eliminat cu succes din coș.");
    }

    private void sleep() {
        try {
            Thread.sleep(2500); // pauză vizuală
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}