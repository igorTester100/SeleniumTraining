package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ContactUsTest extends BaseTest {



    @Test
    public void shouldNotAllowToSendEmptyContactUsForm() {
        //GLOBALNY WAIT DLA WSZYSTKICH ELEMENTOW
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("http://automationpractice.pl/index.php");
        assertThat(driver.getTitle()).isEqualTo("My Store");

        WebElement contactUsLink = driver.findElement(By.linkText("Contact us"));
        contactUsLink.click();

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("test@test.com");

        WebElement sendButton = driver.findElement(By.id("submitMessage"));
        sendButton.click();

        WebElement redAlertBox = driver.findElement(By.className("alert-danger"));

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(redAlertBox));

        assertThat(redAlertBox.isDisplayed()).isTrue();
    }

}
