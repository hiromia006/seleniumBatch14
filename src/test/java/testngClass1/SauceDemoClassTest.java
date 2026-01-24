package testngClass1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SauceDemoClassTest {
    WebDriver driver;

    @BeforeClass
    public void browserSetup() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");

        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
    }

    @AfterClass
    public void quiteBrowser() {
        driver.quit();
    }

    @Test(priority = 0, description = "Verify the title of the SauceDemo login page")
    public void checkTittle() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test(priority = 1, description = "Verify the logo name on the SauceDemo login page")
    public void checkLogoName() {
        String logoName = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(logoName, "Swag Labs");
    }

    @Test(priority = 2, description = "Verify the presence of login button on the SauceDemo login page")
    public void varifyLoginPage() {
        String idValue = driver.findElement(By.id("login-button")).getAttribute("id");
        Assert.assertEquals(idValue, "login-button");
    }

    @Test(priority = 3, description = "Verify login with valid credentials on the SauceDemo login page")
    public void varifyLoginWithValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");

        driver.findElement(By.id("react-burger-menu-btn")).click();
        String menuText = driver.findElement(By.id("logout_sidebar_link")).getText();

        Assert.assertEquals(menuText, "Logout");
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Test(priority = 4, description = "Verify login with valid credentials on the SauceDemo login page")
    public void varifyLoginWithLockedOutUser() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();
        String menuText = driver.findElement(By.id("logout_sidebar_link")).getText();

        Assert.assertEquals(menuText, "Logout");

    }
}
