import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Web_Tables {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement editAlden = driver.findElement(
                By.xpath("//div[@role='gridcell' and text()='Alden']/ancestor::div[@role='row']//span[@title='Edit']")
        );
        js.executeScript("arguments[0].scrollIntoView(true);", editAlden);
        wait.until(ExpectedConditions.elementToBeClickable(editAlden)).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registration-form-modal")));
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("closeLargeModal")));
        js.executeScript("arguments[0].scrollIntoView(true);", closeButton);
        closeButton.click();
        System.out.println(" Đã mở và đóng popup Edit của Alden thành công!");


        WebElement emailCierra = driver.findElement(
                By.xpath("//div[@role='gridcell' and text()='Cierra']/following-sibling::div[3]")
        );
        System.out.println("📧 Email của Cierra là: " + emailCierra.getText());

        List<WebElement> followingRows = driver.findElements(
                By.xpath("//div[@class='rt-td' and text()='39']/ancestor::div[@role='row']/following::div[@role='row']")
        );
        System.out.println(" Các hàng sau hàng có Age = 39:");
        for (WebElement row : followingRows) {
            System.out.println("  " + row.getText());
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
