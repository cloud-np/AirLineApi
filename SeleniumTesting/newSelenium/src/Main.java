import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

//    public static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\PC\\Desktop\\foxdriver\\geckodriver.exe");
        WebDriver driver;
        driver = new FirefoxDriver();
          driver.get("http://localhost:5173/");
//        driver.get("https://www.google.com/");
//        driver.manage().window().maximize();

//        Wait for element to appear then proceed
        WebElement element = driver.findElement(By.xpath("/html/body/div/div/form/input[1]"));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf((element)));

        driver.findElement(By.xpath("/html/body/div/div/form/input[1]"))
                .sendKeys("bobdylan@gmail.com");
        driver.findElement(By.xpath("/html/body/div/div/form/input[2]"))
                .sendKeys("1234");
        driver.findElement(By.xpath("/html/body/div/div/form/button"))
                .click();


        List<WebElement> elements = driver.findElements(By.xpath("//*"));
        int elementsCount = elements.size();
        System.out.println(elementsCount);

    }
}