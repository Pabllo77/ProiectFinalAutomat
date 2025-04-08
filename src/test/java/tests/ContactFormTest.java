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

public class ContactFormTest extends BaseTest {
    @Test
    public void testFormularContact() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        System.out.println("Navigăm la formularul de contact...");
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locatori.NUME_FIELD_ALT));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", nameField);
        Thread.sleep(1000); // Pauză pentru vizualizare

        System.out.println(" Completăm câmpul 'Nume'...");
        js.executeScript("arguments[0].value='Test User';", nameField);
        Thread.sleep(1000);

        System.out.println("📝 Completăm câmpul 'Email'...");
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locatori.EMAIL_FIELD_ALT));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", emailField);
        js.executeScript("arguments[0].value='test@example.com';", emailField);
        Thread.sleep(1000);

        System.out.println("📝 Completăm câmpul 'Mesaj'...");
        WebElement messageField = wait.until(ExpectedConditions.visibilityOfElementLocated(Locatori.MESAJ_FIELD_ALT));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", messageField);
        js.executeScript("arguments[0].value='Acesta este un test automatizat!';", messageField);
        Thread.sleep(1000);

        System.out.println("Verificăm dacă valorile au fost introduse corect...");
        Assert.assertEquals(nameField.getAttribute("value"), "Test User", " Eroare: Numele nu a fost completat!");
        Assert.assertEquals(emailField.getAttribute("value"), "test@example.com", "Eroare: Emailul nu a fost completat!");
        Assert.assertEquals(messageField.getAttribute("value"), "Acesta este un test automatizat!", "Eroare: Mesajul nu a fost completat!");
        Thread.sleep(1000);

        System.out.println("Apăsăm butonul 'Trimite'...");
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(Locatori.TRIMITE_BUTTON_ALT));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", submitButton);
        Thread.sleep(1000);
        submitButton.click();

        System.out.println("⏳ Așteptăm apariția mesajului de succes...");
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(Locatori.SUCCESS_MESSAGE));
        Assert.assertTrue(successMessage.isDisplayed(), "Eroare: Mesajul de succes nu a apărut!");
        Thread.sleep(1000);

        System.out.println("Testul formularului de contact a fost executat cu succes!");
    }
}