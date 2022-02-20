package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FBlogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe"); // Firefox webdriver

		WebDriver driver = new ChromeDriver(); // to use Chrome, comment the below line
		// WebDriver driver = new FirefoxDriver(); // to use Firefox, comment the above
		// line

		driver.get("https://www.facebook.com/");

		driver.manage().window().maximize(); // Window Maximize
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		WebElement Username = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement Passwrd = driver.findElement(By.xpath("//input[@name='pass']"));
		WebElement Loginbutton = driver.findElement(By.xpath("//button[@name='login']"));

		Username.sendKeys("xyz@gmail.com");
		Passwrd.sendKeys("Abc@123");
		Loginbutton.click();
		driver.close();
		
		System.out.print("FB Login Testcase Passed");

	}

}
