package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe"); // Firefox webdriver

		WebDriver driver = new ChromeDriver(); // to use Chrome, comment the below line
		// WebDriver driver = new FirefoxDriver(); // to use Firefox, comment the above
		// line

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		driver.manage().window().maximize(); // Window Maximize
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println("Total Number of rows are : " + rows.size());

		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='customers']//th"));
		System.out.println("Total Number of Columns are : " + columns.size());

		System.out.println("***********");
		List<WebElement> values1 = driver.findElements(By.xpath("//table[@id='customers']//tr[4]/td"));
		for (WebElement val1 : values1) {
			System.out.println(val1.getText());
		}
		System.out.println("***********");
		List<WebElement> values2 = driver.findElements(By.xpath("//td[text()='Island Trading']/following-sibling::td"));
		for (WebElement val2 : values2) {
			System.out.println(val2.getText());
		}
		System.out.println("***********");
		List<WebElement> values3 = driver.findElements(By.xpath("//td[text()='Roland Mendel']/parent::tr"));
		for (WebElement val3 : values3) {
			System.out.println(val3.getText());
		}

		driver.close();
	}

}
