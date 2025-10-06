package NangCao;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_Page {
    WebDriver driver;

    By username = By.id("userName");
    By password = By.id("password");
    By loginButton = By.id("login");
    public Login_Page(WebDriver driver) {
        this.driver = driver;
    }
    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
        Thread.sleep(1000);

        // --- Tạo đối tượng LoginPage ---
      Login_Page loginPage = new Login_Page(driver);


        WebElement loginBtn = driver.findElement(By.id("login"));
        driver.findElement(By.id("userName")).sendKeys("QuangPhuc");
        driver.findElement(By.id("password")).sendKeys("12345");


        try {
            loginBtn.click();
        } catch (ElementNotInteractableException e) {
            js.executeScript("arguments[0].click();", loginBtn);
        }

        Thread.sleep(2000);


        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("profile")) {
            System.out.println("Đăng nhập thành công! URL hiện tại: " + currentUrl);
        } else {
            // Nếu login thất bại, in thông báo lỗi từ trang
            WebElement errorMsg = driver.findElement(By.id("name"));
            System.out.println(" Đăng nhập thất bại: " + errorMsg.getText());
        }

        driver.quit();
    }
}
