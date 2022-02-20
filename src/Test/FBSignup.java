package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FBSignup {

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

		WebElement Signupbtn = driver.findElement(By.xpath("//*[text()='Create New Account']"));
		Signupbtn.click();

		WebElement first = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement sur = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement Email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement reEmail = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		WebElement pass = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));

		first.sendKeys("QA");
		sur.sendKeys("Test");
		Email.sendKeys("Test@gmail.com");
		reEmail.sendKeys("Test@gmail.com");
		pass.sendKeys("AbC@123");

		// to list down all the months
		List<WebElement> months = driver.findElements(By.xpath("//select[@id='month']/option"));
		for (WebElement elm : months) {
			System.out.println(elm.getText());
		}

		// to select current month
		WebElement Curmonth = driver.findElement(By.xpath("//select[@id='month']/option[@selected='1']"));
		System.out.println("Current Month is " + Curmonth.getText());

		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select dday = new Select(day);
		dday.selectByVisibleText("25");

		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select mmonth = new Select(month);
		mmonth.selectByVisibleText("Jul");

		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select yyear = new Select(year);
		yyear.selectByVisibleText("1989");

		String Strgender = "Female";
		String genXpath = ("//label[text()='" + Strgender + "']/following-sibling::input");
		WebElement gen = driver.findElement(By.xpath(genXpath));
		gen.click();

		WebElement Signup = driver.findElement(By.xpath("//button[@name='websubmit']"));
		Signup.click();
		// driver.close();
	}

}
