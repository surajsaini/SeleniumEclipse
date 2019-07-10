package java1_;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	
	static WebDriver driver;
	
	public static void openbrowser1() throws IOException {

		Properties obj = new Properties();
		FileReader reader = new FileReader("application.properties"); 
		obj.load(reader);	

		if(obj.getProperty("browser").equals("chrome")) {

			// open chrome browser
			System.setProperty("webdriver.chrome.driver","D:\\Profiles\\ssaini\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize(); }

		else if (obj.get("browser").equals("IE")) { 			 

			System.setProperty("webdriver.ie.driver", "D:\\ToolsQA\\OnlineStore\\drivers\\IEDriverServer.exe");			 
			driver = new InternetExplorerDriver();

		} 

	}

}
