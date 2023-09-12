

package Selenium1.Selenium1;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Seleniumprgm1 {

	public static WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
	}

	@Test
	public void openBrowser() throws InterruptedException {

		// Open the URL Window
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("URL is Opened");

		// Maximize the Window
		driver.manage().window().maximize();
		System.out.println("Window is Maximized");

		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void verifyTitle() throws InterruptedException {
		String etitle = "Practice Page";

		// Get the title of Current Window
		String atitle = driver.getTitle();
		System.out.println(atitle);

		// Comparing the actual and expected title
		if(etitle.equals(atitle)) {
			System.out.println("TEST PASSED");
		}
		else {
			System.out.println("TEST FAILED");
		}
	}

	@Test(priority = 2)
	public void RadioButton() throws InterruptedException {
		// Selecting the Radio Button
		driver.findElement(By.xpath("//input[@value='radio1']")).click();
		Thread.sleep(3000);
		System.out.println("Radio Button is Selected");

		// Suggession 
		driver.findElement(By.id("autocomplete")).sendKeys("India");
		System.out.println("Suggesion Class is Entered");

	}

	@Test(priority = 3)
	public void dropdown() throws InterruptedException {
		// Dropdown
		WebElement drp= driver.findElement(By.name("dropdown-class-example"));
		Select se = new Select(drp);
		Thread.sleep(3000);
		se.selectByValue("option3");
		System.out.println("Dropdown is Done");
		//se.selectByVisibleText("Option3");

		//driver.findElement(By.name("dropdown-class-example")).sendKeys("Option3");

		//driver.findElement(By.xpath("//*[@id="dropdown-class-example"]/option[3]")).click();
	}

	@Test(priority = 4)
	public void checkbox() throws InterruptedException {
		// CheckBox
		driver.findElement(By.id("checkBoxOption3")).click();
		Thread.sleep(3000);
		System.out.println("Checkbox is Selected");
	}

	@Test(priority = 5)
	public void WindowHandling() throws InterruptedException {
		// Open New Window
		driver.findElement(By.id("openwindow")).click();
		System.out.println("New Window is Opened");

		// Window Handling
		String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();

		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

			String child_window=I1.next();


			if(!parent.equals(child_window))
			{
				// Switch to Parent Window to Child Window
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

				String exptitle = "QAClick Academy - A Testing Academy to Learn, Earn and Shine";

				String acttitle = driver.getTitle();

				// Comparing the actual and expected title
				if(exptitle.equals(acttitle)) {
					System.out.println(" WIN2 TEST PASSED");
				}
				else {
					System.out.println("WIN2 TEST FAILED");

				}

				Thread.sleep(3000);

				// Scroll down the window
				JavascriptExecutor jsc = (JavascriptExecutor) driver;
				jsc.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(5000);


				// Scroll up the window
				jsc.executeScript("window.scrollTo(document.body.scrollHeight,0)");

				Thread.sleep(5000);

				// Close the Current Window
				driver.close();

			}

		}


		// Switch to Parent Window
		driver.switchTo().window(parent);
		System.out.println("Switched to Parent Window");
		Thread.sleep(5000);
	}


	@Test(priority = 6)
	public void othertab() throws InterruptedException {
		// Open the New Tab
		driver.findElement(By.xpath("//*[@id='opentab']")).click();
		System.out.println("New Tab is Opened");

		// Window Handling
		String parent1=driver.getWindowHandle();

		Set<String>s1=driver.getWindowHandles();

		Iterator<String> I2= s1.iterator();

		while(I2.hasNext())
		{

			String child1_window=I2.next();

			if(!parent1.equals(child1_window))
			{
				// Switch to New Tab from Parent Tab
				driver.switchTo().window(child1_window);

				System.out.println(driver.switchTo().window(child1_window).getTitle());

				String exptitle = "Selenium, API Testing, Software Testing & More QA Tutorials | Rahul Shetty Academy";

				String acttitle = driver.getTitle();

				// Comparing the actual and expected title
				if(exptitle.equals(acttitle)) {
					System.out.println(" WIN3 TEST PASSED");
				}
				else {
					System.out.println("WIN3 TEST FAILED");

				}

				Thread.sleep(5000);

				// Scrolling the Child Window
				JavascriptExecutor jsc = (JavascriptExecutor) driver;
				jsc.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(5000);

				//Switch to child to another Window in same tab
				driver.findElement(By.xpath("//*[@class='btn btn-primary view-all-courses-btn']")).click();

				WebElement a = driver.findElement(By.id("search-courses"));
				Actions act = new Actions(driver);
				act.moveToElement(a).click().

				// Searching By content using KeyBoard
				keyDown(a,Keys.SHIFT).sendKeys(a,"postman").
				keyUp(a,Keys.SHIFT).build().perform();

				driver.findElement(By.id("search-course-button")).click();
				jsc.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(5000);

				//Navigating Back to Previous Window
				driver.navigate().back();
				Thread.sleep(5000);

				//Navigating Back to Child Window
				driver.navigate().back();
				Thread.sleep(5000);

				//Closing the Child Window
				driver.close();
			}	
		}

		// Switching back to Home Page
		driver.switchTo().window(parent1);
		System.out.println("Once again Switched to Home Page");

		Thread.sleep(5000);
	}


	@Test(priority = 7)
	public void alert1() throws InterruptedException {
		driver.findElement(By.id("name")).sendKeys("Rachana");
		Thread.sleep(5000);

		//Alert Button 

		JavascriptExecutor jscm = (JavascriptExecutor) driver;
		((JavascriptExecutor)jscm).executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

		//Confirmation Alert
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
		System.out.println("Alert is Resolved");
	}

	@Test(priority = 8)
	public void webtable() throws InterruptedException {
		//to find row and columns in webtable
		int r = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr")).size();
		System.out.println("Webtable row size =   "+r);

		int c = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th")).size();
		System.out.println("Webtable column size =  "+c);

		//Printing all the elements of Webtable
		System.out.println();
		System.out.println("Content of WebTable:");
		for(int i =2;i<=r;i++) {
			for(int j =1;j<=c;j++) {

				System.out.print(driver.findElement(By.xpath("//table[@class='table-display']/tbody/tr["+i+"]/td["+j+"]")).getText()+" ");
			}

			System.out.println();
		}
		System.out.println();
	}

	@Test(priority = 9)
	public void hideshow() throws InterruptedException {
		//Element Displayed(Hide or Show)
		WebElement TextBox = driver.findElement(By.id("displayed-text"));
		TextBox.sendKeys("Data Template");
		System.out.println("TextBox Displayed : "+TextBox.isDisplayed());
		Thread.sleep(5000);

		WebElement Hide = driver.findElement(By.id("hide-textbox"));
		Hide.click();
		System.out.println("Clicked on Hide Button");
		Thread.sleep(5000);

		WebElement Shown = driver.findElement(By.id("show-textbox"));
		Shown.click();
		System.out.println("Clicked on Shown Button");
		Thread.sleep(5000);
	}

	@Test(priority = 10)
	public void fixedheader() throws InterruptedException {
		//Webtable Fixed Header
		int Fixr = driver.findElements(By.xpath("//*[@class='tableFixHead']//th")).size();
		System.out.println("Webtable row size =   "+Fixr);

		int Fixc = driver.findElements(By.xpath("//*[@class='tableFixHead']//tr")).size();
		System.out.println("Webtable column size =  "+Fixc);
		System.out.println();

		//Printing all the elements of Webtable
		// printing fixed header elements

		for(int i =1;i<=Fixr;i++) {
			System.out.print(driver.findElement(By.xpath("//*[@class='tableFixHead']//th["+i+"]")).getText()+" ");
		}
		System.out.println();

		//printing table contents
		for(int i =1;i<=Fixr;i++) {
			System.out.print(driver.findElement(By.xpath("//*[@class='tableFixHead']//td["+i+"]")).getText()+" ");
		}
		System.out.println();

		for(int j =2;j<=Fixc-1;j++) {

			int i=0;
			System.out.print(driver.findElement(By.xpath("//*[@class='tableFixHead']//tr["+j+"]")).getText()+" ");
			++i;
			System.out.println();
			if(i == 4) {
				System.out.println();
				i =0;
			}			
		}
		String amt = driver.findElement(By.xpath("//*[@class='totalAmount']")).getText();
		System.out.println(amt);
		System.out.println();
	}

	@Test(priority = 11)
	public void mouseover() throws InterruptedException {
		//MouseOver Action

		JavascriptExecutor jsc = (JavascriptExecutor) driver;
		((JavascriptExecutor)jsc).executeScript("window.scrollBy(0,1250)", "");
		Thread.sleep(3000);

		System.out.println("MouseOver Action");
		Actions act = new Actions(driver);
		WebElement mover = driver.findElement(By.id("mousehover"));
		WebElement top = driver.findElement(By.xpath("/html/body/div[4]/div/fieldset/div/div/a[1]"));
		WebElement reload = driver.findElement(By.xpath("/html/body/div[4]/div/fieldset/div/div/a[2]"));

		act.moveToElement(mover).build().perform();
		Thread.sleep(3000);
		act.moveToElement(top).click().build().perform();
		Thread.sleep(3000);
		act.moveToElement(mover).build().perform();
		Thread.sleep(3000);
		act.moveToElement(reload).click().build().perform();
		Thread.sleep(3000);
		System.out.println("MouseOver Action Completed");
	}

	@Test(priority = 12)
	public void iframe() throws InterruptedException {
		//iframe
		JavascriptExecutor jsc12 = (JavascriptExecutor) driver;
		((JavascriptExecutor)jsc12).executeScript("window.scrollBy(0,1450)", "");
		Thread.sleep(3000);

		System.out.println("Switches to iframe");
		driver.switchTo().frame(driver.findElement(By.id("courses-iframe")));
		Thread.sleep(3000);
		JavascriptExecutor jsci = (JavascriptExecutor) driver;
		jsci.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		System.out.println("Scrolling happened");
	}

	@Test(priority = 13)
	public void homepage() throws InterruptedException {
		//Switching to Home window
		driver.switchTo().defaultContent();
		JavascriptExecutor jsch = (JavascriptExecutor) driver;
		jsch.executeScript("window.scrollTo(1450, document.body.scrollHeight)");		
		Thread.sleep(3000);

		System.out.println("Switched to home window");

		Thread.sleep(3000);
		driver.close();
		Thread.sleep(3000);
	}


}
