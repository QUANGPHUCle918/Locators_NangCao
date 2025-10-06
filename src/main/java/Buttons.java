
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buttons {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        WebDriverManager.chromedriver().setup();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/buttons");
        Thread.sleep(3000);

        WebElement dbclickme = driver.findElement(By.cssSelector("#doubleClickBtn"));
        dbclickme.click();
        Thread.sleep(1000);

        WebElement rightclickme = driver.findElement(By.xpath("//*[@id=\"rightClickBtn\"]"));
        rightclickme.click();
        Thread.sleep(2000);

        WebElement clickme = driver.findElement(By.xpath("(//button[@type=\"button\"])[4])"));
        clickme.click();
        Thread.sleep(3000);


        driver.close();

    }
}
