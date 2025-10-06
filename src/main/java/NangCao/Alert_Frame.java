package NangCao;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Alert_Frame {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.get("https://demoqa.com");

        WebElement Alerts_Frame = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[3]"));
        Alerts_Frame.click();
        Thread.sleep(1000);

        driver.navigate().to("https://demoqa.com/alerts");
        Thread.sleep(2000);

        // alert thường
        WebElement button = driver.findElement(By.xpath("//*[@id='alertButton']"));
        js.executeScript("arguments[0].click();", button);
        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        alert.accept();

        // alert sau 5s
        WebElement timerAlertButton = driver.findElement(By.xpath("//*[@id='timerAlertButton']"));
        js.executeScript("arguments[0].click();", timerAlertButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert2 = driver.switchTo().alert();
        System.out.println("Alert sau 5s: " + alert2.getText());
        alert2.accept();

        // frame
        driver.navigate().to("https://demoqa.com/frames");
        WebElement frame = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame);
        String frame_text = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println("Frame text: " + frame_text);
        driver.switchTo().defaultContent();

        driver.quit();
    }
}
