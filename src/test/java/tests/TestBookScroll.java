package tests;

import baseClass.BaseTest;
import locators.Locatori;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestBookScroll {

    WebDriver driver;

    @Test
    public void scrollInBookNowPopup() throws InterruptedException {
        System.out.println("[START] Deschidem browserul și accesăm pagina principală...");
        driver = new ChromeDriver();
        driver.get("https://pabllo.ro/wp/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        System.out.println("[INFO] Așteptăm butonul 'Book Now'...");
        WebElement bookNowBtn = wait.until(ExpectedConditions.elementToBeClickable(Locatori.BOOK_NOW_BUTTON));
        System.out.println("[OK] Găsit butonul 'Book Now'. Click!");
        bookNowBtn.click();

        Thread.sleep(4000); // așteptăm iframe-ul să se încarce (poți rafina cu așteptare explicită dacă vrei)

        // Schimbăm contextul pe iframe (iframe-ul se atașează după click)
        System.out.println("[INFO] Comutăm pe iframe-ul pop-up...");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));
        System.out.println("[OK] Suntem în iframe!");

        System.out.println("[INFO] Așteptăm și dăm click pe 'Accept'...");
        WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(Locatori.ACCEPT_COOKIES_BUTTON));
        acceptCookies.click();
        System.out.println("[OK] Accept cookies dat!");

        // Scroll pe pagina iframe (acum suntem deja în contextul corect)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0, 200);");
            Thread.sleep(500);
        }
        System.out.println("[DONE] Scroll efectuat complet în iframe!");

        driver.quit();
    }
}