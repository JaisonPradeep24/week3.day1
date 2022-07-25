package week2.day2;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundAssignments {

	public static void main(String[] args) throws InterruptedException {

		editFields();
		editButton();
		linkHtml();
		checkBox();
		dropDown();
		tables();
		image();

	}

	public static void editFields() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();

		String title = driver.getTitle();
		System.out.println("The title of the current page is : " + title);

		// Enter the email address
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");

		// Apend the text
		driver.findElement(By.xpath("(//label[text()='Append a text and press keyboard tab']/following::input)[1]"))
				.sendKeys(Keys.TAB);

		// to check the attribute of the tag using getAttribute
		System.out.println(
				"The attribute of the value is : " + driver.findElement(By.name("username")).getAttribute("value"));

		// to clear the text
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();

		// Edit field is disabled
		boolean enabled = driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();

		if (enabled) {
			System.out.println("Confirm that field is enabled");

		} else {
			System.out.println("Confirm that field is NOT enabled !!!");
		}

	}

	public static void editButton() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("The title of the current page is : " + title);

		// To find the color using getCssValue
		String cssValue = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println("The color if the element is : " + cssValue);

		// Checking the left hand corner of the element
		System.out.println("The size of Left hand corner of the element is : "
				+ driver.findElement(By.xpath("//button[text()='Get Position']")).getLocation());

		// Checking the size
		System.out.println("The height of the screen is : " + driver.findElement(By.id("size")).getSize());

		// To navigate to the next page
		driver.findElement(By.xpath("//button[text()='Go to Home Page']")).click();
	}

	public static void linkHtml() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		String title = driver.getTitle();

		// Title of the page
		System.out.println("The title of the current page is : " + title);
		Thread.sleep(3000);

		// Find where am supposed to go without clicking me?
		String attribute = driver
				.findElement(By.xpath("//a[text()='Find where am supposed to go without clicking me?']"))
				.getAttribute("href");
		System.out.println("The page is routed to " + attribute + "  but without clicking it");

		// Verify am I broken
		System.out.println("The page is directed to : "
				+ driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).getAttribute("href"));

		// How many links are available in the page
		System.out.println("The page has these many links : "
				+ driver.findElement(By.xpath("//a[text()='How many links are available in this page?']"))
						.getAttribute("href"));

		// go to home page
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click();
	}

	public static void checkBox() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("The title of the current page is : " + title);

		// clicking on the java and SQL language
		System.out.println("Java is not selected : "
				+ driver.findElement(By.xpath("(//div[@class='example']/preceding::input)[1]")).isSelected());

		// Clicking Java and SQL
		driver.findElement(By.xpath("(//div[@class='example']/preceding::input)[1]")).click();
		driver.findElement(By.xpath("(//div[@class='example']/preceding::input)[3]")).click();

		// confirming the selenium is selected or not
		System.out.println("Checking the selenium checkbox is selected or not : "
				+ driver.findElement(By.xpath("(//label[text()='Confirm Selenium is checked']/following::input)[1]"))
						.isSelected());

		// deselecting the only checked
		driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]")).click();

		// Selecting all check box
		driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[1]")).click();
		driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[2]")).click();
		driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[3]")).click();
		driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[4]")).click();
		driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[5]")).click();
		driver.findElement(By.xpath("(//label[text()='Select all below checkboxes ']/following::input)[6]")).click();

	}

	public static void dropDown() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("The title of the current page is : " + title);

		// Selecting selenium using Index
		WebElement usIndex = driver.findElement(By.id("dropdown1"));
		Select usingIndex = new Select(usIndex);
		usingIndex.selectByIndex(1);

		// Selecting selenium using Text
		WebElement usTxt = driver.findElement(By.name("dropdown2"));
		Select usText = new Select(usTxt);
		usText.selectByVisibleText("Selenium");

		// Selecting selenium using value
		WebElement usVale = driver.findElement(By.id("dropdown3"));
		Select usValue = new Select(usVale);
		usValue.selectByValue("1");

		// checking how many drop downs available
		// WebElement findElement = driver.findElement(By.xpath("//option[text()='Get
		// the number of dropdown options']"));

		// Get num of dropdown options
		Actions action = new Actions(driver);
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@class='dropdown']")));
		java.util.List<WebElement> list = dropdown.getOptions();
		System.out.println("Number of dropdown options listed are: " + list.size());
		action.sendKeys(Keys.TAB);

		WebElement selectProgram = driver
				.findElement(By.xpath("//option[text() ='You can also use sendKeys to select']/following::option[1]"));
		selectProgram.click();

		// select the program
		WebElement program = driver.findElement(By.xpath("//option[text()='Select your programs']"));
		System.out.println(program.isEnabled());

	}

	public static void tables() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/table.html");
		driver.manage().window().maximize();

		// To check the number of columns
		java.util.List<WebElement> columns = driver.findElements(By.tagName("th"));
		System.out.println("Number of columns:" + columns.size());

		// To check the number of rows
		java.util.List<WebElement> rows = driver.findElements(By.tagName("tr"));
		System.out.println("Number of rows:" + rows.size());

		Thread.sleep(1000);
		java.util.List<WebElement> interactList = driver
				.findElements(By.xpath("//font[contains(text(),'Learn to interact')]/following::td"));
		for (int i = 0; i < interactList.size(); i++) {
			String act1 = interactList.get(i).getText();
			System.out.println(act1);
		}

	}

	private static void image() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();

		// click on the image to go to home page
		driver.findElement(By.xpath("//label[text()='Click on this image to go home page']/following::img")).click();
		driver.findElement(By.xpath("//h5[text()='Image']/following::img")).click();

		// Am i broken image
		WebElement imageDisplay = driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following::img"));
		if (imageDisplay.getAttribute("naturalWidth").equals("0")) {

			System.out.println("The image is broken");
		}

		driver.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img"))
				.click();

	}

}
