package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe"); // Firefox webdriver
		
		//WebDriver driver = new ChromeDriver(); // to use Chrome, comment the below line
		WebDriver driver = new FirefoxDriver(); // to use Firefox, comment the above line
		
		driver.get("https://www.simplilearn.com/");

		// driver.navigate().to("https://www.simplilearn.com/"); // same as
		// driver.get("https://www.simplilearn.com/");

		driver.manage().window().maximize(); // Window Maximize
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		WebElement Loginlink = driver.findElement(By.linkText("Log in")); // to find the Login link in Home page
		Loginlink.click(); // to click on Login link
		// driver.manage().window().fullscreen(); // To display as Full screen
		WebElement Username = driver.findElement(By.name("user_login")); // Object to find User text box
		WebElement Password = driver.findElement(By.id("password")); // Object to find Password text box
		WebElement ShowPassword = driver.findElement(By.id("password-icon")); // Object to show the password
		WebElement LoginButton = driver.findElement(By.name("btn_login")); // Object for Login Button
		WebElement Rememberme = driver.findElement(By.className("rememberMe")); // Object for Remember me
		// WebElement forgotpasswrd = driver.findElement(By.linkText("Forgot
		// Password?"));

		Username.sendKeys("xyz@gmail.com"); // To enter Username
		Password.sendKeys("ABC@123e"); // To enter Password
		ShowPassword.click(); // click on Show Password
		Rememberme.click(); // Click on Remember Me Checkbox
		// forgotpasswrd.click();
		LoginButton.click(); // Click on Login Button

		WebElement Errmsg = driver.findElement(By.id("msg_box"));

		String Actualmsg = Errmsg.getText();
		String Expmsg = "The email or password you have entered is invalid.";

		if (Actualmsg.equals(Expmsg)) {
			System.out.println("Testcase Passed");
		} else {
			System.out.println("Testcase Failed");
		}

		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("Total Links are " + Links.size());

		for (WebElement elm : Links) {
			System.out.println(elm.getAttribute("href"));
		}
		driver.close();

	}

}
