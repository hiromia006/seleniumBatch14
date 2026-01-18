package selenium.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class TagName {
    public static void main(String[] args) throws InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux")) System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/");

        List<WebElement> webElements = driver.findElements(By.tagName("a"));

        System.out.println("Total links: " + webElements.size());
        // for(List type variable : List){}
        for (WebElement element : webElements) {
            System.out.println(element.getText() + " - " + element.getAttribute("href"));
        }

        driver.quit();

    }
}
