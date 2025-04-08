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

public class TestCosMultipluAdd extends BaseTest {

    @Test
    public void testAdaugareShopInCos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1. Pagina principală este deja deschisă din BaseTest
        System.out.println("✅ Pagina principală este încărcată.");

        // 2. Click pe butonul Cos
        WebElement cosButton = wait.until(ExpectedConditions.elementToBeClickable(Locatori.COS_BUTTON));
        cosButton.click();
        System.out.println("🛒 Am dat click pe butonul 'Cos'.");
        sleep();

        // 3. Scroll până la secțiunea 'New in store'
        WebElement newInStore = wait.until(ExpectedConditions.visibilityOfElementLocated(Locatori.NEW_IN_STORE_TITLE));
        js.executeScript("arguments[0].scrollIntoView(true);", newInStore);
        System.out.println("🔽 Am ajuns la 'New in store'.");
        sleep();

        // 4. Click pe butonul 'Add to cart' pentru Curs Basic
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(Locatori.ADD_TO_CART_BUTTON_NEW));
        addToCartButton.click();
        System.out.println("🧺 Am adăugat produsul în coș.");
        sleep();

        // 5. Dăm click pe '+' de încă 4 ori (total 5)
        for (int i = 0; i < 4; i++) {
            WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(Locatori.INCREASE_QUANTITY_BUTTON));
            plusButton.click();
            System.out.println("➕ Cantitatea crescută la " + (i + 2));
            sleep();
        }

        // 6. Verificăm că valoarea este 5
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Locatori.QUANTITY_INPUT));
        String valoare = quantityInput.getAttribute("value");
        System.out.println("🔍 Cantitatea detectată: " + valoare);
        Assert.assertEquals(valoare, "5", "❌ Cantitatea în coș NU este 5!");

        System.out.println("✅ Testul s-a încheiat cu succes.");
    }

    private void sleep() {
        try {
            Thread.sleep(2000); // Pauză vizuală între pași
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}