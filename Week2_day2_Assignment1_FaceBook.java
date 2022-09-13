package seleniumJavaWeek2.day2;

import java.sql.DriverManager;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week2_day2_Assignment1_FaceBook {
	
	public static void main(String[] args) {
		
		// Step 1: Download and set the path 
		WebDriverManager.chromedriver().setup();
		
		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		
		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		
		// Step 4: Maximise the window
		driver.manage().window().maximize();
		
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		// Step 6: Click on Create New Account button
		//driver.findElement(By.linkText("//a[contains(text(),'Create New Account')]")).click();
		//driver.findElement(By.linkText("//a[@data-testid='open-registration-form-button']")).click();
		driver.findElement(By.xpath("//form[@data-testid='royal_login_form']//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

		// Step 7: Enter the first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Bala");
		
		// Step 8: Enter the last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Balu");
		
		// Step 9: Enter the mobile number
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9176700957");
		
		// Step 10: Enter the password
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("everlove@1986");
			
		// Step 11: Handle all the three drop downs
		
			//day
			WebElement dayddown = driver.findElement(By.xpath("//select[@name='birthday_day']"));
			
			Select daydd = new Select(dayddown);
			
			daydd.selectByValue("1");
		
			//month
			WebElement monthddown = driver.findElement(By.xpath("//select[@name='birthday_month']"));
			
			Select monthdd = new Select(monthddown);
			
		//	monthdd.selectByValue("Aug");
			monthdd.selectByIndex(7);
		
			//year
			WebElement yearddown = driver.findElement(By.xpath("//select[@name='birthday_year']"));
			
			Select yeardd = new Select(yearddown);
			
			yeardd.selectByValue("1985");
			
		// Step 12: Select the radio button "Female" 
			
			driver.findElement(By.xpath("//input[@class='_8esa']")).click();
	}

}
