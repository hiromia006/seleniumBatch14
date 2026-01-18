package selenium.class2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class AlertTest {
    public static void main(String[] args) throws InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux")) System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


        driver.findElement(By.cssSelector("button[onclick='showAlert()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@onclick='myDesk()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("button[onclick='myPromp()']")).click();
        Thread.sleep(2000);

        Alert art=driver.switchTo().alert();
        art.sendKeys("Selenium Alert Test");
        System.out.println("Alert Text: "+ art.getText());
        Thread.sleep(2000);
        art.accept();
        Thread.sleep(2000);


        driver.quit();

    }
}
