package Test;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragndrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");

		// Maximize window
		driver.manage().window().maximize();

		// wait for browser to load - implicit
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		WebElement from1 = driver.findElement(By.xpath("//li[@id='credit2']/a"));
		WebElement to1 = driver.findElement(By.xpath("//ol[@id='bank']/li"));
		Actions act1 = new Actions(driver);
		act1.dragAndDrop(from1, to1).build().perform();

		WebElement from2 = driver.findElement(By.xpath("//li[@data-id='2']/a"));
		WebElement to2 = driver.findElement(By.xpath("//ol[@id='amt7']/li"));
		Actions act2 = new Actions(driver);
		act2.dragAndDrop(from2, to2).build().perform();
	}

}
