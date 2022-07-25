package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		
		// Entering the first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Jaison");
		System.out.println("click Find leads button");
		Thread.sleep(3000);
		
		// clicking on the find lead
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		System.out.println("click on the first leads search ID");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a")).click();
		System.out.println("selecting on the first leads search ID");
		String title = driver.getTitle();
		
		// checking the title page
		System.out.println("The page is now at the  :" + title);
		driver.findElement(By.linkText("Edit")).click();
		
		// Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("EY");

		// Click Update
		driver.findElement(By.name("submitButton")).click();
		
		// Confirm the changed name appears
		
		System.out.println(
				"The updated company name is : " + driver.findElement(By.id("viewLead_companyName_sp")).getText());
		
		// Close the browser (Do not log out)
		Thread.sleep(3000);
		driver.close();

	}
}
