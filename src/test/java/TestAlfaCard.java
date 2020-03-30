import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestAlfaCard {

    WebDriver webDriver;

    @BeforeAll
    public static void setupDriverPath() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    }

    @BeforeEach
    public void setUp() {
        webDriver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    void startService() {
        webDriver.get("http://localhost:9999/");
        List<WebElement> inputElements = webDriver.findElements(By.className("input__control"));
        inputElements.get(0).sendKeys("Иннокентий");
        inputElements.get(1).sendKeys("+70001112233");
        webDriver.findElement(By.className("checkbox__box")).click();
        webDriver.findElement(By.tagName("button")).click();
        String actualText = webDriver.findElement(By.className("Success_successBlock__2L3Cw")).getText();
        Assertions.assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", actualText.trim());
    }
}

