package NangCao;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.module.FindException;

public class Text_Box_From {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.get("https://demoqa.com");
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]"));
        element.click();
        Thread.sleep(1000);

        WebElement textbox = driver.findElement(By.xpath("//*[@id='item-0']"));
        textbox.click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//input[@autocomplete=\"off\"])[1]")).sendKeys("Quang Phuc");
        driver.findElement(By.xpath("(//input[@autocomplete=\"off\"])[2]")).sendKeys("qle25801@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Thanh Hoa");
        driver.findElement(By.id("permanentAddress")).sendKeys("Ha NOi");
        Thread.sleep(1000);

        WebElement submit = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", submit);
        Thread.sleep(1000);

        WebElement result = driver.findElement(By.id("output"));
        js.executeScript("arguments[0].scrollIntoView(true);", result);
        js.executeScript("arguments[0].style.border='3px solid red'", result);

        System.out.println("Result text: " + result.getText());

        Thread.sleep(3000);
        driver.quit();
    }



}
