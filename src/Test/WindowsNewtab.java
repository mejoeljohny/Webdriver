package Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsNewtab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

		WebDriver driver = new ChromeDriver();
		// WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/browser-windows");

		// Maximize window
		driver.manage().window().maximize();

		// wait for browser to load - implicit
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		String Parentwin=driver.getWindowHandle();
		System.out.println("Before clicking the tab " + Parentwin);
		
		WebElement btn = driver.findElement(By.xpath("//button[@id='tabButton']"));
		btn.click();
		
		System.out.println("After clicking the tab ");
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> itr=handles.iterator();
		while(itr.hasNext()) {
			String Currentval=itr.next();
			System.out.println( Currentval);
			if(!Currentval.equals(Parentwin)) {
				driver.switchTo().window(Currentval);
			}
		}
		
		WebElement heading = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
			System.out.println(heading.getText());
			
			String a="This is a sample page";
			
			if(heading.getText().equals(a))
			{
				System.out.println( "Testcase Passed");
			}
			
			else
			{System.out.println( "Testcase Failed");}
				
		driver.close();
		
		//back to Parent window
		driver.switchTo().window(Parentwin);
		driver.close();
	}

}
