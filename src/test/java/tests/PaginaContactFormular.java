package tests;

import baseClass.BaseTest;
import locators.Locatori;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class PaginaContactFormular extends BaseTest {

    @Test
    public void completareFormularContact() throws InterruptedException {
        System.out.println("[START] Test completare formular contact");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        System.out.println("[INFO] Click pe meniul Contact...");
        WebElement contactMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://pabllo.ro/wp/contact/']")));
        contactMenu.click();

        System.out.println("[INFO] Așteptăm încărcarea paginii de contact...");
        wait.until(ExpectedConditions.urlContains("/contact"));
        Thread.sleep(1000);

        System.out.println("[INFO] Completăm câmpul Nume");
        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.name("name")));
        nameField.click();
        nameField.sendKeys("Tester Testescu");

        System.out.println("[INFO] Completăm câmpul Email");
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.name("email")));
        emailField.click();
        emailField.sendKeys("tester@test.com");

        System.out.println("[INFO] Completăm câmpul Subiect");
        WebElement subjectField = wait.until(ExpectedConditions.elementToBeClickable(By.name("subject")));
        subjectField.click();
        subjectField.sendKeys("Test automat");

        System.out.println("[INFO] Completăm câmpul Mesaj");
        WebElement messageField = wait.until(ExpectedConditions.elementToBeClickable(By.name("message")));
        messageField.click();
        messageField.sendKeys("Acesta este un mesaj de test trimis automat din Selenium.");

        System.out.println("[INFO] Click pe butonul Trimite");
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit' and @form='contact-form'])[last()]")));
        submitButton.click();

        System.out.println("[DONE] Formularul a fost completat și trimis!");
        Thread.sleep(2000);
    }
}