package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S06_116_CreateNewLeads {

	public static void main(String[] args) throws InterruptedException {
		
		//1. Login to https://login.salesforce.com
		
		//Download the Chrome Web Browser		
		WebDriverManager.chromedriver().setup();
		//disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options); 

		//Load the salesforce url
		
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		//input user name and password
		driver.findElement(By.id("username")).sendKeys("mars@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel$123");	
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//2. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();		
		//3. Click view All and click Sales from App Launcher
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("sales");
		driver.findElement(By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']")).click();
		//4. Click on Leads tab
		//driver.findElement(By.xpath("//span[text()='Leads']")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.findElement(By.xpath("//a[@title='Leads']")).click();
		
		WebElement newLegalEntity = driver.findElement(By.xpath("//a[@title='Leads']"));
		driver.executeScript("arguments[0].click();", newLegalEntity);
				
		//5. Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		//6. Select Salutation as 'Mr'
		
		/* Click on Ownership field 
		WebElement ownership = driver.findElement(By.xpath("(//button[@data-value='--None--'])[3]")); 
		Actions action = new Actions(driver); 
		action.moveToElement(ownership).click().build().perform(); 
		// Select Ownership as Public 
		WebElement ownership1 = driver.findElement(By.xpath("//span[text()='Public']"));
		action.moveToElement(ownership1).click().build().perform();*/
		
		
		WebElement cases = driver.findElement(By.xpath("//button[@name='salutation']"));
		Actions action = new Actions(driver); 
		action.moveToElement(cases).click().build().perform();
		WebElement cases1 = driver.findElement(By.xpath("//span[@title='Mr.']"));
		action.moveToElement(cases1).click().build().perform();
		
		
		//7. Enter the Last Name as 'Kumar'
		
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Kumar");
		
		//8. Enter the CompanyName as 'TestLeaf'
		
		driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("TestLeaf");
		
		//9. click Save and Verify Leads Name
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		 WebElement name = driver.findElement(By.xpath("//span[contains (text(),'kumar')]"));
		 System.out.println(name);
		
		
		

	}

}
