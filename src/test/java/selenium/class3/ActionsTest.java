package selenium.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsTest {
    public static void main(String[] args) throws InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux")) System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/droppable.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


        Actions actions = new Actions(driver);

        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));
        Thread.sleep(2000);
        actions.dragAndDrop(sourceElement, targetElement).build().perform();
        Thread.sleep(2000);

        actions.doubleClick(driver.findElement(By.cssSelector("a[href='resizable.php']"))).build().perform();
        Thread.sleep(2000);

        actions.contextClick(driver.findElement(By.xpath("//a[normalize-space()='Dragabble']"))).build().perform();
        Thread.sleep(2000);

        driver.quit();

    }

}
