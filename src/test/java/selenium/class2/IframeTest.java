package selenium.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class IframeTest {
    public static void main(String[] args) throws InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux")) System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/frames.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Main Page outside of Iframe " + driver.findElement(By.cssSelector("a[href='/selenium/index.htm']")).getText());

        driver.switchTo().frame(0);
        System.out.println("Inside Iframe one " + driver.findElement(By.cssSelector("a[href='/selenium/index.htm']")).getText());
        driver.switchTo().defaultContent();
        System.out.println("defaultContent Iframe " + driver.findElement(By.cssSelector("a[href='/selenium/index.htm']")).getText());

        driver.switchTo().frame(1);
        System.out.println("Inside Iframe two" + driver.findElement(By.cssSelector("a[href='/selenium/index.htm']")).getText());
        driver.switchTo().defaultContent();
        System.out.println("defaultContent Iframe " + driver.findElement(By.cssSelector("a[href='/selenium/index.htm']")).getText());

        driver.quit();
    }
}
