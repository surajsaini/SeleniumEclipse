package mmtexample_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class air_fights {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// open chrome browser
		System.setProperty("webdriver.chrome.driver","D:\\Profiles\\ssaini\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();


		// property file to load data
		Properties obj = new Properties();
		FileReader reader = new FileReader("application.properties"); 
		obj.load(reader);

		// open URL
		driver.get(obj.getProperty("url"));

		Thread.sleep(3000);
		driver.findElement(By.linkText("Flights")).click();
	//	driver.findElement(By.xpath("//*[contains(@class,']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Amritsar");

		// use action class for press down key
		Actions a = new Actions(driver);
		a.keyDown(Keys.ARROW_DOWN);
		a.keyDown(Keys.ENTER);
		a.keyDown(Keys.TAB);

		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("kochi");
		a.keyDown(Keys.ARROW_DOWN).perform();
		a.keyDown(Keys.ENTER);
		a.keyDown(Keys.TAB);



	}

}
