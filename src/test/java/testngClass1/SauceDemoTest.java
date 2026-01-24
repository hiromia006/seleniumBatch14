package testngClass1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTest {
    @Test(description = "Verify the title of the SauceDemo login page")
    public void checkTittle() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
        String title = driver.getTitle();
        Assert.assertEquals(title, "Swag Labs");
        driver.quit();
    }

    @Test(description = "Verify the logo name on the SauceDemo login page")
    public void checkLogoName() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));

        String logoName = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(logoName, "Swag Labs");
        driver.quit();
    }

    @Test(description = "Verify the presence of login button on the SauceDemo login page")
    public void varifyLoginPage() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));

        String idValue = driver.findElement(By.id("login-button")).getAttribute("id");
        Assert.assertEquals(idValue, "login-button");
        driver.quit();
    }

    @Test(description = "Verify login with valid credentials on the SauceDemo login page")
    public void varifyLoginWithValidCredentials() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");

        driver.findElement(By.id("react-burger-menu-btn")).click();
        String menuText = driver.findElement(By.id("logout_sidebar_link")).getText();

        Assert.assertEquals(menuText, "Logout");
        driver.quit();
    }

    @Test(description = "Verify login with valid credentials on the SauceDemo login page")
    public void varifyLoginWithLockedOutUser() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();
        String menuText = driver.findElement(By.id("logout_sidebar_link")).getText();

        Assert.assertEquals(menuText, "Logout");
        driver.quit();
    }
}
