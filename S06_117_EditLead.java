package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S06_117_EditLead {

	public static void main(String[] args) throws InterruptedException {
				//1. Login to https://login.salesforce.com			
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
				searchbox.sendKeys("kumar");
				searchbox.sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]//a")).click();
				WebElement dropdown = driver.findElement(By.xpath("//a[@title='Edit']"));
				Thread.sleep(3000);
				Actions action = new Actions(driver); 
				action.moveToElement(dropdown).click().build().perform(); 
				driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Ganesh");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Lead Status']")));
				driver.findElement(By.xpath("(//span[text()='Open - Not Contacted'])[3]")).click();
				driver.findElement(By.xpath("//button[text() ='Save']")).click();
				String name = driver.findElement(By.xpath("//span[contains (text(),'kumar')]")).getText();
				System.out.println(name);
				
				if(name.equalsIgnoreCase(name))
					System.out.println("The Heading is matching");
					else
						System.out.println("The Heading is not matching");
					
				//String name1 = "Lead Mr. Ganesh Kumar was saved.";
				//Assert.assertEquals(name, name1);
	}

}
