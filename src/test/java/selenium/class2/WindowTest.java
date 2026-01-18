package selenium.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WindowTest {
    public static void main(String[] args) throws InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux")) System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

        System.out.println("Main Window Title: " + driver.getTitle());
        System.out.println("Main Window URL: " + driver.getCurrentUrl());
        System.out.println(driver.findElement(By.cssSelector("button[title='New Tab']")).getText());
        Thread.sleep(2000);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/new-tab-sample.php");
        System.out.println("New Window Title: " + driver.getTitle());
        System.out.println("New Window URL: " + driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.close();
        Thread.sleep(2000);
        //Switch back to the original window
        driver.switchTo().window(originalWindow);


        driver.quit();
    }
}
