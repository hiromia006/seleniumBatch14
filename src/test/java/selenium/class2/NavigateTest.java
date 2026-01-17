package selenium.class2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigateTest {
    public static void main(String[] args) throws InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux")) System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/");
        Thread.sleep(3000);

//        driver.navigate().to("https://www.saucedemo.com/");
//        Thread.sleep(2000);
//        System.out.println("Current URL: " + driver.getCurrentUrl());
//        driver.navigate().back();
//        Thread.sleep(2000);
//        System.out.println("Current URL: " + driver.getCurrentUrl());
//        driver.navigate().forward();
//        Thread.sleep(2000);
//        System.out.println("Current URL: " + driver.getCurrentUrl());
//        driver.navigate().refresh();
//        Thread.sleep(2000);

        WebDriver.Navigation nav=driver.navigate();
        nav.to("https://www.saucedemo.com/");
        Thread.sleep(2000);
        System.out.println("Current URL: " + driver.getCurrentUrl());

        nav.back();
        Thread.sleep(2000);
        System.out.println("Current URL: " + driver.getCurrentUrl());

        nav.forward();
        Thread.sleep(2000);
        System.out.println("Current URL: " + driver.getCurrentUrl());

        nav.refresh();
        Thread.sleep(2000);
        driver.quit();

    }
}
