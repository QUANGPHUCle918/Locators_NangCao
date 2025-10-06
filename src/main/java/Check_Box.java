import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check_Box {

        public static void main(String[] args) throws InterruptedException {
            // 1️⃣ Khởi tạo WebDriver
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            // 2️⃣ Mở trang web checkbox
            driver.get("https://demoqa.com/checkbox");
            driver.manage().window().maximize();


            // Từ nhãn “Home” → ancestor::label → checkbox
            WebElement homeCheckbox = driver.findElement(By.xpath("(//span[normalize-space()='Home'])[2]/ancestor::label/span[@class='rct-checkbox']"));
            homeCheckbox.click();
            Thread.sleep(1000);


            // Từ “Documents” → tìm mũi tên toggle
            WebElement documentsToggle = driver.findElement(By.xpath("//span[@class='rct-title' and text()='Documents']/parent::label/preceding-sibling::button"));
            documentsToggle.click();
            Thread.sleep(1000);


            WebElement downloadsCheckbox = driver.findElement(By.xpath("//span[@class='rct-title' and text()='Downloads']/parent::label/span[@class='rct-checkbox']"));
            downloadsCheckbox.click();
            Thread.sleep(1000);


            driver.quit();
        }
    }




