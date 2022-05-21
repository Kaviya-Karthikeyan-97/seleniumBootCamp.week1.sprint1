package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S06_118_DeleteLead {

	public static void main(String[] args) throws InterruptedException {
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
		WebElement leads = driver.findElement(By.xpath("//a[@title='Leads']"));
		driver.executeScript("arguments[0].click();", leads);
		WebElement searchbox = driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
		searchbox.sendKeys("Ganesh kumar",Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]//a")).click();
		WebElement dropdown = driver.findElement(By.xpath("//a[@title='Delete']"));
		Thread.sleep(3000);
		Actions action = new Actions(driver); 
		action.moveToElement(dropdown).click().build().perform(); 
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		String name = driver.findElement(By.xpath("//span[contains (text(),'kumar')]")).getText();
		System.out.println(name);
		WebElement searchbox1 = driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
		searchbox1.sendKeys("Ganesh kumar",Keys.ENTER);
		Thread.sleep(3000);
		System.out.print("The Lead was deleted successfully");
	
	}

}
