package Selenium1.Selenium1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chromedriver","driver.chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();

		//int r = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr")).size();
		//System.out.println("Webtable row size =   "+r);
		
		//int c = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/th")).size();
		//System.out.println("Webtable column size =  "+c);
		
		//for(int i =2;i<=r;i++) {
		//for(int j =1;j<=c;j++) {
				
		//	System.out.print(driver.findElement(By.xpath("//table[@class='table-display']/tbody/tr["+i+"]/td["+j+"]")).getText()+" "+" ");
		//}
			
		//	System.out.println();
		// }
		
		
		//WebElement TextBox = driver.findElement(By.id("displayed-text"));
		//TextBox.sendKeys("Data Template");
		//System.out.println("TextBox Displayed : "+TextBox.isDisplayed());
		//Thread.sleep(2000);
		
		//WebElement Hide = driver.findElement(By.id("hide-textbox"));
		//Hide.click();
		//System.out.println("Clicked on Hide Button");
		//Thread.sleep(2000);
		
		//WebElement Shown = driver.findElement(By.id("show-textbox"));
		//Shown.click();
		//System.out.println("Clicked on Shown Button");
		//Thread.sleep(2000);
		
	   //int r = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr")).size();
//		int Fixr = driver.findElements(By.xpath("//*[@class='tableFixHead']//th")).size();
//		System.out.println("Webtable row size =   "+Fixr);
//		
//		int Fixc = driver.findElements(By.xpath("//*[@class='tableFixHead']//tr")).size();
//		System.out.println("Webtable column size =  "+Fixc);
//	
//		//Printing all the elements of Webtable
//		//for(int i =1;i<=Fixr;i++) {
//		//	for(int j =1;j<=Fixc;j++) {
//				
//				
//		//System.out.print(driver.findElement(By.xpath("//*[@class='tableFixHead']/th["+i+"]/tr/td["+j+"]")).getText()+" ");
//		//}
//			
//			//System.out.println();
//			
//		//}//*[@id="product"]/thead/tr/th[2]
//		for(int i =1;i<=Fixr;i++) {
//		System.out.print(driver.findElement(By.xpath("//*[@class='tableFixHead']//th["+i+"]")).getText()+" ");
//		}
//		System.out.println();
//		
//		for(int i =1;i<=Fixr;i++) {
//		System.out.print(driver.findElement(By.xpath("//*[@class='tableFixHead']//td["+i+"]")).getText()+" ");
//		}
//		System.out.println();
//		
//		for(int j =2;j<=Fixc-1;j++) {
//			
//			 int i=0;
//			System.out.print(driver.findElement(By.xpath("//*[@class='tableFixHead']//tr["+j+"]")).getText()+" ");
//		
//			++i;
//			System.out.println();
//			if(i == 4) {
//				System.out.println();
//			 	i =0;
//			}
//			
//		}
//		String amt = driver.findElement(By.xpath("//*[@class='totalAmount']")).getText();
//    	System.out.println(amt);
//		
		// MouseOver Action
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
		
		//iframe
//		JavascriptExecutor jsc = (JavascriptExecutor) driver;
//		((JavascriptExecutor)jsc).executeScript("window.scrollBy(0,1450)", "");
//		Thread.sleep(3000);
//		
//		System.out.println("Switches to iframe");
//		driver.switchTo().frame(driver.findElement(By.id("courses-iframe")));
//		Thread.sleep(3000);
//		JavascriptExecutor jsci = (JavascriptExecutor) driver;
//		jsci.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		Thread.sleep(3000);
//		System.out.println("Scrolling happened");
//		driver.switchTo().defaultContent();
//		JavascriptExecutor jsch = (JavascriptExecutor) driver;
//		jsc.executeScript("window.scrollTo(1450, document.body.scrollHeight)");		
//		Thread.sleep(3000);
//		
//		System.out.println("Switched to home window");
//		
		
//		JavascriptExecutor jscm = (JavascriptExecutor) driver;
//		((JavascriptExecutor)jscm).executeScript("window.scrollBy(0,300)", "");
//		Thread.sleep(3000);


		
	}
}
