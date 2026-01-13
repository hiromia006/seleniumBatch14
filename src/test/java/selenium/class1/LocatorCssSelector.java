package selenium.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorCssSelector {
    public static void main(String[] args) throws InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux")) System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        // Add login steps here
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.cssSelector(".shopping_cart_badge")).click();
        driver.findElement(By.cssSelector("#checkout")).click();

        driver.quit();

    }
}
