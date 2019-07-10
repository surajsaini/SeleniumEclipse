package java1_;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelloWorldPratice extends TestBase{

	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub

		// property file to load data
		Properties obj = new Properties();
		FileReader reader = new FileReader("application.properties"); 
		obj.load(reader);		

		HelloWorldPratice.openbrowser1();

		// open URL
		driver.get(obj.getProperty("appUrl"));

		// open new user
		driver.findElement(By.linkText("3. Add a User")).click();
		driver.navigate().back();
		driver.navigate().forward();

		// click on help button and handle the alert
		List<WebElement> clickonhelp = driver.findElements(By.linkText("Help"));
		int a2 = clickonhelp.size();
		System.out.println(a2);
		for(int i=0;i<a2;i++) {
			clickonhelp.get(i).click();
			Thread.sleep(1200);
			driver.switchTo().alert().accept();
		}
		// create username & password
		driver.findElement(By.name("username")).sendKeys(obj.getProperty("username"));
		driver.findElement(By.xpath("//input[@tabindex='2']")).sendKeys(obj.getProperty("password"));
		driver.findElement(By.xpath("//input[@type='button']")).click();

		// login 
		driver.findElement(By.linkText("4. Login")).click();
		driver.findElement(By.name("username")).sendKeys(obj.getProperty("username"));
		driver.findElement(By.xpath("//input[@tabindex='2']")).sendKeys(obj.getProperty("password"));
		driver.findElement(By.xpath("//input[@type='button']")).click();

		// find how many links are available on page and print them
		List<WebElement> nooflink = driver.findElements(By.tagName("a"));
		int a1 = nooflink.size();
		System.out.print(a1);
		for(int i=0;i<a1;i++) {
			System.out.println(nooflink.get(i).getText());
		}



	}

}
