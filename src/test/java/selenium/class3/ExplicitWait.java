package selenium.class3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {
    public static void main(String[] args) throws InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux")) System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button[onclick='showAlert()']"))));
        driver.findElement(By.cssSelector("button[onclick='showAlert()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@onclick='myDesk()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("button[onclick='myPromp()']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);

        Alert art = driver.switchTo().alert();
        art.sendKeys("Selenium Alert Test");
        System.out.println("Alert Text: " + art.getText());
        Thread.sleep(2000);
        art.accept();
        Thread.sleep(2000);


        driver.quit();

    }
}
