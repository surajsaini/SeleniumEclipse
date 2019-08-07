package java1_;


import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	static WebDriver driver;
	static XSSFSheet sheet;
	static XSSFWorkbook workbook;
	static FileInputStream fis;

	public static void openbrowser1() throws IOException {
		Properties obj = new Properties();
		FileReader reader = new FileReader("application.properties"); 
		obj.load(reader);	
		if(obj.getProperty("browser").equals("chrome")) {
			// open chrome browser
			System.setProperty("webdriver.chrome.driver","D:\\Profiles\\ssaini\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (obj.get("browser").equals("IE")) { 			 
			// open IE browser
			System.setProperty("webdriver.ie.driver", "D:\\ToolsQA\\OnlineStore\\drivers\\IEDriverServer.exe");			 
			driver = new InternetExplorerDriver();
		} 
	}

	public static void globalwait() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void readexcel() throws IOException {
		
		fis = new FileInputStream("D:\\Profiles\\ssaini\\Downloads\\Testdata_for_selenium.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		
	}

}
