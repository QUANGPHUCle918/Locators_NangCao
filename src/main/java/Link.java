import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Link {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/links");
        Thread.sleep(3000);

        WebElement home = driver.findElement(By.xpath("//a[@id='simpleLink']"));
        home.click();
        Thread.sleep(1000);

        WebElement HomePH = driver.findElement(By.xpath("(//a[contains(text(),'Home')])[1]"));
        HomePH.click();
        Thread.sleep(1000);


        driver.close();

    }

}