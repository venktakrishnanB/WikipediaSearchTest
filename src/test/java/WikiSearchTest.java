import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WikiSearchTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qawikisearch.ccbp.tech/");

        WebElement searchField = driver.findElement(By.xpath("//input[@id = 'searchInput']"));
        searchField.sendKeys("HTML");

        WebElement searchButton = driver.findElement(By.xpath("//button[@class=\"search-button\"]"));
        searchButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"result-item\"]")));

        List<WebElement> searchResult = driver.findElements(By.xpath("//div[@class=\"result-item\"]"));
        System.out.println(searchResult.size() + " Results Found");

        driver.quit();
    }
}
