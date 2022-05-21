package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S06_02_CreateAccounts {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");				
		ChromeDriver driver = new ChromeDriver(options);				
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();				
		driver.findElement(By.id("username")).sendKeys("mars@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel$123");	
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));			
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
		driver.findElement(By.xpath("//p[text()='Manage your sales process with accounts, leads, opportunities, and more']")).click();
		WebElement Accounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", Accounts);
		
		//5. Click on New button
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		//6. Enter 'your name' as account name
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Your Name");
		//7. Select Ownership as Public    
		driver.findElement(By.xpath("//button[@aria-label='Ownership, --None--']")).click();
		driver.findElement(By.xpath("//span[text()='Public']")).click();
		//8. Click save and verify Account name 
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String name = driver.findElement(By.xpath("//lightning-formatted-text[text()='Your Name']")).getText();
		System.out.println(name);	

	}

}
