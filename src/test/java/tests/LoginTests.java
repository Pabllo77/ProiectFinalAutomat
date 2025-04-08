package tests;

import baseClass.BaseTest;
import locators.Locatori;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void testFormularContact() throws InterruptedException {
        driver.get("https://pabllo.ro/wp/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Găsire câmpuri folosind locatorii din Locatori.java
        WebElement numeField = wait.until(ExpectedConditions.elementToBeClickable(Locatori.NUME_FIELD));
        WebElement emailField = driver.findElement(Locatori.EMAIL_FIELD);
        WebElement mesajField = driver.findElement(Locatori.MESAJ_FIELD);
        WebElement trimiteButton = driver.findElement(Locatori.TRIMITE_BUTTON);

        // Introducere date
        numeField.sendKeys("Test User");
        emailField.sendKeys("test@example.com");
        mesajField.sendKeys("Acesta este un mesaj de test.");

        Thread.sleep(500);
        // Trimitere formular
        trimiteButton.click();

        // Verificare mesaj confirmare
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(Locatori.SUCCESS_MESSAGE));
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Mesajul de confirmare nu a apărut!");
    }
}