package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		// Adding wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// To enter the username and password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		System.out.println("username and password provided successfully");
		
		// To click on submit button
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// To click on on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		// To click on on Create lead link
		driver.findElement(By.linkText("Create Lead")).click();
		System.out.println("At Create lead page");
		
		// clicking on the find lead 
		System.out.println("click Find leads");
		driver.findElement(By.linkText("Find Leads")).click();
		
		//clicking on the phone number
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		//Enter the phone details
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("91");
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("01");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("8056100692");
		
		// clicking on the find lead
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//sleep
		Thread.sleep(3000);
		//finding the first lead ID
		String text = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a")).getText();
		System.out.println("The lead ID which is going to delete is : "+text);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a")).click();
		System.out.println("selecting the first lead link");
		
		
		
		//Deleting the first lead ID
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		// clicking on the find lead 
		System.out.println("click on the Find leads again after deleting");
		driver.findElement(By.linkText("Find Leads")).click();
		
		
		//sending the deleted lead ID
		driver.findElement(By.xpath("(//label[text()='Lead ID:']//following::div//input)[1]")).sendKeys(text);
		// clicking on the find lead
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		
		
		boolean displayed = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
		if (displayed) {
			System.out.println("No records found for the " +text + " ID");
			
		}
		else {
			System.out.println(text + " ID is available");
		}
		
		//closing the browser
		driver.close();
		System.out.println("Browser is closed");
	}

}
