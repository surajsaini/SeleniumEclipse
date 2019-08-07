package java1_;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HelloWorldPratice extends TestBase{

	public static void main(String[] args) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub

		// property file to load data
		Properties obj = new Properties();
		FileReader reader = new FileReader("application.properties"); 
		obj.load(reader);		

		HelloWorldPratice.openbrowser1();
		HelloWorldPratice.globalwait();		


		// open URL
		driver.get(obj.getProperty("appUrl"));

		// open new user
		driver.findElement(By.linkText("3. Add a User")).click();
		driver.navigate().back();
		driver.navigate().forward();

		// click on help button and handle the alert
		List<WebElement> clickonhelp = driver.findElements(By.linkText("Help"));
		int a2 = clickonhelp.size();
		//System.out.println(a2);
		for(int i=0;i<a2;i++) {
			clickonhelp.get(i).click();
			Thread.sleep(200);
			driver.switchTo().alert().accept();
		}

		HelloWorldPratice.readexcel();

		String excelrow = obj.getProperty("row");
		int c = Integer.parseInt(excelrow);

		for(int i=1;i<=c;i++) {
			// create username & password
			driver.findElement(By.name("username")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
			driver.findElement(By.xpath("//input[@tabindex='2']")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
			driver.findElement(By.xpath("//input[@type='button']")).click();
		}
		// login 
		driver.findElement(By.linkText("4. Login")).click();
		driver.findElement(By.name("username")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		driver.findElement(By.xpath("//input[@tabindex='2']")).sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
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
