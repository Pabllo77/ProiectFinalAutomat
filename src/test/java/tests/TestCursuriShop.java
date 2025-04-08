package tests;

import locators.Locatori;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class TestCursuriShop {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://pabllo.ro/wp";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testNavigareCursuriToShop() throws InterruptedException {
        // 1. Accesăm pagina principală
        driver.get(baseUrl);
        System.out.println("Accesăm pagina principală...");
        Thread.sleep(3000); // Pauză de 3 secunde pentru a vedea pagina încărcată

        // 2. Click pe butonul 'Cursuri' din header
        WebElement cursuriButton = wait.until(ExpectedConditions.elementToBeClickable(Locatori.CURSURI_BUTTON));
        cursuriButton.click();
        System.out.println("Am dat click pe butonul 'Cursuri'...");
        Thread.sleep(3000); // Pauză de 3 secunde pentru a vizualiza acțiunea

        // 3. Așteptăm încărcarea completă a paginii
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        System.out.println("Pagina Cursuri s-a încărcat complet...");
        Thread.sleep(3000); // Pauză de 3 secunde pentru a vizualiza încărcarea

        // 4. Scroll în jos
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        System.out.println("Am dat scroll în jos...");
        Thread.sleep(3000); // Pauză de 3 secunde pentru a vizualiza scroll-ul

        // 5. Așteptăm ca butonul 'Comanda' să fie vizibil și activ
        WebElement comandaButton = wait.until(ExpectedConditions.elementToBeClickable(Locatori.COMANDA_BUTTON));
        comandaButton.click();
        System.out.println("Am dat click pe butonul 'Comanda'...");
        Thread.sleep(3000); // Pauză de 3 secunde pentru a vizualiza acțiunea

        // 6. Verificăm că am ajuns pe pagina de Shop
        wait.until(ExpectedConditions.urlContains("shop"));
        Assert.assertTrue(driver.getCurrentUrl().contains("shop"), "Nu s-a ajuns pe pagina de Shop!");
        System.out.println("Am ajuns pe pagina de Shop...");
        Thread.sleep(3000); // Pauză de 3 secunde pentru a vizualiza rezultatul

        // 7. Scroll până la titlul Shop
        WebElement shopTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.woocommerce-products-header__title.page-title")));
        js.executeScript("arguments[0].scrollIntoView(true);", shopTitle);
        System.out.println("Am dat scroll până la titlul 'Shop'...");
        Thread.sleep(3000); // Pauză de 3 secunde pentru a vizualiza scroll-ul până la titlu

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browserul a fost închis.");
        }
    }
}