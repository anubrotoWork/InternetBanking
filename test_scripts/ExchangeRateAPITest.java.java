import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ExchangeRateAPITest {

    private WebDriver driver;

    public ExchangeRateAPITest() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @Test
    public void testExchangeRateAPIDowntime() {
        // Simulate API downtime
        simulateAPIDowntime();

        // Open the application
        driver.get("http://localhost:8080/exchange-rate");

        // Check for error message
        WebElement errorMessage = driver.findElement(By.id("error-message"));
        assertTrue(errorMessage.isDisplayed(), "Error message should be displayed");
        assertTrue(errorMessage.getText().contains("currently unavailable due to API issues"), "Error message should indicate API issues");

        // Clean up
        driver.quit();
    }

    private void simulateAPIDowntime() {
        // Logic to simulate API downtime (e.g., mock server response)
    }
}