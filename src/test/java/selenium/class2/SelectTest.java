package selenium.class2;

import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectTest {
    public static void main(String[] args) throws InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux")) System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(3000);

//      WebElement element= driver.findElement(By.id("state"));
//        Select sl= new Select(element);

        Select sl = new Select(driver.findElement(By.id("state")));
        sl.selectByIndex(1);
        Thread.sleep(2000);

        sl.selectByValue("Rajasthan");
        Thread.sleep(2000);

        sl.selectByVisibleText("Haryana");
        Thread.sleep(2000);

        List<WebElement> ops = sl.getOptions();
        System.out.println("Total options: " + ops.size());
        for (WebElement option : ops) {
            System.out.println(option.getText() + " - " + option.getAttribute("value"));
        }

        driver.quit();
    }
}
