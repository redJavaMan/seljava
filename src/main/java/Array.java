import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Array {
    public static void main(String[] args) throws InterruptedException {
        String personName = "Lukman";
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        WebElement userName = driver.findElement(By.id("inputUsername"));
        userName.sendKeys("lukman");
        WebElement password = driver.findElement(By.name("inputPassword"));
        password.sendKeys("password");
        WebElement signIn = driver.findElement(By.xpath("//button[contains(.,'Sign In')]"));
        signIn.click();
        WebElement error = driver.findElement(By.cssSelector(".error"));
        System.out.println(error.getText());
        Assert.assertEquals(error.getText(), "* Incorrect username or password");
        WebElement forgotPassword = driver.findElement(By.partialLinkText("Forgot your password?"));
        forgotPassword.click();
        WebElement name = driver.findElement(By.cssSelector("input[placeholder='Name']"));
        name.sendKeys("lukman");
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        email.sendKeys("123@gmail.com");
        WebElement phoneNo = driver.findElement(By.xpath("//input[@placeholder='Phone Number']"));
        phoneNo.sendKeys("9976678655");
        WebElement resetLogin = driver.findElement(By.xpath("//button[text()='Reset Login']"));
        resetLogin.click();
        WebElement tempPassword = driver.findElement(By.cssSelector("p[class='infoMsg']"));
        Assert.assertEquals(tempPassword.getText(), "Please use temporary password 'rahulshettyacademy' to Login.");
        System.out.println(tempPassword.getText());
        WebElement goToLogin = driver.findElement(By.xpath("//button[text()='Go to Login']"));
        goToLogin.click();
        userName.sendKeys(personName);
        password.sendKeys("rahulshettyacademy");
        signIn.click();
        WebElement successLoggedIn = driver.findElement(By.xpath("//p[text()='You are successfully logged in.']"));
        Assert.assertEquals(successLoggedIn.getText(),"You are successfully logged in.");
        System.out.println(successLoggedIn.getText());
        WebElement logOut = driver.findElement(By.xpath("//button[text()='Log Out']"));
        logOut.click();
        getPassword(driver);
    }

    public static String getPassword(WebDriver driver){
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.partialLinkText("Forgot your password?")).click();
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Lukman");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("123@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9976678655");
        driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
        String temporavaryPass = driver.findElement(By.cssSelector("p[class='infoMsg']")).getText();
        driver.findElement(By.xpath("//button[text()='Go to Login']")).click();
        String[] tempPass = temporavaryPass.split("'");
        String[] tempPass1 = tempPass[1].split("'");
        String realPassword = tempPass1[0];
        driver.findElement(By.id("inputUsername")).sendKeys("lukman");
        driver.findElement(By.name("inputPassword")).sendKeys(realPassword);
        driver.findElement(By.xpath("//button[contains(.,'Sign In')]")).click();
        System.out.println(realPassword);
        return realPassword;
    }
}



